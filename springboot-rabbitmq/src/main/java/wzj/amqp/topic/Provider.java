package wzj.amqp.topic;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import wzj.amqp.utils.RabbitMQUtils;

import java.io.IOException;

/**
 * @ClassName Provider
 * @Description
 * @Author wzj
 * @Date 2020/12/23 17:49
 **/

public class Provider {

    public static void main(String[] args) throws IOException {
        //获取连接对象
        Connection connection = RabbitMQUtils.getConnetction();
        Channel channel = connection.createChannel();

        //声明交换机以及交换机类型
        channel.exchangeDeclare("topics", "topic");

        //发布消息
        String routeKey = "user.save.kk";
        channel.basicPublish("topics", routeKey, null,
                ("这里是topic动态路由模型，routekey;[" + routeKey + "]").getBytes());

        //关闭资源
        RabbitMQUtils.closeConnnectionAndChannel(channel, connection);
    }
}
