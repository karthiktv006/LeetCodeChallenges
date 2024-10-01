package Blind75;

import Common.Array;
import Helper.L435;

import java.util.Arrays;
import java.util.Comparator;

public class L435_NonOverlapping_Intervals {
    public static void main(String[] args) {
        int[][] intervals = L435.tc1();
        System.out.println(eraseOverlapIntervals(intervals));
    }

    public static int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        new Array().print2DArrayInteger(intervals);

        int eraseCount = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < intervals[i - 1][1]) {
                int[] useInterval = new int[2];
                if ((intervals[i][1] - intervals[i][0]) > (intervals[i - 1][1] - intervals[i - 1][0])) {
                    useInterval[0] = intervals[i - 1][0];
                    useInterval[1] = intervals[i - 1][1];
                } else {
                    useInterval[0] = intervals[i][0];
                    useInterval[1] = intervals[i][1];
                }

                intervals[i] = useInterval;
                intervals[i - 1] = null;
                eraseCount += 1;
            }
        }
        return eraseCount;
    }
}
