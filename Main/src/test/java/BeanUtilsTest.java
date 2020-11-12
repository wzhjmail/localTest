import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

@Slf4j
public class BeanUtilsTest {
    String name;
    public static void main(String[] args) throws Exception {
        log.info("getAvailableInventory request parma appointNo={}, skuIds={}", "122", "123");
        Class clazz = Class.forName("");
        BeanUtilsTest tt = (BeanUtilsTest)clazz.getDeclaredConstructor().newInstance();
        Field field = clazz.getDeclaredField("");
        field.set(tt,"123");

        Method method = clazz.getMethod("");

    }
}
