package Blind75;

import Common.TreeNode;
import Helper.L100;

public class L100_Same_Tree {
    public static void main(String[] args) {
        TreeNode p = L100.tc1();
        TreeNode q = L100.tc2();
        System.out.println(dfs(p, p));
    }

    public static boolean dfs(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null || p.val != q.val) return false;
        System.out.println("p.val = " + p.val);
        System.out.println("q.val = " + q.val);
        return dfs(p.left, q.left) && dfs(p.right, q.right);
    }
}
