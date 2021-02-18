package leetcode.arrays.easy;

import sun.applet.Main;

/*Input: [-2,1,-3,4,-1,2,1,-5,4] */
public class MaxSubArray {

    public int crossSum(int[] nums, int left, int right, int middle){
        int currsum = 0;

        int leftSubSum = Integer.MIN_VALUE;

        for(int i = middle; i > left; --i){
            currsum += nums[i];
            leftSubSum = Math.max(leftSubSum, currsum); //
        }
        currsum = 0;

        int rightSubSum = Integer.MIN_VALUE;

        for(int i = middle+1; i < right; i++){
            currsum += nums[i];
            rightSubSum = Math.max(rightSubSum, currsum);
        }
        return leftSubSum + rightSubSum;
    }

    public int helper(int[] nums, int left, int right){
        if(left == right) return nums[left];

        int middle = ( left + right ) / 2;

        int leftSum = helper(nums, left, middle);
        int rightSum = helper(nums, middle+1, right);
        int crossSum = crossSum(nums, left, right, middle);

        // not needed

        System.out.println("leftSum = " + leftSum);
        System.out.println("rightSum = " + rightSum);
        System.out.println("crossSum = " + crossSum);

        int maxValue = Math.max(leftSum, rightSum);
        System.out.println("maxValue = " + maxValue);

        int maxFinal = Math.max(Math.max(leftSum, rightSum), crossSum);
        System.out.println("maxValue final= " + maxFinal);
        //*/
        return Math.max(Math.max(leftSum, rightSum), crossSum);
    }

    public int maxSubArray(int[] nums) {
        return helper(nums, 0, nums.length-1);
    }

    public static void main(String[] args) {
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
        MaxSubArray maxSubObj = new MaxSubArray();

        int value = maxSubObj.maxSubArray(arr);

        System.out.println("value final= " + value);
    }
}
