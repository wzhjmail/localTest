package SM4;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName SM4_Context
 * @Description
 * @Author wzj
 * @Date 2020/11/16 17:02
 **/

public class SM4_Context {
    public int mode;

    public int[] sk;

    public boolean isPadding;

    public SM4_Context() {
        this.mode = 1;
        this.isPadding = true;
        this.sk = new int[32];
    }

    public static void main(String[] args) throws Exception {
        List<String> list = new ArrayList<>();

        list = list.stream().filter(x -> x.equals("1")).collect(Collectors.toList());
        System.out.println(list);
    }
}
