package leetcode.arrays.explore.conclusion;

public class HeightChecker {
    public int heightChecker(int[] heights) {
        int[] heightCompare = new int[101];

        for(int height : heights){
            heightCompare[height]++;
        }
        int cnt =0;
        int height_ptr = 1;
        for(int i =0; i<heights.length; i++){
            while(heightCompare[height_ptr] == 0){
                height_ptr++;
            }
            if( height_ptr != heights[i]){
                cnt++;
            }
            heightCompare[height_ptr]--;
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] heights = {1,1,4,2,1,3};
        HeightChecker h = new HeightChecker();
        int output = h.heightChecker(heights);
        System.out.println("number of students need to reoder from heights to form non-decreasing /n");
        System.out.println(":"+ output);
    }
}
