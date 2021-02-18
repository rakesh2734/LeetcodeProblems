package leetcode.arrays.easy;

/*
* Given an array of integers arr, and three integers a, b and c. You need to find the number of good triplets.

A triplet (arr[i], arr[j], arr[k]) is good if the following conditions are true:

0 <= i < j < k < arr.length
|arr[i] - arr[j]| <= a
|arr[j] - arr[k]| <= b
|arr[i] - arr[k]| <= c
* */
public class CountGoodTriplets {

    public int countGoodTriplets(int[] arr, int a, int b, int c) {

        int n = arr.length;
        int num =0;
        for(int i=0;i<n; i++){
            for(int j = i+1; j<n; j++){

                for(int k = j+1; k<n; k++){
                    boolean aTr = (Math.abs(arr[i] -arr[j]) <= a);
                    boolean bTr = (Math.abs(arr[j] - arr[k]) <= b);
                    boolean cTr = (Math.abs(arr[i] - arr[k]) <= c);
                    if(aTr&&bTr&&cTr) num++;
                }
            }
        }
        return num;
    }

    public static void main(String[] args) {
        CountGoodTriplets obj = new CountGoodTriplets();

        int[]arr = {3,0,1,1,9,7}; int a = 7, b = 2, c = 3;
        int res = obj.countGoodTriplets(arr,a,b,c);

        System.out.println(res);
    }
}
