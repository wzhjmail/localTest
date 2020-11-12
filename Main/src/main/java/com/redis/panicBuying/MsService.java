package com.redis.panicBuying;

import org.springframework.data.redis.core.RedisTemplate;

/**
 * @ClassName MsService
 * @Description
 * @Author wzj
 * @Date 2020/11/9 10:49
 **/

public class MsService {

    public boolean seckill(RedisTemplate<String, Object>redisTemplate, String key) throws Exception {
        RedisLock lock = new RedisLock(redisTemplate, key, 10000, 20000);
        try {
            if (lock.lock()) {
                // 需要加锁的代码
                String pronum=lock.get("pronum");
                //修改库存
                if(Integer.parseInt(pronum)-1>=0) {
                    lock.set("pronum",String.valueOf(Integer.parseInt(pronum)-1));
                    System.out.println("库存数量:"+pronum+"     成功!!!"+Thread.currentThread().getName());
                }else {
                    System.out.println("已经被抢光了，请参与下轮抢购");
                }
                System.out.println("++++++++++++++++++++++++++++++++++++++参加了抢购");
                return true;
            }


        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // 为了让分布式锁的算法更稳键些，持有锁的客户端在解锁之前应该再检查一次自己的锁是否已经超时，再去做DEL操作，因为可能客户端因为某个耗时的操作而挂起，
            // 操作完的时候锁因为超时已经被别人获得，这时就不必解锁了。 ————这里没有做
            lock.unlock();
        }
        return false;
    }
}
