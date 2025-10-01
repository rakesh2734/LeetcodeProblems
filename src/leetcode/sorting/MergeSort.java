package leetcode.sorting;

import java.util.Arrays;

public class MergeSort {

    public static int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length-1);
        return nums;
    }

    private static int[] mergeSort(int[] arr, int left, int right) {

        if (left < right) {
            int mid = (left + right) / 2;

            mergeSort(arr, left, mid);
            mergeSort(arr, mid+1, right);
            merge(arr, left, mid, right);
        }
        return arr;
    }

    private static void merge(int[] arr, int left, int mid, int right) {

        int length1 = mid - left + 1;
        int length2 = right - mid;

        // create and initialize temp arr
        int[] lTemp = new int[length1];
        int[] rTemp = new int[length2];

        for (int x = 0; x <length1; x++) {
            lTemp[x] = arr[left + x];
        }

        for (int x=0; x<length2; x++) {
            rTemp[x] = arr[mid+1+x];
        }

        int i = 0, j = 0, k = left;

        while(i < length1 && j<length2) {
            if(lTemp[i]<=rTemp[j]) {
                arr[k] = lTemp[i];
                i++;
            }
            else {
                arr[k] = rTemp[j];
                j++;
            }
            k++;
        }

        while(i<length1) {
            arr[k] = lTemp[i];
            i++;
            k++;
        }

        while (j<length2) {
            arr[k] = rTemp[j];
            j++;
            k++;
        }

    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,10,4,3,15,4,8};
        sortArray(arr);

        Arrays.stream(arr).forEach(System.out::println);
    }

}
