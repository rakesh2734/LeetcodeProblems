package leetcode.codingChallenges;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GliderTest {
    public static void main(String[] args) {

//        List<Integer> numList = new ArrayList<>();
//        numList.add(20);
//        numList.add(10);
//        numList.add(0);
//        numList.add(100);
//        Integer maxVal = Collections.max(numList);
//        System.out.println("max"+maxVal);
//        Integer minVal = Collections.min(numList);
//        System.out.println("min"+minVal);
//       Collections.reverse(numList);
//        System.out.println("max"+numList);
        Class deviceClass = Device.class;
        try{
            Constructor con = deviceClass.getConstructor(String.class);

            Device dev = (Device) con.newInstance(455);

            Method[] methods = deviceClass.getMethods();

            for(Method method: methods){
                System.out.println(method.getName() + "1**");
            }

            Field pF = Device.class.getDeclaredField("type");

            pF.setAccessible(true);

        } catch (Exception e){
            e.printStackTrace();
        }


    }
    public class Device {
        private int rate;
        private String type;

        public Device(int rate) {
            setRate(rate);
        }

        public int getRate() {
            return rate;
        }

        public void setRate(int rate) {
            this.rate = rate;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }
}
