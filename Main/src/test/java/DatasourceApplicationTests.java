import com.LocalTestApplication;
import com.entity.Student;
import com.service.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = LocalTestApplication.class)
public class DatasourceApplicationTests {

    @Autowired
    private StudentService studentService;

    @Test
    public void testWrite() {
        Student member = new Student();
        member.setName("zhangsan");
        member.setId(1);
        studentService.insert(member);
    }

    @Test
    public void testRead() {
        Student stu = studentService.getById(1);
    System.out.println(stu.toString());
    }


}