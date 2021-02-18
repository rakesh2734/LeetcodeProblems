package leetcode.arrays.easy;

public class MinTimeToVisitAllPoints {

    public int minTimeToVisitAllPoints(int[][] points) {
        int n = points.length;
        int count =0;

        for (int i=1; i<n; i++){
            int x1 = points[i-1][0];
            int y1 = points[i-1][1];

            int x2 = points[i][0];
            int y2 = points[i][1];

            int xD = Math.abs(x2-x1);
            int yD = Math.abs(y1-y2);

            count += Math.max(xD, yD);

//            int diagonalSteps = Math.min(xD, yD);
//            int xSteps = xD - diagonalSteps;
//            int ySteps = yD - diagonalSteps;
//            count += diagonalSteps +xSteps+ySteps;

       /*while(i<n&&j<=n){
            int x1 = points[i][0];
            int x2 = points[j][0];

            int y1 = points[i][1];
            int y2 = points[j][1];

            if(x1==x2 && y1==y2 )
                return 0;
            else if(y1==y2 && x1!=x2){
                count = xIncre(x1,x2);
            }
        }*/
        }

        return count;
    }
    /*public int xIncre(int x1, int x2){
            int xSum = 0;
            xSum++;

            int val = x1<x2 ? x1++:x2++;

            return xSum;
        }*/
    public int dist(int[]p1, int[]p2){
        int xd = Math.abs(p2[0] - p1[0]);
        int yd = Math.abs(p2[1] - p1[1]);
        if(xd>yd){
            return xd;
        }
        else
            return yd;
    }
    public int minTime(int[][] points){
        int steps =0;
        for (int i=1; i<points.length; i++){
            steps += dist(points[i-1], points[i]);
        }
        return steps;
    }
    public static void main(String[] args) {
        MinTimeToVisitAllPoints obj = new MinTimeToVisitAllPoints();

        int[][] values = {
                {1,1}, {3,4}, {-1, 0}
        };
        int steps = obj.minTimeToVisitAllPoints(values);
        System.out.println(steps);
    }
}
