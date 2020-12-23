package wzj.amqp.direct;

import com.rabbitmq.client.*;
import wzj.amqp.utils.RabbitMQUtils;

import java.io.IOException;

/**
 * @ClassName Consumer1
 * @Description
 * @Author wzj
 * @Date 2020/12/22 18:52
 **/

public class Consumer1 {
    public static void main(String[] args) throws Exception {
        Connection connection = RabbitMQUtils.getConnetction();
        Channel channel = connection.createChannel();

        //通道声明交换机以及交换的类型
        channel.exchangeDeclare("logs_direct", "direct");

        //创建一个临时队列
        String queue = channel.queueDeclare().getQueue();

        //基于route key绑定队列和交换机
        channel.queueBind(queue, "logs_direct", "error");

        // 获取消费的消息
        channel.basicConsume(
                queue,
                true,
                new DefaultConsumer(channel) {
                    @Override
                    public void handleDelivery(
                            String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body)
                            throws IOException {
                        System.out.println("消费者1：" + new String(body));
                    }
                });
    }
}
