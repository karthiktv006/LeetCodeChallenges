package Helper;

import DataStructures.TreeNode;

public class L105 {
    public static int[][] tc1() {
        int[] pre = {1, 2};
        int[] in = {2, 1};
        return new int[][]{pre, in};
    }

    public static int[][] tc2() {
        int[] pre = {1, 2, 4, 5, 3, 6, 7};
        int[] in = {4, 2, 5, 1, 6, 3, 7};
        return new int[][]{pre, in};
    }

    public static int[][] tc3() {
        int[] pre = {3, 4, 1, 2, 5};
        int[] in = {1, 4, 2, 3, 5};
        return new int[][]{pre, in};
    }
}
