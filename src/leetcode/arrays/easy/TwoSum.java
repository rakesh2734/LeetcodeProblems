package leetcode.arrays.easy;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return new int[2];

        int result[] = new int[2];
        Map<Integer, Integer> mapWithPositions = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (mapWithPositions.get(target - nums[i]) != null) {
                result[0] = i;
                result[1] = mapWithPositions.get(target - nums[i]);
                break;
            } else {
                mapWithPositions.put(nums[i], i);
            }
        }

        return result;
    }

}
