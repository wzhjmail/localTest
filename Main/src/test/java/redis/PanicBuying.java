package redis;

import com.LocalTestApplication;
import com.redis.panicBuying.MsService;
import com.redis.panicBuying.ThreadB;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/** @ClassName 抢购 @Description @Author wzj @Date 2020/11/9 10:38 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = LocalTestApplication.class)
public class PanicBuying {

  @Autowired
  private RedisTemplate<String, Object> redisTemplate;

  @Test
  public void testPanicBuying() throws Exception {
    MsService service = new MsService();

    for (int i = 0; i < 10; i++) {
      ThreadB threadB = new ThreadB(service, redisTemplate, "MSKEY");
      threadB.start();
    }

  }

}
