package leetcode.arrays.easy;

/*Given an integer n, return any array containing n unique integers such that they add up to 0.*/
/*
* Input: n = 5
* Output: [-7,-1,1,3,4]
* Explanation: These arrays also are accepted [-5,-1,1,2,3] , [-3,-1,2,-2,4].
* */
public class SumZero {

    public int[] sumZero(int n) {

        if(n == 1)
            return new int[]{0};

        int arr[] = new int[n];
        for(int i = 0; i < n-1; i++)
            arr[i] = i+1;
            arr[n-1] = -((n-1)*(n))/2;
        return arr;
    }

    public int[] twoPointApproach(int n){
        int res[] = new int[n];

        int left = 0, right = n-1;
        int counter = 1;

        while(left < right){
            res[left++] = counter;
            res[right--] = -counter;
            counter++;
        }

        return res;
    }

    public static void main(String[] args) {
        int n = 1;
        SumZero obj = new SumZero();
//        obj.sumZero(n);
       int[] output = obj.twoPointApproach(n);
    }
}
