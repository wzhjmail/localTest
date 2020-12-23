package wzj.com;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.retry.annotation.EnableRetry;
import wzj.com.service.RetryService;

/**
 * @ClassName RetryApplication
 * @Description
 * @Author wzj
 * @Date 2020/12/20 10:55
 **/

@Configuration
@EnableRetry
public class RetryApplication {
    @Bean
    public RetryService retryService() {
        return new RetryService();
    }

    public static void main(String[] args) throws Exception {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext("wzj.com");
        RetryService service = applicationContext.getBean("service", RetryService.class);
        service.serve();
    }
}
