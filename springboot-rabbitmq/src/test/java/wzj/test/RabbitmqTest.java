package wzj.test;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootVersion;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.SpringVersion;
import wzj.amqp.SpringBootRabbitmq;
import wzj.amqp.bean.Book;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName RabbitmqTest
 * @Description
 * @Author wzj
 * @Date 2020/12/12 14:20
 **/
@SpringBootTest(classes = SpringBootRabbitmq.class)
public class RabbitmqTest {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private AmqpAdmin amqpAdmin;

    @Test
    public void crateExchange() {
        //        amqpAdmin.declareExchange(new DirectExchange("amqpAdmin.directExchange"));
        //        System.out.println("通过amqpAdmin创建exchange成功");

        //        amqpAdmin.declareQueue(new Queue("amqpAdmin.queue"));
        //        System.out.println("通过amqpAdmin创建queue成功");

        amqpAdmin.declareBinding(new Binding("amqpAdmin.queue",
                Binding.DestinationType.QUEUE,
                "amqpAdmin.directExchange",
                "amqpAdmin.key", null));
    }

    // 发送数据（单播）:点对点
    @Test
    public void contextLoads() {
        //Message需要自己构造一个，可以定义消息体内容和消息头
        //rabbitTemplate.send(exchange, routeKey, message);

        //Object默认当作消息体，只需传入要发送的对象，自动序列化给rabbitmq
        //rabbitTemplate.convertAndSend(exchange, routeKey, Object);
        Map<String, Object> map = new HashMap<>();
        map.put("msg", "this is first message");
        map.put("data", Arrays.asList("hello", 123, true));
        //rabbitTemplate.convertAndSend("exchange.direct", "wzj.news", map);
        rabbitTemplate.convertAndSend("exchange.direct", "wzj.news", new Book("西游记", "吴承恩"));
    }

    // 接收数据
    @Test
    public void receive() {
        Object o = rabbitTemplate.receiveAndConvert("wzj.news");
        System.out.println(o.getClass());
        System.out.println(o);
    }

    //发送消息：广播模式
    @Test
    public void sendFanout() {
        rabbitTemplate.convertAndSend("exchange.fanout",
                "", new Book("红楼梦", "曹雪芹"));
    }

    @Test
    public void Test1() {
        String version = SpringVersion.getVersion();
        String version1 = SpringBootVersion.getVersion();
        System.out.println(version);
        System.out.println(version1);
    }
}
