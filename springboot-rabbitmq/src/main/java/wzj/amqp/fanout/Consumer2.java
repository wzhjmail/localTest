package wzj.amqp.fanout;

import com.rabbitmq.client.*;
import wzj.amqp.utils.RabbitMQUtils;

import java.io.IOException;

/**
 * @ClassName Consumer1
 * @Description
 * @Author wzj
 * @Date 2020/12/22 18:01
 **/

public class Consumer2 {

    public static void main(String[] args) throws Exception {

        Connection connection = RabbitMQUtils.getConnetction();

        Channel channel = connection.createChannel();

        //通道绑定交换机
        channel.exchangeDeclare("logs", "fanout");

        //临时队列
        String queueTemp = channel.queueDeclare().getQueue();

        //绑定交换机和队列
        channel.queueBind(queueTemp, "logs", "");

        // 消费消息
        channel.basicConsume(
                queueTemp,
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
