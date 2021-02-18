package leetcode.arrays.easy;
/*Given an array of positive integers arr, calculate the sum of all possible odd-length subarrays.

A subarray is a contiguous subsequence of the array.

Return the sum of all odd-length subarrays of arr.*/

/* Input: arr = [1,4,2,5,3]
Output: 58
Explanation: The odd-length subarrays of arr and their sums are:
*/

/*Input: arr = [1,4,2,5,3]
Output: 58
Explanation: The odd-length subarrays of arr and their sums are:
[1] = 1
[4] = 4
[2] = 2
[5] = 5
[3] = 3
[1,4,2] = 7
[4,2,5] = 11
[2,5,3] = 10
[1,4,2,5,3] = 15
If we add all these together we get 1 + 4 + 2 + 5 + 3 + 7 + 11 + 10 + 15 = 58
Example 2:*/
public class SumOddLengthSubarrays {

    /*Brute force with O(n2)*/
    public int sumOddLengthSubarr(int[] arr) {
        int sum = 0;

        for(int i=1; i <=arr.length; i+=2 ){
            int curSum = 0;
            for(int j=0; j<i; j++){
                curSum += arr[j];
            }
            sum += curSum;

            for(int j =i; j<arr.length; j++){
                curSum += arr[j];
                curSum-=arr[j-i];
                sum+=curSum;
            }
        }
        return sum;
    }

    /*Also suggested by @mayank12559 and @simtully.

Consider the subarray that contains A[i],
we can take 0,1,2..,i elements on the left,
from A[0] to A[i],
we have i + 1 choices.

we can take 0,1,2..,n-1-i elements on the right,
from A[i] to A[n-1],
we have n - i choices.

In total, there are (i + 1) * (n - i) subarrays, that contains A[i].
And there are ((i + 1) * (n - i) + 1) / 2 subarrays with odd length, that contains A[i].
A[i] will be counted ((i + 1) * (n - i) + 1) / 2 times.


Example of array [1,2,3,4,5]
1 2 3 4 5 subarray length 1
1 2 X X X subarray length 2
X 2 3 X X subarray length 2
X X 3 4 X subarray length 2
X X X 4 5 subarray length 2
1 2 3 X X subarray length 3
X 2 3 4 X subarray length 3
X X 3 4 5 subarray length 3
1 2 3 4 X subarray length 4
X 2 3 4 5 subarray length 4
1 2 3 4 5 subarray length 5

5 8 9 8 5 total times each index was added.
3 4 5 4 3 total times in odd length array with (x + 1) / 2
2 4 4 4 2 total times in even length array with x / 2


Complexity
Time O(N)
Space O(1)*/
    public int sumOddArray(int[] arr){
        int res = 0, n = arr.length;
        for (int i = 0; i < n; ++i) {
            res += ((i + 1) * (n - i) + 1) / 2 * arr[i];
        }
        return res;
    }

    public static void main(String[] args) {

        int[] sub = {1,4,2,5,3};

        SumOddLengthSubarrays obj = new SumOddLengthSubarrays();

        int value = obj.sumOddArray(sub);

        System.out.println(value);

    }

}
