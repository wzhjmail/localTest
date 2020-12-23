package thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName PrintABCUingLockCondition
 * @Description
 * @Author wzj
 * @Date 2020/12/23 13:29
 **/

public class PrintABCUsingLockCondition {

    private int times;
    private int state;
    private static Lock lock = new ReentrantLock();
    private static Condition c1 = lock.newCondition();
    private static Condition c2 = lock.newCondition();
    private static Condition c3 = lock.newCondition();

    public PrintABCUsingLockCondition(int times) {
        this.times = times;
    }

    public static void main(String[] args) {
        PrintABCUsingLockCondition print = new PrintABCUsingLockCondition(10);

        new Thread(() -> {
            print.printLetter("A", 0, c1, c2);
        }).start();

        new Thread(() -> {
            print.printLetter("B", 1, c2, c3);
        }).start();

        new Thread(() -> {
            print.printLetter("C\n", 2, c3, c1);
        }).start();
    }

    private void printLetter(String name, int targetState, Condition current, Condition next) {
        for (int i = 0; i < times; ) {
            lock.lock();
            try {
                while (state % 3 != targetState) {
                    current.await();
                }
                state++;
                i++;
                System.out.print(name);
                next.signal();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}
