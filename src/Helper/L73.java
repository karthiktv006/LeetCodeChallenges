package Helper;

import Common.Array;

public class L73 {
    public static int[][] tc1() {
        int[][] matrix = new int[3][3];
        int n = 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = n;
                n++;
            }
        }
        matrix[1][1] = 0;
        new Array().print2DArrayInteger(matrix);
        return matrix;
    }

    public static int[][] tc2() {
        int[][] matrix = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        return matrix;
    }
}
