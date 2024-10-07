package Blind75;

import Helper.L417;

import java.util.*;

class PANode {
    public int val;
    public int r;
    public int c;
    public boolean pacific;
    public boolean atlantic;
    public List<PANode> neighbors;

    PANode(int val) {
        this.val = val;
    }

    PANode(int val, List<PANode> neighbors) {
        this.val = val;
        this.neighbors = neighbors;
    }
}

// try solving using DFS
public class L417_Pacific_Atlantic_Water_flow {

    static int row;
    static int col;
    public static void main(String[] args) {
        int[][] heights = L417.tc2();
        pacificAtlantic(heights);
    }

    public static List<List<Integer>> pacificAtlantic(int[][] heights) {
        row = heights.length;
        col = heights[0].length;
        PANode[][] nodes = new PANode[row][col]; 
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                PANode temp = new PANode(heights[i][j]);
                if (i == 0 || j == 0) {
                    temp.pacific = true;
                }

                if (i == row - 1 || j == col - 1) {
                    temp.atlantic = true;
                }
                temp.r = i;
                temp.c = j;

                nodes[i][j] = temp;
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                List<PANode> neigh = new ArrayList<>();
                boolean pac = false;
                boolean atl = false;
                if (i > 0 && heights[i - 1][j] <= heights[i][j]) {
                    neigh.add(nodes[i - 1][j]);
                    pac = pac || nodes[i - 1][j].pacific;
                    atl = atl || nodes[i - 1][j].atlantic;
                }
                if (i + 1 < row && heights[i + 1][j] <= heights[i][j]) {
                    neigh.add(nodes[i + 1][j]);
                    pac = pac || nodes[i + 1][j].pacific;
                    atl = atl || nodes[i + 1][j].atlantic;
                }

                if (j > 0 && heights[i][j - 1] <= heights[i][j]) {
                    neigh.add(nodes[i][j - 1]);
                    pac = pac || nodes[i][j - 1].pacific;
                    atl = atl || nodes[i][j - 1].atlantic;
                }
                if (j + 1 < col && heights[i][j + 1] <= heights[i][j]) {
                    neigh.add(nodes[i][j + 1]);
                    pac = pac || nodes[i][j + 1].pacific;
                    atl = atl || nodes[i][j + 1].atlantic;
                }

                nodes[i][j].neighbors = neigh;
                nodes[i][j].pacific = nodes[i][j].pacific || pac;
                nodes[i][j].atlantic = nodes[i][j].atlantic || atl;

            }

        }

        traverse(nodes, nodes[row - 1][0]);
        traverse(nodes, nodes[0][col - 1]);
        traverse(nodes, nodes[0][0]);





//        for (int i = 0; i < row; i++) {
//            for (int j = 0; j < col; j++) {
//                nodes[i][j].atlantic = nodes[i][j].atlantic || dfsA(nodes[i][j]);
//                nodes[i][j].pacific = nodes[i][j].pacific || dfsP(nodes[i][j]);
//            }
//
//        }

        System.out.println("nodes = " + nodes);

        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                boolean bothPossible = nodes[i][j].pacific && nodes[i][j].atlantic;
                if (bothPossible) {
                    List<Integer> coord = new ArrayList<>();
                    coord.add(i);
                    coord.add(j);
                    res.add(coord);
                    System.out.println(i + "," + j + " = " + res);
                }

            }

        }
        
        return res;
    }

    public static void traverse(PANode[][] nodes, PANode node) {
        Queue<PANode> queue = new LinkedList<>();
        queue.add(node);
        int count = 0;
        Set<PANode> set = new HashSet<>();
        while (!queue.isEmpty()) {
            node = queue.remove();
            int r = node.r;
            int c = node.c;
            System.out.println("r,c = " + r + "," + c + " : " + count++);
            checkNeighbors(nodes, r, c);
            if (r > 0 && !set.contains(nodes[r - 1][c])) {
                System.out.println("adding " + Integer.valueOf(r - 1) + ":" + c);
                set.add(nodes[r - 1][c]);
                queue.add(nodes[r - 1][c]);
            }
            if (r + 1 < row && !set.contains(nodes[r + 1][c])) {
                set.add(nodes[r + 1][c]);
                queue.add(nodes[r + 1][c]);
            }
            if (c > 0 && !set.contains(nodes[r][c - 1])) {
                set.add(nodes[r][c - 1]);
                queue.add(nodes[r][c - 1]);
            }
            if (c + 1 < col && !set.contains(nodes[r][c + 1])) {
                set.add(nodes[r][c + 1]);
                queue.add(nodes[r][c + 1]);
            }
        }

    }

    public static void traverse2(PANode[][] nodes) {
        PANode node = nodes[0][col - 1];
        Queue<PANode> queue = new LinkedList<>();
        queue.add(node);
        int count = 0;
        Set<PANode> set = new HashSet<>();
        while (!queue.isEmpty()) {
            node = queue.remove();
            int r = node.r;
            int c = node.c;
            System.out.println("r,c = " + r + "," + c + " : " + count++);
            checkNeighbors(nodes, r, c);
            if (r > 0 && !set.contains(nodes[r - 1][c])) {
                System.out.println("adding " + Integer.valueOf(r - 1) + ":" + c);
                set.add(nodes[r - 1][c]);
                queue.add(nodes[r - 1][c]);
            }
            if (r + 1 < row && !set.contains(nodes[r + 1][c])) {
                set.add(nodes[r + 1][c]);
                queue.add(nodes[r + 1][c]);
            }
            if (c > 0 && !set.contains(nodes[r][c - 1])) {
                set.add(nodes[r][c - 1]);
                queue.add(nodes[r][c - 1]);
            }
            if (c + 1 < col && !set.contains(nodes[r][c + 1])) {
                set.add(nodes[r][c + 1]);
                queue.add(nodes[r][c + 1]);
            }
        }
    }

    public static void checkNeighbors(PANode[][] nodes, int i, int j) {
        boolean pac = false;
        boolean atl = false;
        if (i > 0 && nodes[i - 1][j].val <= nodes[i][j].val) {
            pac = pac || nodes[i - 1][j].pacific;
            atl = atl || nodes[i - 1][j].atlantic;
        }
        if (i + 1 < row && nodes[i + 1][j].val <= nodes[i][j].val) {
            pac = pac || nodes[i + 1][j].pacific;
            atl = atl || nodes[i + 1][j].atlantic;
        }

        if (j > 0 && nodes[i][j - 1].val <= nodes[i][j].val) {
            pac = pac || nodes[i][j - 1].pacific;
            atl = atl || nodes[i][j - 1].atlantic;
        }
        if (j + 1 < col && nodes[i][j + 1].val <= nodes[i][j].val) {
            pac = pac || nodes[i][j + 1].pacific;
            atl = atl || nodes[i][j + 1].atlantic;
        }

        nodes[i][j].pacific = nodes[i][j].pacific || pac;
        nodes[i][j].atlantic = nodes[i][j].atlantic || atl;
    }

//    public static boolean dfsA(PANode node) {
//        if (node.atlantic) return true;
//        if (node.neighbors.size() == 0) return false;
//
//        for (PANode n : node.neighbors) {
//            if (!visited.contains(n)) {
//                visited.add(n);
//                if (dfsA(n)) {
//                    n.atlantic = true;
//                    return true;
//                }
//                visited.remove(n);
//            }
//        }
//        node.atlantic = true;
//        return true;
//    }

//    public static boolean dfsP(PANode node) {
//        if (node.pacific) return true;
//        if (node.neighbors.size() == 0) return false;
//
//        for (PANode n : node.neighbors) {
//            if (!visited.contains(n)) {
//                visited.add(n);
//                if (dfsP(n)) {
//                    n.pacific = true;
//                    return true;
//                }
//                visited.remove(n);
//            }
//        }
//        node.pacific = true;
//        return true;
//    }

}
