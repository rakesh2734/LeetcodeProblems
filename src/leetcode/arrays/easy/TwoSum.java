package leetcode.arrays.easy;

import java.util.Arrays;
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

    public int[] twoSumHashMap(int[] nums, int target) {
        // two pass Solution
        Map<Integer, Integer> sumMap = new HashMap<>();

        final int[][] result = new int[1][1];
        Arrays.stream(nums)
                .forEach(a -> {
                    int complement = target - a;
                    if(sumMap.containsKey(complement)) {
                        result[0] = new int[]{a, complement};
                    }
                    sumMap.put(a, a);
                });


        return result[0];

    }

    public static void main(String[] args) {
        TwoSum obj = new TwoSum();
        int[] nums = new int[] {1, 3, 5,6, 2,7};
        int target = 6;
        int[] solution = obj.twoSumHashMap(nums, target);
        int[] sol2 = obj.twoSum(nums, target);
        System.out.println("Two sum using streas and hashmap -"+ Arrays.toString(solution));
        System.out.println("Two sum using general foreach and hashmap -"+ Arrays.toString(sol2));
    }

}
