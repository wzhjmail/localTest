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

public class Customer1 {
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
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("消费者-1：" + new String(body));
                        //参数1：确认队列中那个具体消息 参数2：是否开启多个消息同时确认
                        channel.basicAck(envelope.getDeliveryTag(), false);
                    }
                });
    }
}
