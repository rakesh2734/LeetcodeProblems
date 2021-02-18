package leetcode.arrays.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class HighFiveAverage {

    public int[][] highFive(int[][] items) {
        Arrays.sort(items, new Comparator<int[]>() {
            // put item[id, score] with same id together
            // for each id/student, item[id, score] is ordered by score (increasing)
            public int compare(int[] t1, int[] t2) {
                if (t1[0] == t2[0]) {
                    return t2[1] - t1[1]; //[1,91], [1,92]
                }
                return t1[0] - t2[0];
            }
        });

        int N = items.length;
        // The list temp helps to calculate how many students/ids are there
        List<int[]> temp = new ArrayList<>();
        int i = 0;
        while (i < N) {
            int id = items[i][0];
            int count = 5, sum = 0;
            while (i < N && count-- > 0) {
                sum += items[i][1];
                i++;
            }
            temp.add(new int[]{id, sum / 5});

            // skip scores that are not the 'HighFive' for a student
            while (i < N && items[i][0] == id) i++;
        }

        int size = temp.size();
        int[][] res = new int[size][2];
        for (int j = 0; j < size; j++) {
            res[j] = temp.get(j);
        }
        return res;
    }

    public int[][] highFiveSecond(int[][] items) {
        if (items == null || items.length == 0) return items;
        // sort the array (first element increasing and second element decreasing)
        Arrays.sort(items, new Comparator<int[]>() {
            public int compare(int[] student1, int[] student2) {
                if (student1[0] == student2[0]) {
                    return student2[1] - student1[1];
                } else {
                    return student1[0] - student2[0];
                }
            }
        });
        int studentNums = items[items.length-1][0];
        int[][] ans = new int[studentNums][2];
        int count = 0, sum = 0, id ;
        for (int i = 0; i < items.length; i++) {
            id = items[i][0];
            if (count != 5 && id == items[i][0]) {
                sum += items[i][1];
                count++;
            }
            if (count == 5) {
                int average = sum / 5;
                sum = 0;
                count = 0;
                ans[id - 1][0] = id;
                ans[id - 1][1] = average;
                id++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        HighFiveAverage obj = new HighFiveAverage();

        int[][] arrvalue = {
                {1,91},{1,92},{3,93},{3,97},{1,60},{3,77},{1,65},{1,87},{1,100},{3,100},{3,76}
//                {1, 91}, {1, 92}, {2, 93}, {2, 97}, {1, 60}, {2, 77}, {1, 65}, {1, 87}, {1, 100}, {2, 100}, {2, 76}, {1, 60}
        };

        int[][] res = obj.highFive(arrvalue);

        System.out.println("the resp: " + Arrays.deepToString(res));
    }
}
