package com.flink.apitest.window;

import com.flink.apitest.beans.SensorReading;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.windowing.time.Time;

/**
 * @ClassName WindowTest1_TimeWindow
 * @Description
 * @Author wzj
 * @Date 2021/3/4 19:07
 **/

public class WindowTest1_TimeWindow {

    public static void main(String args[]) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.setParallelism(4);

        // 从文件中读取数据
        DataStream<String> inputStream =
                env.readTextFile(
                        "/Users/mac/IdeaProjects/LocalTest/flink-study/src/main/resources/sensor.txt");

        DataStream<SensorReading> dataStream = inputStream.map(line -> {
            String fields[] = line.split(", ");
            return new SensorReading(fields[0], new Long(fields[1]), new Double(fields[2]));
        });

        //开窗测试
        dataStream.keyBy("id")
//                .countWindow(10, 2)
//                .window(EventTimeSessionWindows.withGap(Time.minutes(1)));
                .timeWindow(Time.seconds(15));
//                .window(TumblingProcessingTimeWindows.of(Time.seconds(15)));

        env.execute();
    }
}
