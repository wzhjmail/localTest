package com.redis.panicBuying;

import org.springframework.data.redis.core.RedisTemplate;

/**
 * @ClassName ThreadB
 * @Description
 * @Author wzj
 * @Date 2020/11/9 10:44
 **/

public class ThreadB extends Thread{

    private MsService service;
    private RedisTemplate<String, Object> redisTemplate;
    private String key;

    public ThreadB(MsService service, RedisTemplate<String, Object> redisTemplate, String key) {
        this.service = service;
        this.redisTemplate = redisTemplate;
        this.key = key;
    }

    @Override
    public void run() {
        try{
            service.seckill(redisTemplate, key);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
