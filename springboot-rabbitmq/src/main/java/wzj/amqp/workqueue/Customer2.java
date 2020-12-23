package wzj.amqp.workqueue;

import com.rabbitmq.client.*;
import wzj.amqp.utils.RabbitMQUtils;

import java.io.IOException;

/**
 * @ClassName Customer1
 * @Description
 * @Author wzj
 * @Date 2020/12/20 17:47
 **/

public class Customer2 {
    public static void main(String[] args) throws Exception {
        //获取连接
        Connection connection = RabbitMQUtils.getConnetction();
        Channel channel = connection.createChannel();

        channel.basicQos(1);//每次只能消费一个消息
        //参数1：队列名称   参数2：消息自动确认 true消费者自动向rabbitmq确认消息消费 false不会自动确认消息
        channel.queueDeclare("work", false, false, false, null);

        channel.basicConsume(
                "work",
                false,
                new DefaultConsumer(channel) {
                    @Override
                    public void handleDelivery(
                            String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body)
                            throws IOException {
                        System.out.println("消费者-2：" + new String(body));
                        channel.basicAck(envelope.getDeliveryTag(), false);
                    }
                });
    }
}
