package com.flink.apitest.source;

import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

/**
 * @ClassName SourceTest2_File
 * @Description
 * @Author wzj
 * @Date 2021/2/25 17:48
 **/

public class SourceTest2_File {
    public static void main(String args[]) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.setParallelism(1);

        //从文件中读取数据
        DataStream<String> dataStream = env.readTextFile(
                "/Users/mac/IdeaProjects/LocalTest/flink-study/src/main/resources/sensor.txt");

        //打印输出
        dataStream.print();

        env.execute();
    }
}
