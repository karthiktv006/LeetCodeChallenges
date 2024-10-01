package Blind75;

import Common.Array;
import Helper.L57;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class L57_Insert_Intervals {
    public static void main(String[] args) {
        int[][] intervals = L57.tc1();
        int[][] intervals2 = L57.tc2();
        int[][] intervals3 = L57.tc3();
        int[][] intervals4 = L57.tc4();
        int[] newInterval = {4, 8};

        insert2(intervals4, newInterval);

//        insert(intervals2, newInterval);
    }


    public static int[][] insert2(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> tempList = new ArrayList<>();
        boolean insert = false;
        for (int[] interval : intervals) {
            if (!insert && newInterval[0] < interval[0]) {
                tempList.add(newInterval);
                insert = true;
            }
            tempList.add(interval);
        }
        if (tempList.size() == intervals.length) {
            tempList.add(newInterval);
        }

        tempList.forEach((a) -> {
            System.out.println("a[0] = " + a[0]);
            System.out.println("a[1] = " + a[1]);
        });
        System.out.println();

        Iterator<int[]> iter = tempList.iterator();

        System.out.println("tempList = " + tempList.size());

        while (iter.hasNext()) {
            System.out.println("iter = " + iter);
            System.out.println("iter.next() = " + iter.next());
            System.out.println("iter.getClass() = " + iter.getClass());
        }


        for (int i = 1; i < tempList.size(); i++) {
            System.out.println("i = " + i);
            System.out.println("list = " + tempList.get(i)[0]);
            if (tempList.get(i)[0] <= tempList.get(i - 1)[1]) {
                int newStart = Math.min(tempList.get(i)[0], tempList.get(i - 1)[0]);
                int newEnd = Math.max(tempList.get(i)[1], tempList.get(i - 1)[1]);
                tempList.set(i, new int[]{newStart, newEnd});
                tempList.remove(i - 1);
                System.out.println("i = " + i);
                System.out.println("newStart = " + newStart);
                System.out.println("newEnd = " + newEnd);
                i -= 1;
            }
        }

        tempList.forEach((a) -> {
            System.out.println("a[0] = " + a[0]);
            System.out.println("a[1] = " + a[1]);
        });

        int[][] res = new int[tempList.size()][2];
        res = tempList.toArray(res);


        return res;
    }


    public static int[][] insert(int[][] intervals, int[] newInterval) {
        System.out.println("intervals = " + intervals);
        int size = intervals.length;
        int[][] tempIntervals = new int[size + 1][2];
        if (intervals.length == 0) {
            tempIntervals[0] = newInterval;
            return tempIntervals;
        }

        boolean insert = false;

        int in = 0;
        while (in < intervals.length) {
            if (!insert && newInterval[0] < intervals[in][0]) {
                tempIntervals[in] = newInterval;
                insert = true;
            }
            if (insert) {
                tempIntervals[in + 1] = intervals[in];
            } else {
                tempIntervals[in] = intervals[in];
            }
            if ((!insert && in == intervals.length - 1)) {
                tempIntervals[in + 1] = newInterval;
            }
            in += 1;
        }

        new Array().print2DArrayInteger(tempIntervals);
        System.out.println();

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
