package Blind75;

import Helper.L200;

public class L200_Number_Islands {
    static int ROWS;
    static int COLS;

    public static void main(String[] args) {
        char[][] grid = L200.tc2();
        System.out.println(numberOfIslands(grid));
    }

    public static int numberOfIslands(char[][] grid) {
        ROWS = grid.length;
        COLS = grid[0].length;
        boolean[][] visited = new boolean[ROWS][COLS];
        int count = 0;

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    dfs(i, j, visited, grid);
                    count += 1;
                }
            }

        }

        return count;

    }

    public static void dfs(int r, int c, boolean[][] visited, char[][] grid) {
        if (r < 0 || r >= ROWS || c < 0 || c >= COLS || visited[r][c] || grid[r][c] == '0') return;
        visited[r][c] = true;
        dfs(r - 1, c, visited, grid);
        dfs(r + 1, c, visited, grid);
        dfs(r, c - 1, visited, grid);
        dfs(r, c + 1, visited, grid);

    }
}
