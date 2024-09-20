package Blind75;

import Common.Array;

public class L1143_LCS {
    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "ace";
        System.out.println(longestSubsequence(text1, text2));
    }

    public  static int longestSubsequence(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        int[][] LCS = new int[len1 + 1][len2 + 1];

        for (int i = len1 - 1; i >= 0; i--) {
            for (int j = len2 - 1; j >= 0; j--) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    LCS[i][j] = 1 + LCS[i + 1][j + 1];
                } else {
                    LCS[i][j] = Math.max(LCS[i+ 1][j], LCS[i][j + 1]);
                }
            }
        }

        new Array().print2DArrayInteger(LCS);

        return LCS[0][0];
    }
}
