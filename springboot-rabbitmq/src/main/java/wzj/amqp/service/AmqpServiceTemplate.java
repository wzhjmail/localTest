package wzj.amqp.service;

import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * @ClassName AmqpServiceTemplage
 * @Description 消费者，可以调用对应的方法直接获取到对应的消息
 * @Author wzj
 * @Date 2020/12/23 18:30
 **/

@Service
@RabbitListener(queuesToDeclare = @Queue(value = "hello", durable = "true", autoDelete = "true"))
public class AmqpServiceTemplate {

    @RabbitHandler
    public void receive(String message) {
        System.out.println(message);
    }

    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue,//创建临时队列
                    exchange = @Exchange(value = "logs", type = "fanout")//绑定的交换机
            )
    })
    public void receive2(String message) {

    }

    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue,//创建临时队列
                    exchange = @Exchange(value = "directs", type = "direct"),//自定义交换机名称和类型
                    key = {"info", "error"}
            )
    })
    public void receive3(String message) {
        HashMap map = new HashMap<String, String>();
    }

    //#匹配0个或多个
    //*匹配1个
    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue,//创建临时队列
                    exchange = @Exchange(value = "directs", type = "direct"),//自定义交换机名称和类型
                    key = {"info.#", "error.*"}
            )
    })
    public void receive4(String message) {

    }
}
