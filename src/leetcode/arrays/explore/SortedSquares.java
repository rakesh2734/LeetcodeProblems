package leetcode.arrays.explore;

import java.util.Arrays;

public class SortedSquares {
    public int[] sortedSquares(int[] A) {

        int[] sqrArr = new int[A.length];
        for(int i=0; i<A.length; i++){
//            int sqr = a * a;
//            sqrArr = new int[]{sqr};
            sqrArr[i] = A[i] * A[i];
        }

        Arrays.sort(sqrArr);

        return sqrArr;

    }

    public static void main(String[] args) {
        
    }
}
