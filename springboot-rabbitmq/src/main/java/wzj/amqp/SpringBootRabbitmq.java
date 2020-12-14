package wzj.amqp;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 *RabbitMQ是一个实现了AMQP（Advanced Message Queuing Protocol）高级消息队列协议的消息队列服务
 启动、停止
 service rabbitmq-server start
 service rabbitmq-server stop
 service rabbitmq-server restart
 管理界面：http://127.0.0.1:15672/#/exchanges
 **/

/**
 自动配置：
 1、RabbitAutoConfiguration
 2、有自动配置了连接工厂ConnectionFactory
 3、RabbitProperties封装了rabbitmq的配置
 4、RabbitTemplate:给RabbitMQ发送和接受消息
 5、AmqpAdmin：RabbitMQ系统管理功能组件
 通过代码的方式创建exchange、queue，并绑定二者的关系
 6、@EnableRabbit + @RabbitListener 监听消息队列的内容
 */

@EnableRabbit //开启基于注解的RabbitMQ模式
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class SpringBootRabbitmq {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootRabbitmq.class);
    }
}
