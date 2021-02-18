package leetcode.arrays.explore.insert;

import java.util.Arrays;

public class MergeSort {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);

        System.out.println(Arrays.toString(nums1));
    }

    public void mergeApp(int[] nums1, int m, int[] nums2, int n) {

        int length = m + n -1;
        int j =0;

        for (int i = length; i>=n; i-- ){
            if(nums1[i] == 0){
                nums1[i] = nums2[j];
                j++;
            }

        }
        Arrays.sort(nums1);

        System.out.println(Arrays.toString(nums1));
    }

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();

        int[] nums1 = {1,2,3,0,0,0}, nums2 = {2,5,6};
        int m = 3, n = 3;

        mergeSort.merge(nums1, m, nums2, n);
    }
}
