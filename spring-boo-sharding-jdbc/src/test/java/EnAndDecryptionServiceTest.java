import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import wzj.com.ShardingJDBCApplication;
import wzj.com.dto.HostDto;
import wzj.com.dto.UserDto;
import wzj.com.service.EnAndDecryptionService;

/**
 * @ClassName EnAndDecryptionServiceTest
 * @Description
 * @Author wzj
 * @Date 2021/7/3 12:50
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ShardingJDBCApplication.class)
public class EnAndDecryptionServiceTest {

    @Autowired
    private EnAndDecryptionService enAndDecryptionService;

    @Test
    public void insertTest() {
        int res = enAndDecryptionService.save(new UserDto(1, "郑州"));
        System.out.println(res);
    }

    @Test
    public void updateTest() {
        int res = enAndDecryptionService.updateById(2, "睢县");
        System.out.println(res);
    }

    @Test
    public void selectTest() {
        UserDto res = enAndDecryptionService.getById(1L);
        System.out.println(res.toString());
    }

    /*@Test
    public void tt(){
        HostDto dto = enAndDecryptionService.select();
        System.out.println(dto.toString());
    }*/
}
