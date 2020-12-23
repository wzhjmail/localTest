package thread;

/**
 * @ClassName PrintABCUsingWaitNotify
 * @Description
 * @Author wzj
 * @Date 2020/12/23 10:46
 **/

public class PrintABCUsingWaitNotify {

    private int state;

    private int times;

    private static final Object LOCK = new Object();

    public PrintABCUsingWaitNotify(int times) {
        this.times = times;
    }

    public static void main(String[] args) {
        PrintABCUsingWaitNotify printABCUsingWaitNotify = new PrintABCUsingWaitNotify(3);

        new Thread(() -> {
            printABCUsingWaitNotify.printLetter("A", 0);
        }).start();

        new Thread(() -> {
            printABCUsingWaitNotify.printLetter("B", 1);
        }).start();

        new Thread(() -> {
            printABCUsingWaitNotify.printLetter("C", 2);
        }).start();
    }

    private void printLetter(String name, int targetState) {
        for (int i = 0; i < times; i++) {
            synchronized (LOCK) {
                while (state % 3 != targetState) {
                    try {
                        LOCK.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                state++;
                System.out.print(name);
                LOCK.notifyAll();
            }
        }
    }
}
