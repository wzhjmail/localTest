package wzj.amqp.utils;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * @ClassName RabbitMQUtils
 * @Description
 * @Author wzj
 * @Date 2020/12/20 15:23
 **/

public class RabbitMQUtils {

    private static ConnectionFactory connectionFactory;

    static {
        // 重量级资源  类加载执行时只执行一次
        connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("127.0.0.1");
        connectionFactory.setPort(5672);
        connectionFactory.setVirtualHost("/ems");
        connectionFactory.setUsername("ems");
        connectionFactory.setPassword("123");
    }

    //定义提供连接对象的方法
    public static Connection getConnetction() {
        try {
            return connectionFactory.newConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //关闭通道和关闭连接工具方法
    public static void closeConnnectionAndChannel(Channel channel, Connection conn) {
        try {
            if (channel != null) channel.close();
            if (conn != null) conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
