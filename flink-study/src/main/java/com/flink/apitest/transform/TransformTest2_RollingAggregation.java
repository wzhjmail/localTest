package com.flink.apitest.transform;

import com.flink.apitest.beans.SensorReading;
import org.apache.flink.api.java.tuple.Tuple;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.datastream.KeyedStream;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

/**
 * @ClassName TransformTest2_RollingAggregation
 * @Description
 * @Author wzj
 * @Date 2021/3/2 16:23
 **/

public class TransformTest2_RollingAggregation {

    public static void main(String args[]) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.setParallelism(1);

        //从文件中读取数据
        DataStream<String> inputStream = env.readTextFile("/Users/mac/IdeaProjects/LocalTest/flink-study/src/main/resources/sensor.txt");

        //转换程SensorReading类型
//        DataStream<SensorReading> dataStream = inputStream.map(new MapFunction<String, SensorReading>() {
//            @Override
//            public SensorReading map(String s) throws Exception {
//                String[] fileds = s.split(",");
//                return new SensorReading(fileds[0], new Long(fileds[1]), new Double(fileds[2]));
//            }
//        });

        DataStream<SensorReading> dataStream = inputStream.map(line -> {
            String fields[] = line.split(", ");
            return new SensorReading(fields[0], new Long(fields[1]), new Double(fields[2]));
        });

        // 分组
        KeyedStream<SensorReading, Tuple> keyedStream = dataStream.keyBy("id");
//        KeyedStream<SensorReading, String> keyedStream1 = dataStream.keyBy(data -> data.getId());

        //滚动聚合，取当前最大的温度值
        SingleOutputStreamOperator<SensorReading> resultStream = keyedStream.max("temperature");

        resultStream.print();

        env.execute();
    }
}
