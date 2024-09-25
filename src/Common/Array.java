package Common;

public class Array {
    public int[] createArray(int n) {
        int[] matrix = new int[n];
        int num = 1;
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = num;
            num++;
        }
        return matrix;
    }

    public int[][] createArray(int n, int m) {
        int[][] matrix = new int[n][m];
        int num = 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = num;
                num++;
            }
        }
        return matrix;
    }

    public void print1DArrayInteger(int[] arr) {
        for (int val: arr) {
            System.out.print(val);
        }
        System.out.println();
    }

    public void print2DArrayInteger(int[][] arr) {
        for (int[] row: arr) {
            for (int val: row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void print2DArrayCharacter(char[][] arr) {
        for (char[] row: arr) {
            for (char val: row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

}
