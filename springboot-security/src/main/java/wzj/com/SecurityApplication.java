package wzj.com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ClassName SecurityApplication
 * @Description
 * @Author wzj
 * @Date 2020/12/18 14:02
 *
 * 1、引入SpringSecurity
 * 2、编写SpringSecurity配置类:
 * @EnableWebSecurity extends WebSecurityConfigurerAdapter
 * 3、控制请求的访问权限
 *
 **/

@SpringBootApplication
public class SecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecurityApplication.class, args);
    }
}
