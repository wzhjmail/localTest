package wzj.amqp.direct;

import com.rabbitmq.client.*;
import wzj.amqp.utils.RabbitMQUtils;

import java.io.IOException;

/**
 * @ClassName Consumer2
 * @Description
 * @Author wzj
 * @Date 2020/12/22 18:58
 **/

public class Consumer2 {
    public static void main(String[] args) throws IOException {

        Connection connection = RabbitMQUtils.getConnetction();
        Channel channel = connection.createChannel();

        //声明交换机 以及交换机类型
        channel.exchangeDeclare("logs_direct", "direct");

        //创建一个临时队列
        String queue = channel.queueDeclare().getQueue();

        //临时队列和交换机绑定
        channel.queueBind(queue, "logs_direct", "info");
        channel.queueBind(queue, "logs_direct", "warning");
        channel.queueBind(queue, "logs_direct", "error");

        // 消费消息
        channel.basicConsume(
                queue,
                true,
                new DefaultConsumer(channel) {
                    @Override
                    public void handleDelivery(
                            String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body)
                            throws IOException {
                        System.out.println("消费者2：" + new String(body));
                    }
                });
    }
}
