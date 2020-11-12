package com.redis;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.listener.KeyExpirationEventMessageListener;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;

/**
 * @ClassName RedisKeyExpirationListener
 * @Description 监听所有db的过期事件
 * @Author wzj
 * @Date 2020/10/29 10:48
 *
 * todo 设置监听redis的地址、端口号；集群的地址端口号
 **/
//@Component
public class RedisKeyExpirationListener  extends KeyExpirationEventMessageListener {

    public RedisKeyExpirationListener(RedisMessageListenerContainer listenerContainer) {
        super(listenerContainer);
    }


    /**
     针对redis数据失效事件，进行数据处理
     @param message
     @param pattern
     */
    @Override
    public void onMessage(Message message, byte[] pattern) {
        //获取到失效的key,进行取消订单业务处理
        String expiredKey = message.toString();
        System.out.println("失效订单的订单号为：" + expiredKey);
    }
}