package com.flink.apitest.window;

import com.flink.apitest.beans.SensorReading;
import org.apache.commons.collections.IteratorUtils;
import org.apache.flink.api.common.functions.AggregateFunction;
import org.apache.flink.api.java.tuple.Tuple;
import org.apache.flink.api.java.tuple.Tuple3;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.functions.windowing.WindowFunction;
import org.apache.flink.streaming.api.windowing.time.Time;
import org.apache.flink.streaming.api.windowing.windows.TimeWindow;
import org.apache.flink.util.Collector;
import org.apache.flink.util.OutputTag;

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

        //socket 文本流
        DataStream<String> inputStream = env.socketTextStream("localhost", 7777);

        DataStream<SensorReading> dataStream = inputStream.map(line -> {
            String fields[] = line.split(", ");
            return new SensorReading(fields[0], new Long(fields[1]), new Double(fields[2]));
        });

        //1、增量窗口测试
        //开窗测试
        DataStream<Integer> resultStream = dataStream.keyBy("id")
//                .countWindow(10, 2)
//                .window(EventTimeSessionWindows.withGap(Time.minutes(1)));
//                .window(TumblingProcessingTimeWindows.of(Time.seconds(15)));
//                .reduce(new ReduceFunction<SensorReading>() {
//                    @Override
//                    public SensorReading reduce(SensorReading sensorReading, SensorReading t1) throws Exception {
//                        return null;
//                    }
//                });
                .timeWindow(Time.seconds(15))
                .aggregate(new AggregateFunction<SensorReading, Integer, Integer>() {
                    @Override
                    public Integer createAccumulator() {
                        return null;
                    }

                    @Override
                    public Integer add(SensorReading sensorReading, Integer accumulator) {
                        return accumulator + 1;
                    }

                    @Override
                    public Integer getResult(Integer integer) {
                        return integer;
                    }

                    @Override
                    public Integer merge(Integer a, Integer b) {
                        return a + b;
                    }
                });
//        resultStream.print();

        //2、全窗口函数
        DataStream<Tuple3<String, Long, Integer>> resultStream2 = dataStream.keyBy("id")
                .timeWindow(Time.seconds(15))
//                .process(new ProcessWindowFunction<SensorReading, Object, Tuple, TimeWindow>() {
//                })
                .apply(new WindowFunction<SensorReading, Tuple3<String, Long, Integer>, Tuple, TimeWindow>() {
                    @Override
                    public void apply(Tuple tuple, TimeWindow timeWindow, Iterable<SensorReading> input, Collector<Tuple3<String, Long, Integer>> out) throws Exception {
                        String id = tuple.getField(0);
                        Long windowEnd = timeWindow.getEnd();
                        Integer count = IteratorUtils.toList(input.iterator()).size();
                        out.collect(new Tuple3<>(id, windowEnd, count));
                    }
                });
        //resultStream2.print();


        //3、 其他可选API
        OutputTag<SensorReading> outputTag = new OutputTag<SensorReading>("late") {
        };

        SingleOutputStreamOperator<SensorReading> sumStream = dataStream.keyBy("id")
                .timeWindow(Time.seconds(15))
//                .trigger()
//                .evictor()//移除器
                .allowedLateness(Time.minutes(1))//一分钟的延迟：窗口关闭的时候的等待时间
                .sideOutputLateData(outputTag)//迟到数据
                .sum("temperature");

        sumStream.getSideOutput(outputTag).print();//获取迟到的数据

        env.execute();
    }
}
