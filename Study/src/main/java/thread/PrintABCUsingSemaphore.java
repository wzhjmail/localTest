package thread;

import java.util.concurrent.Semaphore;

/**
 * @ClassName PrintABCUsingSemaphore
 * @Description
 * @Author wzj
 * @Date 2020/12/23 14:05
 **/

public class PrintABCUsingSemaphore {

    private int times;
    //只有a初始信号量为1，第一次获取到到只能是A
    private static Semaphore semaphoreA = new Semaphore(1);
    private static Semaphore semaphoreB = new Semaphore(0);
    private static Semaphore semaphoreC = new Semaphore(0);

    public PrintABCUsingSemaphore(int times) {
        this.times = times;
    }

    public static void main(String[] args) {
        PrintABCUsingSemaphore printer = new PrintABCUsingSemaphore(2);
        new Thread(() -> {
            printer.print("A", semaphoreA, semaphoreB);
        }, "A").start();

        new Thread(() -> {
            printer.print("B", semaphoreB, semaphoreC);
        }, "B").start();

        new Thread(() -> {
            printer.print("C", semaphoreC, semaphoreA);
        }, "C").start();
    }

    private void print(String name, Semaphore current, Semaphore next) {
        for (int i = 0; i < times; i++) {
            try {
                System.out.print("111" + Thread.currentThread().getName());
                current.acquire();//A获取信号执行，A信号量减1，当A为o时将无法继续获得该信号量
                System.out.print("《" + name + "》");
                next.release();//B释放信号，B信号量加1（初始值为0），此时可以获取B信号量
                System.out.println("222" + Thread.currentThread().getName());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
