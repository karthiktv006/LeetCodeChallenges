package Blind75;

import Common.Array;
import Helper.L79;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

public class L79_Word_Search {
    public static void main(String[] args) {
        char[][] board = L79.tc1();
        String word = "ABCCEDFC";
        System.out.println(wordSearch(board, word));
    }

    public static boolean wordSearch(char[][] board, String word) {
        HashMap<Character, ArrayList<int[]>> table = new HashMap<>();
        int[][] boardCheck = new int[board.length][board[0].length];
        for (int i = 65; i <= 90; i++) {
            table.put((char) i, null);
        }
        new Array().print2DArrayCharacter(board);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                char c = board[i][j];
                if (table.get(c) == null) {
                    ArrayList<int[]> l = new ArrayList<>();
                    l.add(new int[]{i, j});
                    table.put(c, l);

                } else {
                    table.get(board[i][j]).add(new int[]{i, j});
                }

                if (c == word.charAt(0)) {
                    boardCheck[i][j] = 1;
                }
            }
        }

        for (int i = 1; i < word.length(); i++) {
            char c = word.charAt(i);
            char prev = word.charAt(i - 1);
            System.out.println("char = " + c);
            if (table.get(c) == null) return false;
            for (int[] point:table.get(c)) {
                new Array().print1DArrayInteger(point);
                int row = point[0];
                int col = point[1];
                if ((row + 1) < board.length && board[row + 1][col] == prev) {
                    boardCheck[row][col] = Math.max(boardCheck[row + 1][col] + 1, boardCheck[row][col]);
                }
                if ((row - 1) >= 0 && board[row - 1][col] == prev) {
                    boardCheck[row][col] = Math.max(boardCheck[row - 1][col] + 1, boardCheck[row][col]);
                }
                if ((col + 1) < board[0].length && board[row][col + 1] == prev) {
                    boardCheck[row][col] = Math.max(boardCheck[row][col + 1] + 1, boardCheck[row][col]);
                }
                if ((col - 1) >= 0 && board[row][col - 1] == prev) {
                    boardCheck[row][col] = Math.max(boardCheck[row][col - 1] + 1, boardCheck[row][col]);
                }
            }
        }

        boolean lengthCheck = false;
        int wordLen = word.length();
        char lastChar = word.charAt(wordLen - 1);
        for (int[] point:table.get(lastChar)) {
            int x = point[0];
            int y = point[1];
            if (boardCheck[x][y] == wordLen) lengthCheck = true;
        }
        new Array().print2DArrayInteger(boardCheck);

        return lengthCheck;

    }
}
