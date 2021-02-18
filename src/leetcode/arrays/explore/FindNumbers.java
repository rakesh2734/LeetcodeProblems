package leetcode.arrays.explore;

/*Find numbers with even no. of digits.*/
/*Input: nums = [12,345,2,6,7896]*/
/*Output = 2 */
public class FindNumbers {
    public int findNumbers(int[] nums) {
        int count = 0;
        for(int num: nums){
           int len = String.valueOf(num).length();
            if(len % 2 == 0) {
                count ++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        FindNumbers obj = new FindNumbers();
        int[] values = { 12,345,2,6,7896 };
       int val = obj.findNumbers(values);
       System.out.println(val);
    }
}
