package Blind75;

import Common.Array;
import Helper.L73;

import java.util.HashSet;

public class L73_Set_Matrix_Zeroes {
    public static void main(String[] args) {
        int[][] matrix = L73.tc2();
//        setZero(matrix);
        setZero2(matrix);
    }

    // Space: O(m+n)
    public static void setZero(int[][] matrix) {
        HashSet<Integer> rows = new HashSet<>();
        HashSet<Integer> cols = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }
        System.out.println("rows = " + rows);
        System.out.println("cols = " + cols);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (rows.contains(i) || cols.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }

        new Array().print2DArrayInteger(matrix);

    }

    // Space: O(1)
    public static void setZero2(int[][] matrix){
        new Array().print2DArrayInteger(matrix);
        boolean firstRowZero = false;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    if (i == 0) {
                        firstRowZero = true;
                    } else {
                        matrix[i][0] = 0;
                    }

                }
            }
        }
        new Array().print2DArrayInteger(matrix);

        for (int row = 1; row < matrix.length; row++) {
            for (int col = 1; col < matrix[0].length; col++) {
                if (matrix[0][col] == 0 || matrix[row][0] == 0) {
                    matrix[row][col] = 0;
                }
            }
        }

        new Array().print2DArrayInteger(matrix);

        if (matrix[0][0] == 0) {
            for (int r = 0;r < matrix.length; r++) {
                matrix[r][0] = 0;
            }
        }

        if (firstRowZero) {
            for (int c = 1;c < matrix[0].length; c++) {
                matrix[0][c] = 0;
            }
        }

        new Array().print2DArrayInteger(matrix);

    }
}
