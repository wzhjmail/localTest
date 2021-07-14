import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Main
 * @Description
 * @Author wzj
 * @Date 2021/6/26 10:47
 **/

public class Main {

    public static void main(String args[]) {

    }

    public static List<Float> getResult(List<Ary> arys) {
        List<Float> result = new ArrayList<>();
        for (int i = 0; i < arys.size(); i++) {
            Ary temp = arys.get(i);
            boolean arive = false;
            for (int j = i + 1; j < arys.size(); i++) {
                Ary temp2 = arys.get(j);
                if (temp.speed < temp2.speed) {
                    if (temp.position <= temp2.position) {
                        continue;
                    } else {
                        result.add((float) (temp.position - temp2.position) / (temp2.speed - temp.speed));
                        temp2.setSpeed(temp.getSpeed());
                        break;
                    }

                } else {
                    if (temp.position <= temp2.position) {
                        result.add(-1F);
                        break;
                    } else {
                        result.add((float) (temp2.position - temp.position) / (temp.speed - temp2.speed));

                        break;
                    }
                }
             
            }
        }

        return result;
    }

    class Ary {
        int position;
        int speed;

        public Ary(int position, int speed) {
            this.position = position;
            this.speed = speed;
        }

        public int getPosition() {
            return position;
        }

        public void setPosition(int position) {
            this.position = position;
        }

        public int getSpeed() {
            return speed;
        }

        public void setSpeed(int speed) {
            this.speed = speed;
        }
    }
}
