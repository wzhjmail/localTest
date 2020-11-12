import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class Temp {
  private int id;
  private String name;

  public static void main(String[] args) {
    Temp t1 = new Temp();
    t1.setId(1);
    t1.setName("1");

    Temp t2 = new Temp();
    t2.setId(2);
    t2.setName("2");

    Temp t3 = new Temp();
    t3.setId(1);
    t3.setName("3");

    List<Temp> list = Arrays.asList(t1,t2,t3);

    list = list.stream()
            .filter(a -> a.getId()<=1 &&  a.getName().equals("1"))
            .collect(Collectors.toList());
    System.out.println(list);

  }
}

