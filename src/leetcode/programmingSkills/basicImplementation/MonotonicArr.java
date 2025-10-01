package leetcode.programmingSkills.basicImplementation;

public class MonotonicArr {

    private static boolean isMonotonic(int[] nums) {

        int len = nums.length;
        int store = 0;
        for(int i =0; i< len-1; ++i) {
            int c = Integer.compare(nums[i], nums[i+1]);
            if(c!=0) {
                if (c != store && store!=0) {
                    return false;
                }
                store = c;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1,2,2,3};
        int[] farr = new int[] {1,2,4,3};

       System.out.println("Is it monotonic: " + isMonotonic(farr));
    }
}
