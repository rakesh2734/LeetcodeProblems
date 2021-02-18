package leetcode.arrays.easy;

import java.util.HashMap;

/*Given an array of integers nums.

A pair (i,j) is called good if nums[i] == nums[j] and i < j.

Return the number of good pairs.*/
public class NumOfGoodPairs {
    // using brute force algorithm - Time Complexity O(n^2)
    public int numIdenticalPairs(int[] nums) {
        int count = 0;
        for(int i=0; i<nums.length; i++){
            for(int j=0; j<nums.length; j++){
                if(i < j && nums[i] == nums[j]){
                    count++;
                }
            }
        }
        return count;
    }

    // Using Hash map to reduce the Time Complexity O(n)
    public int numOfIdenticalPairs(int[] nums){
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int count = 0;
        for(int num: nums){
           count += hashMap.getOrDefault(num, 0);
           hashMap.put(num, hashMap.getOrDefault(num, 0)+1);
        }
        return count;
    }

    public static void main(String[] args) {
        NumOfGoodPairs goodPairs = new NumOfGoodPairs();
        int[] nums = {1,2,3,1,1,3};
        int count = goodPairs.numOfIdenticalPairs(nums);
        System.out.println("Num of Good pairs:" + count);
    }
}
