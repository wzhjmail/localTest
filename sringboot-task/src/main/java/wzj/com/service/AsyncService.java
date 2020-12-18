package wzj.com.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @ClassName AsyncService
 * @Description
 * @Author wzj
 * @Date 2020/12/15 19:04
 **/
@Service
public class AsyncService {

    @Async
    public void sayHello() {

        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }


        System.out.println("数据处理中、、、");

    }
}
