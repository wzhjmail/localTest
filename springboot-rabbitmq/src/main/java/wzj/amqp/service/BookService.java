package wzj.amqp.service;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import wzj.amqp.bean.Book;

/**
 * @ClassName BookService
 * @Description
 * @Author wzj
 * @Date 2020/12/13 13:57
 **/
@Service
public class BookService {

    // 监听收到的消息
    @RabbitListener(queues = "wzj.news")
    public void receive(Book book) {
        System.out.println("收到消息：" + book);
    }

    // 监听收到的消息+消息头
    @RabbitListener(queues = "wzj")
    public void receiveMessage(Message message) {
        System.out.println(message.getBody());
        System.out.println(message.getMessageProperties());
    }
}
