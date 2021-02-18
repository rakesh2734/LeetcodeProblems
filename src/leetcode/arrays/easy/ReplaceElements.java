package leetcode.arrays.easy;

/*Given an array arr, replace every element in that array with the greatest element among the elements to its right,
 *and replace the last element with -1.
*After doing so, return the array.*/
public class ReplaceElements {
    public int[] replaceElements(int[] arr) {
        int maxVal = -1; // as we know the last value is -1 constant
        int n = arr.length, a;

        for(int i= n-1; i >= 0; i--){
            a = arr[i];
            arr[i] = maxVal;
            maxVal = Math.max(maxVal, a);
        }

        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {17,18,5,4,6,1};  // O/P should be :  { 18,6,6,6,1-1}
        ReplaceElements repElem = new ReplaceElements();
        int[] replaced = repElem.replaceElements(arr);

    }
}
