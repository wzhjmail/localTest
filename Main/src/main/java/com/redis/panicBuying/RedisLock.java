package com.redis.panicBuying;

import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/** @ClassName RedisLock @Description @Author wzj @Date 2020/11/9 10:51 */
public class RedisLock {

  private RedisTemplate<String, Object> redisTemplate;

  private static final int DEFAULT_ACQUIRY_RESOLUTION_MILLIS = 100;

  private String lockKey;

  // 锁超时事件，防止线程在入锁后，无限的等待
  private int expireMsecs = 60 * 1000;

  // 锁等待事件，防止线程饥饿
  private int timeoutMsecs = 10 * 1000;

  private volatile boolean locked = false;
//    Jedis jedis = new Jedis("127.0.0.1:6379");
//    RedisConnection connection = new JedisConnection(jedis);

  public RedisLock(RedisTemplate<String, Object> redisTemplate, String lockKey) {
    this.redisTemplate = redisTemplate;
    this.lockKey = lockKey + "_lock";
  }

  public RedisLock(RedisTemplate<String, Object> redisTemplate, String lockKey, int timeoutMsecs) {
    this(redisTemplate, lockKey);
    this.timeoutMsecs = timeoutMsecs;
  }

  public RedisLock(
      RedisTemplate<String, Object> redisTemplate,
      String lockKey,
      int timeoutMsecs,
      int expireMsecs) {
    this(redisTemplate, lockKey, timeoutMsecs);
    this.expireMsecs = expireMsecs;
  }

  public String getLockKey() {
    return lockKey;
  }

  public String get(final String key) {
    Object obj = null;
    try {
      obj =
          redisTemplate.execute(
              new RedisCallback<Object>() {
                @Override
                public Object doInRedis(RedisConnection connection) throws DataAccessException {
                  // 序列化
                  StringRedisSerializer serializer = new StringRedisSerializer();
                  byte[] data = connection.get(serializer.serialize(key));
                  connection.close();
                  if (data == null) {
                    return null;
                  }
                  // 解序列化
                  return serializer.deserialize(data);
                }
              });
    } catch (Exception e) {
      System.out.println("get redis error, key=" + key + "  " + e.toString());
    }
    return obj != null ? obj.toString() : null;
  }

  public String set(final String key, final String value) {
    Object obj = null;
    try {
      obj =
          redisTemplate.execute(
              new RedisCallback<Object>() {
                @Override
                public Object doInRedis(RedisConnection connection) throws DataAccessException {
                  StringRedisSerializer serializer = new StringRedisSerializer();
                  connection.set(serializer.serialize(key), serializer.serialize(value));
                  return serializer;
                }
              });
    } catch (Exception e) {
      System.out.println("setNX redis error,key:" + key);
    }
    return obj != null ? obj.toString() : null;
  }

  public boolean setNX(final String key, final String value) {
      Object obj = null;
      try{
          obj = redisTemplate.execute(new RedisCallback<Object>() {
              @Override
              public Object doInRedis(RedisConnection connection) throws DataAccessException {
                  StringRedisSerializer serializer = new StringRedisSerializer();
                  Boolean success = connection.setNX(serializer.serialize(key),serializer.serialize(value));
                  connection.close();
                  return success;
              }
          });
      }catch (Exception e) {
          System.out.println("setNX redis error,key:" + key);
      }
      return null != obj ? (Boolean)obj : null;
  }

  public String getSet(final String key, final String value) {
      Object obj = null;
      try{
        obj = redisTemplate.execute(new RedisCallback<Object>() {
            @Override
            public Object doInRedis(RedisConnection connection) throws DataAccessException {
                StringRedisSerializer serializer = new StringRedisSerializer();
                byte[] ret = connection.getSet(serializer.serialize(key),serializer.serialize(value));
                connection.close();
                return serializer.deserialize(ret);
            }
        });
      }catch (Exception e) {
          System.out.println("setNX redis error,key:" + key);
      }
      return obj != null ? (String)obj : null;
  }

    /**

     */
    public synchronized boolean lock() throws InterruptedException {
        int timeout = timeoutMsecs;
        while(timeout >= 0) {
            long expires = System.currentTimeMillis()+expireMsecs+1;
            String expiresStr = String.valueOf(expires);//锁到期时间
            if(this.setNX(lockKey, expiresStr)){
                locked = true;
                return true;
            }
            String currentValueStr = this.get(lockKey);//redis里的时间
            if(currentValueStr!=null && Long.parseLong(currentValueStr) < System.currentTimeMillis()) {
                //判断是否为空，如果不为空，其他线程设置了值，第二个条件判断过不去
                String oldValueStr = this.getSet(lockKey, expiresStr);
                //获取上一个锁到期时间，并设置现在的锁到期时间
                //只有一个线程才能获取上一个线上的设置时间，因为jedis.getset是同步的
                if(oldValueStr!=null && oldValueStr.equals(currentValueStr)){
                    locked = true;
                    return true;
                }
            }
            timeout -= DEFAULT_ACQUIRY_RESOLUTION_MILLIS;
            //延迟100毫秒，可以防止饥饿线程的出现，即：当同时到达多个进程，只会又一个进程获得锁，其他当
            //都用同样当频率进行尝试，后面又来一些进程，也以同样的 频率申请锁
            Thread.sleep(DEFAULT_ACQUIRY_RESOLUTION_MILLIS);
        }

        return false;
    }

    public synchronized void unlock() {
        if(locked){
            redisTemplate.delete(lockKey);
            locked = false;
        }
    }
}
