package Blind75;

import Common.Array;

import java.util.Arrays;
import java.util.Comparator;

public class L56_Merge_Intervals {
    public static void main(String[] args) {
        int[][] arr = {{7, 3}, {6, 9}};
        merge(arr);
    }

    public static  int[][] merge(int[][] intervals) {
        int[][] tempIntervals = new int[intervals.length][2];
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        tempIntervals = intervals;
        new Array().print2DArrayInteger(intervals);

        int mergeIntervalCount = 0;

        for (int i = 1; i < tempIntervals.length; i++) {
            if (tempIntervals[i][0] <= tempIntervals[i - 1][1]) {
                tempIntervals[i][0] = Math.min(tempIntervals[i - 1][0], tempIntervals[i][0]);
                tempIntervals[i][1] = Math.max(tempIntervals[i - 1][1], tempIntervals[i][1]);

                tempIntervals[i - 1] = null;

                mergeIntervalCount += 1;
            }
        }

        new Array().print2DArrayInteger(tempIntervals);


        int[][] res = new int[tempIntervals.length - mergeIntervalCount][2];
        int index = 0;
        for (int[] interval: tempIntervals) {
            if (interval != null) {
                res[index] = interval;
                index += 1;
            }
        }

        new Array().print2DArrayInteger(res);

        return res;
    }
}
