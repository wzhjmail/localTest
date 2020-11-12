import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName TTT
 * @Description
 * @Author wzj
 * @Date 2020/8/12 18:24
 **/

public class TTT {

  public static void main(String[] args) {
    //
      Map<Integer, Integer> map = new HashMap<>();

      if(CollectionUtils.isEmpty(map)){
      System.out.println("null");
      }else{
      System.out.println("having");
      }
  }
}
