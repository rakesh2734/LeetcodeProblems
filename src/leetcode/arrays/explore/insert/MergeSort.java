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

    public void logicMerge(int[] nums1, int m, int[] nums2, int n){
        //Thought in this way
        // Try it in a brute force approach - looks like cannot do in brute //force
        // Use of Three pointer technique

//         Integer[] nums = new Integer[m+n];

//         List<Integer> arrList = new ArrayList<>();
//         int i = 0, j = 0;
//         while(i < m + n){
//             if(nums1[i] <= nums2[j] ){
//                 nums1[i] = nums1[i];
//                 i++;
//             }
//             else{
//                 // arrList.add(nums2[j]);
//                 nums1[i]= nums2[j];
//                 j++;
//             }
//         }

        // arrList.toArray(nums);
        // This won't work because we need to modify into the same array

//         for(int i = 0; i<m; i++){
//             for(int j =0; j<n; j++){
//                 if(nums1[i]<=nums2[j]){
//                     arr.add(nums1[i]);
//                 }
//                 else{
//                     arr.add(nums2[j]);
//                 }

//             }
//         }

    }

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();

        int[] nums1 = {1,2,3,0,0,0}, nums2 = {2,5,6};
        int m = 3, n = 3;

        mergeSort.merge(nums1, m, nums2, n);
    }
}
