package Helper;

import Common.Array;

public class L54 {
    public static int[][] tc1() {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        return matrix;
    }

    public static int[][] tc2() {
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        return matrix;
    }

    public static int[][] tc3() {
        int[][] matrix = {{1,2,3,4,5}};
        return matrix;
    }

    public static int[][] tc4() {
        int[][] matrix = new Array().createArray(5, 5);
        return matrix;
    }
}
