package leetcode.arrays.explore.insert;

import java.util.Arrays;

public class DuplicateZeros {

        public void duplicateZeros(int[] arr) {
            int possibleDups = 0;
            int length_ = arr.length - 1;

            // Find the number of zeros to be duplicated
            // Stopping when left points beyond the last element in the original array
            // which would be part of the modified array
            for (int left = 0; left <= length_ - possibleDups; left++) {

                // Count the zeros
                if (arr[left] == 0) {

                    // Edge case: This zero can't be duplicated. We have no more space,
                    // as left is pointing to the last element which could be included
                    if (left == length_ - possibleDups) {
                        // For this zero we just copy it without duplication.
                        arr[length_] = 0;
                        length_ -= 1;
                        break;
                    }
                    possibleDups++;
                }
            }

            // Start backwards from the last element which would be part of new array.
            int last = length_ - possibleDups;

            // Copy zero twice, and non zero once.
            for (int i = last; i >= 0; i--) {
                if (arr[i] == 0) {
                    arr[i + possibleDups] = 0;
                    possibleDups--;
                    arr[i + possibleDups] = 0;
                } else {
                    arr[i + possibleDups] = arr[i];
                }
            }
            System.out.println(Arrays.toString(arr));

        }


    public static void main(String[] args) {
        DuplicateZeros dz = new DuplicateZeros();

        int[] arr = {9,9,9,4,8,0,0,3,7,2,0,0,0,0,9,1,0,0,1,1,0,5,6,3,1,6,0,0,2,3,4,7,0,3,9,3,6,5,8,9,1,1,3,2,0,0,7,3,3,0,5,7,0,8,1,9,6,3,0,8,8,8,8,0,0,5,0,0,0,3,7,7,7,7,5,1,0,0,8,0,0};
        int[] arr2 = {8,4,5,0,0,0,0,7};
        dz.duplicateZeros(arr);
    }
}
