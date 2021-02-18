package leetcode.arrays.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*Problem: 1133*/
public class LargestUniqueNum {

    public int largestUniqNum(int[] A){

        //Arrays.sort(A);// instead sort remove the duplicates using hashmap
        HashMap<Integer, Integer> hMap = new HashMap<>();

        for(int n: A){
            // will nullify the duplicates and will have the duplicates value with greater than 1
            hMap.put(n, hMap.getOrDefault(n,0)+1);
        }

       int max= -1;

        for (int a: A){
            if(hMap.get(a) == 1 && a > max)  max = a;
        }
        return max;
    }

    public static int countGoodTriplets(int[] array, int a, int b, int c) {
        if (array == null || array.length < 3)
            return 0;
        // array[i] is from 0 to 1000;
        // use array to store freq of each number and compute its prefix.
        int n = array.length, res = 0;
        // post represents the cumulative freq of values being the 3rd element
        int[] post = new int[1001],
                // pre represents the freq of values being the 1st element;
                pre = new int[1001];
        // the base case of 1st element is the first element in array being the 1st in the triplet
        pre[array[0]] = 1;
        // initialize the post array for freq of 3rd element; it cannot be array[0], array[1];
        for (int i = 2; i < n; i++) {
            post[array[i]]++;
        }
        // compute the cumulative freq of 3rd element (freq of each possible value);
        for (int i = 1; i < 1001; i++) {
            post[i] += post[i - 1];
        }
        // traverse the array based on the 2nd element; it cannot be the array[0], cannot be the array[n - 1];
        for (int j = 1; j < n - 1; j++) {
            int minI = Math.max(0, array[j] - a),
                    maxI = Math.min(1000, array[j] + a),
                    minK = Math.max(0, array[j] - b),
                    maxK = Math.min(1000, array[j] + b);
            // traverse all possible values of 1st element i, i is value while j is index;
            for (int i = minI; i <= maxI; i++) {
                // check if there is values equal to i in array before j;
                if (pre[i] == 0)
                    continue;
                // update the 3rd element's min and max based on i;
                // all elements in array from minK2 to maxK2 are possible 3rd element for the "i, array[j]" triplet;
                int minK2 = Math.max(minK, i - c),
                        maxK2 = Math.min(maxK, i + c);
                if (minK2 <= maxK2) {
                    if (minK2 == 0)
                        res += pre[i] * post[maxK2];
                    else
                        res += pre[i] * (post[maxK2] - post[minK2 - 1]);
                }
            }
            // substract the freq of array[j + 1] element from post array
            for (int k = array[j + 1]; k <= 1000; k++)
                post[k]--;
            pre[array[j]]++;
        }
        return res;
    }

    public static void main(String[] args) {
        LargestUniqueNum obj = new LargestUniqueNum();
        int[] val = {5,1,5,1};
        int maxVal = obj.largestUniqNum(val);
        System.out.println("maximum value " + maxVal);
    }
}
