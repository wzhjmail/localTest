package wzj.com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * @ClassName ShardingJDBCApplication
 * @Description
 * @Author wzj
 * @Date 2020/12/22 11:42
 **/
@SpringBootApplication
@MapperScan("wzj.com.dao")
@ImportResource({"classpath:*.xml"})
public class ShardingJDBCApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShardingJDBCApplication.class, args);
    }
}
