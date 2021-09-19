package leetcode.challenges.febraury21;

/*Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7].
In this case, the max area of water (blue section) the container can contain is 49.*/
public class ContainsWithMostWater {
    public int maxArea(int[] height) {
        int max = 0;
        int n = height.length;
        int i = 0, j = n-1;
        // Two pointer approach
        while(i < j){
            int area = Math.min(height[i], height[j]) * (j- i) ;
            if(height[i] < height[j]){
                i++;
            }
            else {
                j--;
            }
            max = Math.max(area, max);
        }
        // Brute force
        // for(int i = 0; i<n; i++) {
        //     for(int j = 1; j < n; j++){
        //         int area = Math.min(height[i] , height[j]) * (j-i);
        //         max = Math.max(area, max);
        //     }
        // }

        return max;
    }
    public int maxAreaOn2(int[] height) {
        int max = 0;
        int n = height.length;
        for(int i = 0; i<n; i++) {
            for(int j = 1 ; j<n; j++){
                // Algorithm is to fill the water which will happen by max - next max
                int area = Math.min(height[i] , height[j]) * (j-i);
                max = Math.max(area, max);
            }
        }

        return max;
    }

    public int maxAreaOn(int[] height) {
        int max = 0;
        int n = height.length;
        int i = 0, j = n-1;
        while(i < j){
            int area = Math.min(height[i], height[j]) * (j- i) ;
            if(height[i] < height[j]){
                i++;
            }
            else {
                j--;
            }
            max = Math.max(area, max);
        }
        return max;
    }

    public static void main(String[] args) {
        ContainsWithMostWater obj = new ContainsWithMostWater();
        int[] height = {1,8,6,2,5,4,8,3,7};
//        int area = obj.maxAreaOn2(height);
        int area  = obj.maxAreaOn(height);
        System.out.println("area: " + area);

    }
}
