package wzj.amqp.direct;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import wzj.amqp.utils.RabbitMQUtils;

/**
 * @ClassName Provider
 * @Description
 * @Author wzj
 * @Date 2020/12/22 18:45
 **/

public class Provider {
    public static void main(String[] args) throws Exception {
        //获取连接
        Connection connection = RabbitMQUtils.getConnetction();
        //获取连接对象
        Channel channel = connection.createChannel();
        //通过通道声明交换机 参数1：交换机名称 ，参数2：direct 路由模式
        channel.exchangeDeclare("logs_direct", "direct");
        //发送消息
        String routingKey = "error";
        channel.basicPublish("logs_direct", routingKey, null, ("这是direct模型发布的基于route key:[" + routingKey + "] 发送的消息").getBytes());

        //关闭资源
        RabbitMQUtils.closeConnnectionAndChannel(channel, connection);
    }
}
