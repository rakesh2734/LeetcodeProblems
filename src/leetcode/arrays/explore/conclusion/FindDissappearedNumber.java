package leetcode.arrays.explore.conclusion;

import java.util.ArrayList;
import java.util.List;

public class FindDissappearedNumber {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;

        List<Integer> notThere = new ArrayList<>() ;
        for(int i = 0; i<n; i++){
            int index = nums[i];
            if(nums[Math.abs(index) -1] >0){
                nums[Math.abs(index) -1] = -nums[Math.abs(index) - 1];
            }
        }
        for(int i=0;i<n; i++ ){
            if(nums[i]>0) notThere.add(i+1);
        }

        return notThere;
        // In a better constructive manner
        /*        List<Integer> res = new ArrayList<Integer>();
        for (int i = 0 ; i != nums.length ; i++) {
            nums[Math.abs(nums[i])-1] = -Math.abs(nums[Math.abs(nums[i])-1]);
        }
        for (int i = 0 ; i != nums.length; i++) {
            if (nums[i] >= 0) res.add(i+1);
        }
        return res;*/
    }

    public static void main(String[] args) {
        FindDissappearedNumber dissappearedNumber = new FindDissappearedNumber();
        int[] nums = {4,3,2,7,8,2,3,1}; //{1,1};
        List<Integer> returnValue = dissappearedNumber.findDisappearedNumbers(nums);
        System.out.println(returnValue);
    }
}
