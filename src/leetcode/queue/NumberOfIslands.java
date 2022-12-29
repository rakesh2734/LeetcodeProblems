package leetcode.queue;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
 *
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 *
 * Input: grid = [
 *   ["1","1","1","1","0"],
 *   ["1","1","0","1","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","0","0","0"]
 * ]
 * Output: 1
 */
public class NumberOfIslands {

    // BFS approach
    public int numIslands(char[][] grid) {

        if(grid.length == 0 ) {
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        int count = 0;

        for(int i=0; i<m; i++ ){
            for (int j=0; j<n; j++){
                if(grid[i][j]== '1' && !visited[i][j]) {
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                    bfs(grid, queue, visited);
                    count++;
                }
            }
        }
        return count;
    }

    int[][] dirs = {{0,1}, {1,0}, {0,-1}, {-1,0}};
    private void bfs(char[][] grid, Queue<int[]> queue, boolean[][] visited) {
        int m = grid.length;
        int n = grid[0].length;

        while(!queue.isEmpty()) {

            int[] curr = queue.poll();
            for(int[] dir : dirs) {
                int x = curr[0] + dir[0];
                int y = curr[1] + dir[1];

                if( x<0 || x >= m || y<0 || y>=n || visited[x][y] || grid[x][y]== '0' )
                    continue;

                visited[x][y] = true;
                queue.offer(new int[]{x, y});
            }
        }
    }


    //DFS approach
    public int numIslandsDFS(char[][] grid) {

        //If empty, returns 0
        if(grid == null || grid.length == 0)
        {
            return 0;
        }

        //Tracking the number of islands
        int numberOfIslands = 0;

        //Looping over the entire grid and checking each cell
        //to find the islands
        for(int x = 0; x < grid.length; x++) {
            for(int y = 0; y < grid[0].length; y++) {

                //finding the number of islands using sink method
                numberOfIslands += sink(grid, x, y);
            }
        }

        return numberOfIslands;
    }

    int sink(char[][] grid, int x, int y) {

        //If x or y is out of the boundary, or the value of the cell is 0,
        //returns 0
        if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length ||
                grid[x][y] == '0') {
            return 0;
        }

        //Otherwise marks the cell as visited
        grid[x][y] = '0';

        //recursive call to check each direction (top, bottom, right, left)
        //of the current cell for existing islands
        sink(grid, x + 1, y);
        sink(grid, x - 1, y);
        sink(grid, x, y + 1);
        sink(grid, x, y - 1);

        //returning 1 adds to the total number of islands
        return 1;
    }

    public static void main(String[] args) {

        NumberOfIslands obj = new NumberOfIslands();

        char[][] grid = new char[][] {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };
        int numberOfIslands = obj.numIslands(grid);

        System.out.println("Number of islands are: " + numberOfIslands);
    }
}
