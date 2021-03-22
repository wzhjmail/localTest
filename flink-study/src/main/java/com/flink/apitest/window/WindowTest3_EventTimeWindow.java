package com.flink.apitest.window;

import com.flink.apitest.beans.SensorReading;
import org.apache.flink.streaming.api.TimeCharacteristic;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

/**
 * @ClassName WindowTest3_EventTimeWindow
 * @Description
 * @Author wzj
 * @Date 2021/3/8 18:20
 **/

public class WindowTest3_EventTimeWindow {

    public static void main(String args[]) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.setParallelism(1);
        env.setStreamTimeCharacteristic(TimeCharacteristic.EventTime);

        //socket文本流
        DataStream<String> inputStream = env.socketTextStream("localhost", 7777);

        DataStream<SensorReading> dataStream = inputStream.map(line -> {
            String fields[] = line.split(", ");
            return new SensorReading(fields[0], new Long(fields[1]), new Double(fields[2]));
        });


        env.execute();

    }
}
