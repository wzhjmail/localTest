import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/** @ClassName ForkJoinTest @Description @Author wzj @Date 2020/10/15 18:13 */
public class ForkJoinTest {
  public static void main(String[] args) throws Exception{
      long[] ary = new long[2000];
      long expectedSum = 0;
      for (int i = 0; i < ary.length; i++) {
          ary[i] = random();

      }
      long s = System.currentTimeMillis();
    for (int i = 0; i < ary.length; i++) {

        expectedSum += ary[i];
    }
      Thread.sleep(1);
      long e = System.currentTimeMillis();
    System.out.println(e-s);
      System.out.println("Expected sum: " + expectedSum);

      ForkJoinTask<Long> task = new SumTask(ary, 0, ary.length);

      long startTime = System.currentTimeMillis();
      long result = ForkJoinPool.commonPool().invoke(task);
      long endTime = System.currentTimeMillis();
      System.out.println("Fork/join sum: " + result + " in " + (endTime - startTime) + " ms.");
  }

    static Random random = new Random(0);

    static long random() {
        return random.nextInt(10000);
    }
}

class SumTask extends RecursiveTask<Long> {

  static final int THRESHOLD = 500;
  long[] ary;
  int start;
  int end;

  SumTask(long ary[], int start, int end) {
    this.ary = ary;
    this.start = start;
    this.end = end;
  }

  @Override
  protected Long compute() {
    if (end - start <= THRESHOLD) {
      long sum = 0;
      for (int i = start; i < end; i++) {
        sum += this.ary[i];
      }
      return sum;
    }

    int middle = (start + end) /2;
    System.out.println(String.format("split %d~%d ==> %d~%d, %d~%d", start, end, start, middle, middle, end));
    SumTask sub1 = new SumTask(ary,start,middle);
    SumTask sub2 = new SumTask(ary,middle,end);

    invokeAll(sub1,sub2);

    long sub1Res = sub1.join();
    long sub2Res = sub2.join();

    long res = sub1Res + sub2Res;

    System.out.println("result = " + sub1Res + " + " + sub2Res + " ==> " + res);
    return res;
  }
}
