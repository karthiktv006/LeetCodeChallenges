package Blind75;

import Common.Array;
import Helper.L48;

public class L48_Rotate_Image {
    public static void main(String[] args) {
        int[][] matrix = L48.tc2();
        rotate(matrix);
    }

    public static void rotate(int[][] matrix) {
        int len = matrix.length;

        new Array().print2DArrayInteger(matrix);
        int offset = 0;
        while (offset < len / 2) {
            for (int i = 0; i < matrix.length - 1 - (2 * offset); i++) {
                // P1: matrix[0][len - 1 -i]
                // P2: matrix[i][0]
                // P3: matrix[len - 1][i]
                // P4: matrix[len - 1 - i][len - 1]

                // P1: matrix[offset][len - 1 -i - offset]
                // P2: matrix[i + offset][offset]
                // P3: matrix[len - 1 - offset][i + offset]
                // P4: matrix[len - 1 - i - offset][len - 1 - offset]
                // P1 and P2
                int temp = matrix[offset][len - 1 - i - offset];
                matrix[offset][len - 1 - i - offset] = matrix[i + offset][offset];
                matrix[i + offset][offset] = temp;

                // P2 and P3
                temp = matrix[i + offset][offset];
                matrix[i + offset][offset] = matrix[len - 1 - offset][i + offset];
                matrix[len - 1 - offset][i + offset] = temp;

                // P3 and P4
                temp = matrix[len - 1 - offset][i + offset];
                matrix[len - 1 - offset][i + offset] = matrix[len - 1 - i - offset][len - 1 - offset];
                matrix[len - 1 - i - offset][len - 1 - offset] = temp;

            }
            offset += 1;
        }


        new Array().print2DArrayInteger(matrix);
    }
}
