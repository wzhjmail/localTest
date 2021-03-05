package com.flink.apitest.sink;

import com.flink.apitest.beans.SensorReading;
import org.apache.flink.api.common.serialization.SimpleStringSchema;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaProducer011;

/**
 * @ClassName SinkTest1_Kafka
 * @Description
 * @Author wzj
 * @Date 2021/3/3 18:48
 **/

public class SinkTest1_Kafka {

    public static void main(String args[]) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.setParallelism(4);

        // 从文件中读取数据
        DataStream<String> inputStream =
                env.readTextFile(
                        "/Users/mac/IdeaProjects/LocalTest/flink-study/src/main/resources/sensor.txt");

        DataStream<String> dataStream = inputStream.map(line -> {
            String fields[] = line.split(", ");
            return new SensorReading(fields[0], new Long(fields[1]), new Double(fields[2])).toString();
        });

        dataStream.addSink(new FlinkKafkaProducer011<String>("localhost:9092", "sinktest", new SimpleStringSchema()));

        env.execute();
    }
}

