package com.flink.apitest.transform;

import com.flink.apitest.beans.SensorReading;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

/**
 * @ClassName TransformTest6_Partition
 * @Description
 * @Author wzj
 * @Date 2021/3/3 18:47
 **/

public class TransformTest6_Partition {
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

        dataStream.print("input>");

        //1、shuffle 洗牌
        DataStream<String> shuffleStream = inputStream.shuffle();
//        shuffleStream.print("shuffle>");

        //keyBy
//        dataStream.keyBy("id").print("keyBy");

        //global 放到第一个槽中
        dataStream.global().print("global>");

        env.execute();

    }
}

