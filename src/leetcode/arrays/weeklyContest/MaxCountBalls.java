package leetcode.arrays.weeklyContest;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.stream.IntStream;

public class MaxCountBalls {
    public void countBalls1() {
        int number = 27; // = and int
        LinkedList<Integer> stack = new LinkedList<Integer>();
        while (number > 0) {
            stack.push( number % 10 );
            number = number / 10;
        }

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }


        int num = 27; // int number
        while (num > 0) {
            System.out.println(num % 10);
            num = num / 10;
        }

    }

    public int countBalls2(int lowLimit, int highLimit) {

        int length = highLimit - lowLimit + 1;

        int box[] = new int[length+1];

        for(int i =0; i<=length; i++){
            if(i>0){
                box[i]++; // adds initial values
            }

        }

            int temp =0;
            while(lowLimit > 0){

                temp = lowLimit % 10;
                box[temp]++;
                lowLimit /=10;

            }
            int newTemp =0;
            while(highLimit > 0){
                newTemp = highLimit % 10;
                box[newTemp]++;
                highLimit /=10;

            }


        int ballCount = 1;
        for(int i = 1; i<box.length; i++){
            if(box[i] >1){
                ballCount = box[i];
            }
        }

        return ballCount;
    }

    public int countNoBalls1(int lowLimit, int highLimit){
        // highest value is 10^5 then which is 99999 = 45
        int[]cnt = new int[46];
        int max = 0;
        for(int i = lowLimit; i<highLimit; ++i){
            int num =i, sum =0;
            while(num>0){
                sum += num%10;
                num /= 10;
            }
            max = Math.max(++cnt[sum], max);
        }
        return max;

    }

    public int countNoBalls2(int lowLimit, int highLimit){
        int[] box = new int[46];
        int lo = lowLimit, id = 0;
        while (lo > 0) { // compute box id for lowLimit.
            id += lo % 10;
            lo /= 10;
        }
        ++box[id];
        for (int i = lowLimit + 1; i <= highLimit; ++i) { // compute all other box ids.
            int digits = i;
            while (digits % 10 == 0) { // for ball numbers with trailing 0's, decrease 9 for each 0.
                id -= 9;
                digits /= 10;
            }
            ++box[++id];
        }
        return IntStream.of(box).max().getAsInt();
    }

    public int countBalls(int lowLimit, int highLimit) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int i = lowLimit; i<= highLimit; i++) {
            int d = digitSum(i);
            map.put(d, map.getOrDefault(d, 0) + 1);
            res = Math.max(res, map.get(d));
        }
        return res;
    }

    public int digitSum(int num) {
        int sum = 0;
        while (num != 0) {
            sum += (num % 10);
            num /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        MaxCountBalls balls = new MaxCountBalls();
        int val1 = 1, val2 = 10;
        int ballCount = balls.countNoBalls1(val1, val2);
        System.out.println("ballCount : "+ballCount);
    }
}
