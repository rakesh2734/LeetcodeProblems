package leetcode.arrays.explore.conclusion;

public class ThirdMax {
    public int thirdMax(int[] nums){
        Integer value1 = null;
        Integer value2 = null;
        Integer value3 = null;

        for(Integer n : nums){
            if(n.equals(value1) || n.equals(value2) || n.equals(value3)) continue;
            if(value1 == null || n>value1){
                value3 = value2;
                value2 = value1;
                value1 =n;
            }
            else if(value2 == null || n>value2){
                value3 = value2;
                value2 = n;
            }
            else if(value3 == null || n> value3){
                value3 =n;
            }
        }

        return value3 == null ? value1: value3;
    }

    public static void main(String[] args) {
        ThirdMax third = new ThirdMax();
        int[] nums = {3,4};
        int returnValue = third.thirdMax(nums);
        System.out.println(returnValue);
    }
}
