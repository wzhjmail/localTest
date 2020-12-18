package wzj.com;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * @ClassName EmailTest
 * @Description
 * @Author wzj
 * @Date 2020/12/17 19:16
 **/
@SpringBootTest(classes = TaskApplication.class)
public class EmailTest {

    @Autowired
    private JavaMailSenderImpl mailSender;

    @Test
    public void sendSimpleEmail() {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("通知-开会");
        message.setText("今天开会哈");
        message.setTo("wzhj_mail@163.com");
        message.setFrom("wzhj_mail@qq.com");

        mailSender.send(message);
    }


    @Test
    public void sendComplexEmail() throws Exception {
        // 创建一个复杂的消息邮件
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

        //邮件设置
        mimeMessageHelper.setSubject("复杂通知");
        mimeMessageHelper.setText("<b style='color:red'> 今天开会吧</b>", true);

        mimeMessageHelper.setTo("wzhj_mail@163.com");
        mimeMessageHelper.setFrom("wzhj_mail@qq.com");

        //上传文件
        mimeMessageHelper.addAttachment("1.png", new File("/Users/mac/Desktop/1.png"));
        mimeMessageHelper.addAttachment("2.png", new File("/Users/mac/Desktop/2.png"));
        mailSender.send(mimeMessage);

    }

}
