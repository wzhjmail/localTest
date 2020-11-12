import java.io.File;

/** @ClassName TTT @Description @Author wzj @Date 2020/8/12 18:24 */
public class RenameFileName {

  public static void main(String[] args) throws InterruptedException {

    String baseDir = "/Users/mac/Documents/today";
    File files = new File(baseDir);

    File[] list = files.listFiles();
    int base = 0;

    for (int t = 0; t < list.length; t++) {
      File file = list[t];

      String oldName = file.getName();
      if(!oldName.contains(".")){
        continue;
      }
      String newName = (t + base) +
                  oldName.substring(oldName.indexOf("."), oldName.length());

      file.renameTo(new File(baseDir + "/" + newName));
    }
  }
}
