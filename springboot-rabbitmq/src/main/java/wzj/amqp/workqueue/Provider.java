package wzj.amqp.workqueue;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import wzj.amqp.utils.RabbitMQUtils;

/**
 * @ClassName Provider
 * @Description
 * @Author wzj
 * @Date 2020/12/20 17:32
 **/

public class Provider {

    public static void main(String[] args) throws Exception {
        //获取连接对象
        Connection connection = RabbitMQUtils.getConnetction();
        //获取通道对象
        Channel channel = connection.createChannel();

        //通过通道生命队列
        channel.queueDeclare("worker", false, false, false, null);

        for (int i = 0; i < 20; i++) {
            //生产消息
            channel.basicPublish("", "work", null, (i + "hello work queue").getBytes());
        }

        //关闭资源
        RabbitMQUtils.closeConnnectionAndChannel(channel, connection);
    }
}
