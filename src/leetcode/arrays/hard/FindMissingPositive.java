package leetcode.arrays.hard;

public class FindMissingPositive {

    public static int firstMissingPositive(int[] nums) {
        int l = nums.length;
        boolean[] seen = new boolean[l+1];
        for(int n : nums) {
            if(n >0 && n<=l) {
                seen[n] = true;
            }
        }

        for (int i =1; i<=l; i++) {
            if (!seen[i]) {
                return i;
            }
        }
        return l+1;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,0};
        int missingValue = firstMissingPositive(nums);
        System.out.println("missing value is: " + missingValue);
    }
}
