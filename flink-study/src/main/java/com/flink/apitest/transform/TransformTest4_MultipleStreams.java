package com.flink.apitest.transform;

import com.flink.apitest.beans.SensorReading;
import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.api.java.tuple.Tuple3;
import org.apache.flink.streaming.api.collector.selector.OutputSelector;
import org.apache.flink.streaming.api.datastream.ConnectedStreams;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.datastream.SplitStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.functions.co.CoMapFunction;

import java.util.Collections;

/**
 * @ClassName TransformTest4_MultipleStreams
 * @Description
 * @Author wzj
 * @Date 2021/3/2 17:24
 **/

public class TransformTest4_MultipleStreams {

    public static void main(String args[]) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.setParallelism(1);

        // 从文件中读取数据
        DataStream<String> inputStream =
                env.readTextFile(
                        "/Users/mac/IdeaProjects/LocalTest/flink-study/src/main/resources/sensor.txt");

        DataStream<SensorReading> dataStream = inputStream.map(line -> {
            String fields[] = line.split(", ");
            return new SensorReading(fields[0], new Long(fields[1]), new Double(fields[2]));
        });

        //1、分流，按照温度值为15度为界分为两条流
        SplitStream<SensorReading> split = dataStream.split(new OutputSelector<SensorReading>() {
            @Override
            public Iterable<String> select(SensorReading sensorReading) {
                return (sensorReading.getTemperature() > 15
                        ? Collections.singletonList("high")
                        : Collections.singletonList("low"));
            }
        });

        DataStream<SensorReading> high = split.select("high");

        DataStream<SensorReading> low = split.select("low");

        DataStream<SensorReading> all = split.select("high", "low");

        high.print("high");
        low.print("low");
        all.print("all");

        //合流 connect 将高温流转换成二元组类型，与低温流链接合并后，输出状态信息
        DataStream<Tuple2<String, Double>> warningStream = high.map(new MapFunction<SensorReading, Tuple2<String, Double>>() {
            @Override
            public Tuple2<String, Double> map(SensorReading sensorReading) throws Exception {
                return new Tuple2<>(sensorReading.getId(), sensorReading.getTemperature());
            }
        });

        ConnectedStreams<Tuple2<String, Double>, SensorReading> connecteStreams = warningStream.connect(low);

        DataStream<Object> resultStream = connecteStreams.map(new CoMapFunction<Tuple2<String, Double>, SensorReading, Object>() {

            @Override
            public Object map1(Tuple2<String, Double> v1) throws Exception {
                return new Tuple3<>(v1.f0, v1.f1, "high temp warning");
            }

            @Override
            public Object map2(SensorReading sensorReading) throws Exception {
                return new Tuple2<>(sensorReading.getId(), "normal");
            }
        });

        resultStream.print();

        //3 union联合多条流
        high.union(low, all);

        env.execute();

    }
}
