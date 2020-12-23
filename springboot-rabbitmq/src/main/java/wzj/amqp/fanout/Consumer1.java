package wzj.amqp.fanout;

import com.rabbitmq.client.*;
import wzj.amqp.utils.RabbitMQUtils;

import java.io.IOException;

/**
 * @ClassName Consumer1
 * @Description 先启动所有的消费者，然后再启动生产者，只有这样消费者才能消费到消息
 *
 * @Author wzj
 * @Date 2020/12/22 18:01
 **/

public class Consumer1 {

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
                        System.out.println("消费者1：" + new String(body));
                    }
                });
    }
}
