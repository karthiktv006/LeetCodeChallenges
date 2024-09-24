package Blind75;

import Common.Array;
import Helper.L54;

import java.util.ArrayList;
import java.util.List;

public class L54_Spiral_Matrix {
    public static void main(String[] args) {
        int[][] matrix = L54.tc2();
        new Array().print2DArrayInteger(matrix);
        System.out.println(spiral(matrix));
    }

    // does not work for 1 row or 1 col matrix
    public static void printSpiralMatrix(int[][] matrix, int offset) {
        int r = offset, c = offset, rows = matrix.length - 2 * offset, cols = matrix[0].length - 2 * offset;
        System.out.println("rows = " + rows);
        System.out.println("cols = " + cols);
        while (c - offset < cols - 1) {
            System.out.println(matrix[r][c]);
            c += 1;
        }
        while (r - offset < rows - 1 ) {
            System.out.println(matrix[r][c]);
            r += 1;
        }
        while (c -offset > 0) {
            System.out.println(matrix[r][c]);
            c -= 1;
        }
        while (r - offset > 0) {
            System.out.println(matrix[r][c]);
            r -= 1;
        }

    }

    public static List<Integer> spiral(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int left = 0, top = 0, right = matrix[0].length - 1, bottom = matrix.length - 1;
        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++) {
                res.add(matrix[top][i]);
            }
            top += 1;
            for (int i = top; i <= bottom; i++) {
                res.add(matrix[i][right]);
            }
            right -= 1;
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    res.add(matrix[bottom][i]);
                }
                bottom -= 1;
            }
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    res.add(matrix[i][left]);
                }
                left += 1;
            }
        }
        return res;
    }
}
