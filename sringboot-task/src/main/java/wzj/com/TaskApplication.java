package wzj.com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @ClassName TaskApplication
 * @Description
 * @Author wzj
 * @Date 2020/12/15 19:02
 **/
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableAsync
public class TaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(TaskApplication.class, args);
    }
}
