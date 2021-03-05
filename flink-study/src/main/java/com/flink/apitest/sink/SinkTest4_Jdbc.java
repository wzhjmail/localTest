package com.flink.apitest.sink;

import com.flink.apitest.beans.SensorReading;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.functions.sink.RichSinkFunction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * @ClassName SinkTest4_Jdbc
 * @Description
 * @Author wzj
 * @Date 2021/3/4 17:34
 **/

public class SinkTest4_Jdbc {
    public static void main(String args[]) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.setParallelism(4);

        // 从文件中读取数据
        DataStream<String> inputStream =
                env.readTextFile(
                        "/Users/mac/IdeaProjects/LocalTest/flink-study/src/main/resources/sensor.txt");

        DataStream<SensorReading> dataStream =
                inputStream.map(
                        line -> {
                            String fields[] = line.split(", ");
                            return new SensorReading(fields[0], new Long(fields[1]), new Double(fields[2]));
                        });

        dataStream.addSink(new MyJdbcSink());

        env.execute();
    }

    // 实现自定义的sinkFunction
    public static class MyJdbcSink extends RichSinkFunction<SensorReading> {
        Connection connection = null;
        PreparedStatement insertStmt = null;
        PreparedStatement updateStmt = null;

        @Override
        public void open(Configuration parameters) throws Exception {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
            insertStmt = connection.prepareStatement("insert into sessor_temp (id, temp) values (?, ?)");
            updateStmt = connection.prepareStatement("update sessor_temp set temp = ? where id = ?");
        }

        //每来一条数据，调用链接，执行sql
        @Override
        public void invoke(SensorReading value, Context context) throws Exception {
            //直接执行更新语句，如果咩有更新那么就插入
            updateStmt.setDouble(1, value.getTemperature());
            updateStmt.setString(2, value.getId());
            updateStmt.execute();
            if (updateStmt.getUpdateCount() == 0) {
                insertStmt.setString(1, value.getId());
                insertStmt.setDouble(2, value.getTemperature());
                insertStmt.execute();
            }

        }

        @Override
        public void close() throws Exception {
            insertStmt.close();
            updateStmt.close();
            connection.close();
        }
    }
}
