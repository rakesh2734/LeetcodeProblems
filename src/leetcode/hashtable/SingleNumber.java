package leetcode.hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SingleNumber {
    public int singleNumber(int[] nums) {
        List<Integer> no_duplicate_list = new ArrayList<>();

        for (int i : nums) {
            if (!no_duplicate_list.contains(i)) {
                no_duplicate_list.add(i);
            } else {
                no_duplicate_list.remove(new Integer(i));
            }
        }
        return no_duplicate_list.get(0);
    }

    public int singleNumberHash(int[] nums) {
        HashMap<Integer, Integer> hash_table = new HashMap<>();

        for (int i : nums) {
            hash_table.put(i, hash_table.getOrDefault(i, 0) + 1);
        }
        for (int i : nums) {
            if (hash_table.get(i) == 1) {
                    return i;
            }
        }
        return 0;
    }

    int singleNumberHashCheck(int[] nums){

        Map<Integer, Integer> noDups = new HashMap<>();

        for(int i: nums) {
            if(noDups.containsKey(i)) {
                noDups.put(i, noDups.get(i)+1);
            }
            else {
                noDups.put(i, 1);
            }

        }

        for(int j : nums) {
            if(noDups.get(j) == 1) {
                return j;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        SingleNumber singleNumber = new SingleNumber();
        int[] nums = {2,2,1,2,1,3};

        int value = singleNumber.singleNumberHashCheck(nums);
        System.out.println(value);
    }
}
