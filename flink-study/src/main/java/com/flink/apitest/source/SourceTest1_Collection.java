package com.flink.apitest.source;

import com.flink.apitest.beans.SensorReading;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

import java.util.Arrays;

/**
 * @ClassName SourceTest1_Collection
 * @Description
 * @Author wzj
 * @Date 2021/2/25 17:29
 **/

public class SourceTest1_Collection {

    public static void main(String args[]) throws Exception {

        //创建执行环境
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.setParallelism(1);//设置为顺序执行

        // 从集合中读取数据
        DataStream<SensorReading> dataStream = env.fromCollection(Arrays.asList(
                new SensorReading("sensor_1", 1547718201L, 12.3),
                new SensorReading("sensor_6", 1547718221L, 17.3),
                new SensorReading("sensor_7", 1547718241L, 1.3),
                new SensorReading("sensor_10", 1547718001L, 2.3)));

        DataStream<Integer> integerDataStream = env.fromElements(1, 2, 4, 67, 189);

        //打印输出
        dataStream.print("data");
        integerDataStream.print("int");

        //执行
        env.execute();
    }
}
