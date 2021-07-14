/**
 * @ClassName Main
 * @Description
 * @Author wzj
 * @Date 2021/7/3 10:29
 **/

public class Main {

    public static void main(String[] args) {
        System.out.println(getRes(10000, 10001));
    }

    public static int getRes(int a, int b) {
        if (a < 1 || b < 1) {
            return -1;
        }

        int min = a > b ? b : a;
        int max = a <= b ? b : a;

        if (max % min == 0) {
            return min;
        }

        int start = 1;
        int end = min;

        for (; start <= end; ) {
            int temp = (start + end) / 2;
            if (min % temp == 0 && max % temp == 0) {
                return temp;
            } else {
                end = temp;
            }
        }
        return 1;
    }
}
