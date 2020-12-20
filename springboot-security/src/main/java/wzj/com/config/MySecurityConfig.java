package wzj.com.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @ClassName MySecurityConfig
 * @Description
 * @Author wzj
 * @Date 2020/12/18 14:03
 **/

@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    //授权规则
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //super.configure(http);
        //定制请求的授权规则
        http.authorizeRequests().antMatchers("/").permitAll()// 根目录下的文件都能访问
                .antMatchers("/level1/**").hasRole("VIP1")//level1目录下的文件需要有VIP1角色
                .antMatchers("/level2/**").hasRole("VIP2")//level2目录下的文件需要有VIP2角色
                .antMatchers("/level3/**").hasRole("VIP3");//level3目录下的文件需要有VIP3角色

        //开启自动配置的登陆功能，效果：如果没有权限就会来到登陆页面
        http.formLogin()
                .usernameParameter("user")
                .passwordParameter("pwd")
                .loginPage("/userlogin");//转到自己定义的页面
        //1、/Login来到登陆页
        //2、重定向到/login?error表示登陆失败
        //3、更多详细规定
        //4、默认post形式的/login代表处理登陆
        //5、一旦定制loginPage,那么loginPage的post请求就是登陆

        //开启自动配置的注销功能
        http.logout().logoutSuccessUrl("/");//注销成功后来到首页
        //1、访问/logout表示用户注销，清空session
        //2、注销成功会返回/login?logout页面

        //开启记住我功能
        http.rememberMe().rememberMeParameter("remeber");
        //登陆成功以后，将cookie发给浏览器保存，以后访问页面带上这个cookie,只要通过检查就可以免登陆
        //点击注销会删除cookie
    }

    //认证规则
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //super.configure(auth);

        auth.inMemoryAuthentication()
                .withUser("zhangsan").password("123456").roles("VIP1", "VIP2")
                .and()
                .withUser("lisi").password("123456").roles("VIP3", "VIP2")
                .and()
                .withUser("wangwu").password("123456").roles("VIP1", "VIP3");
    }
}
