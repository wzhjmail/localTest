package wzj.com.service;

import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

/**
 * @ClassName RetryService
 * @Description
 * @Author wzj
 * @Date 2020/12/20 10:57
 **/

@Service("service")
public class RetryService {
    /**
     @Backoff - 表示重试中的退避策略: 怎么去做下一次的重试，其实就是等待多长时间。
     @Recover - 兜底方法，即多次重试后还是失败就会执行这个方法

     */
    @Retryable(value = IllegalAccessException.class, maxAttempts = 5,
            backoff = @Backoff(value = 1000, maxDelay = 10000, multiplier = 1.2)
            //等待1秒         最多等待10秒
    )
    public void serve() throws Exception {
        System.out.println("serve method...");
        throw new IllegalAccessException("manual exception");
    }

    @Recover
    public void recover(IllegalAccessException e) {
        System.out.println("service retry after recover = > " + e.getMessage());
    }
}
