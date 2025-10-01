package leetcode.hashtable;

import java.util.*;

public class IntersectionOfTwoArrays {
    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> intersect = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            if (set.contains(nums2[i])) {
                intersect.add(nums2[i]);
            }
        }
        int[] result = new int[intersect.size()];
        int i = 0;
        for (Integer num : intersect) {
            result[i++] = num;
        }
        return result;
    }

    public int[] intersectionSolved(int[] nums1, int[] nums2) {
        Set<Integer> it = new HashSet<>();
        Set<Integer> intersect = new HashSet<>();
        for(int i: nums1) {
            it.add(i);
        }
        for(int i: nums2) {
            if(it.contains(i)){
                intersect.add(i);
            }
        }
        int[] result = new int[intersect.size()];
        int i = 0;
        for(Integer num: intersect){
            result[i++] = num;
        }
        return result;
    }

    // two pointer technique and sort two arrays
    public int[] intersectionSort(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                set.add(nums1[i]);
                i++;
                j++;
            }
        }
        int[] result = new int[set.size()];
        int k = 0;
        for (Integer num : set) {
            result[k++] = num;
        }
        return result;
    }

    /**
     * [1,2,2,1]
     * [2,2]
     */
    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};

        int[] result = IntersectionOfTwoArrays.intersection(nums1, nums2);
        System.out.println("result set: {}"+ Arrays.toString(result));
    }

}
