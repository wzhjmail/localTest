package com.flink;

import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.api.java.utils.ParameterTool;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

/**
 页面查看结果localhost:8081
 --host localhost --port 7777
 控制台直接输入nc -lk 7777
 * @ClassName StreamWordCount
 * @Description
 * @Author wzj
 * @Date 2021/2/18 18:22
 **/

public class StreamWordCount {
    public static void main(String args[]) throws Exception {
        //创建流处理执行环境
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        //env.setParallelism(8);//设置并行度的大小

        //从文件中读取数据
//        String inputPath = "/Users/mac/IdeaProjects/LocalTest/flink-study/src/main/resources/hello.txt";
//        DataStream<String> inputDataStream = env.readTextFile(inputPath);

        //控制台直接输入nc -lk 7777
        //用parameter tool工具从程序启动参数中提取配置项
        ParameterTool parameterTool = ParameterTool.fromArgs(args);
        String host = parameterTool.get("host");
        int port = parameterTool.getInt("port");

        //从socket文本流中读取数据
        DataStream<String> inputDataStream = env.socketTextStream(host, port);

        //基于数据流进行转换计算
        DataStream<Tuple2<String, Integer>> resultStream = inputDataStream.flatMap(new WordCount.MyFlatMapper())
                .keyBy(0)
                .sum(1);

        resultStream.print();

        //执行任务
        env.execute();
    }
}
