package leetcode.arrays.sorting;

public class SelectionSort {

    public static void selectionSort(int[] arr) {
        // Mutates arr so that it is sorted via selecting the minimum element and
        // swapping it with the corresponding index
        int min_index;
        for (int i = 0; i < arr.length; i++) {
            min_index = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min_index]) {
                    min_index = j;
                }
            }
            // Swap current index with minimum element in rest of list
            int temp = arr[min_index];
            arr[min_index] = arr[i];
            arr[i] = temp;
        }
    }

    public static void sortColor(int[] arr) {
        int low = 0;
        int mid =0;
        int high= arr.length -1;

        while (mid < high) {
            if (arr[mid] ==0) {
                int temp = arr[low];
                arr[low] = arr[mid];
                arr[mid] = temp;
                low++;
                mid++;
            }
            else if (arr[mid] ==1) {
                mid++;
            }
            else {
                int temp = arr[mid];
                arr[mid] = arr[high];
                arr[high] = temp;
                high--;
            }
        }


    }

    public static void main(String[] args) {

        int[] arr = {2,0,1};

        sortColor(arr);
    }
}
