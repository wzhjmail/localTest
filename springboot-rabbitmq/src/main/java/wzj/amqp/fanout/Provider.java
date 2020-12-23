package wzj.amqp.fanout;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import wzj.amqp.utils.RabbitMQUtils;

/**
 * @ClassName Provider
 * @Description 先启动所有的消费者，然后再启动生产者，只有这样消费者才能消费到消息
 * @Author wzj
 * @Date 2020/12/22 17:47
 **/

public class Provider {
    public static void main(String[] args) throws Exception {
        //获取连接对象
        Connection connection = RabbitMQUtils.getConnetction();
        Channel channel = connection.createChannel();

        //将通道声明指定交换机    参数1：交换机名称 参数2：交换机类型 fanout广播类型
        channel.exchangeDeclare("logs", "fanout");

        //发消息  参数1：交换机名称 参数2：路由key 参数3：消息持久化特性 参数4：发送的消息
        channel.basicPublish("logs", "", null, "fanout type message".getBytes());

        //释放资源
        RabbitMQUtils.closeConnnectionAndChannel(channel, connection);
    }
}
