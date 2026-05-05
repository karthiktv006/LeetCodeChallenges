package LeetCode75_V2;

import java.util.Arrays;
import java.util.HashMap;

public class L2352_RowColumnPairs {
    public static void main(String[] args) {
        int[][] grid = {{3,2,1},{1,7,6},{2,7,7}};
        System.out.println(equalPairs(grid));
    }

    private static int equalPairs(int[][] grid) {
        HashMap<String, Integer> map = new HashMap<>();
        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            String s = Arrays.toString(grid[i]);
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        for (int i = 0; i < grid.length; i++) {
            int[] arr = new int[grid[i].length];
            for (int j = 0; j < grid[i].length; j++) {
                arr[j] = grid[j][i];
            }
            String s = Arrays.toString(arr);
            count += map.getOrDefault(s, 0);
        }

        return count;

    }
}
