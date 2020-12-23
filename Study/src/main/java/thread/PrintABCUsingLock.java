package thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName PrintABCUsingLock
 * @Description 使用锁来实现三个线程依次打印abc
 * @Author wzj
 * @Date 2020/12/23 10:34
 **/

public class PrintABCUsingLock {

    private int times;//打印次数

    private int state;//当前状态值，保证三个线程之间交替打印

    private Lock lock = new ReentrantLock();

    public PrintABCUsingLock(int times) {
        this.times = times;
    }

    private void printLetter(String name, int targetNum) {
        for (int i = 0; i < times; ) {
            lock.lock();
            if (state % 3 == targetNum) {
                state++;
                i++;
                System.out.print(name);
            }
            lock.unlock();
        }
    }

    public static void main(String[] args) {

        PrintABCUsingLock printABCUsingLock = new PrintABCUsingLock(3);

        new Thread(() -> {
            printABCUsingLock.printLetter("B", 1);
        }).start();

        new Thread(() -> {
            printABCUsingLock.printLetter("A", 0);
        }).start();

        new Thread(() -> {
            printABCUsingLock.printLetter("C", 2);
        }).start();

    }

}
