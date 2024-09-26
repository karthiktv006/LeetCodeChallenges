package Blind75;

import Common.Tree;
import DataStructures.TreeNode;
import Helper.L572;

public class L572_SubTree_Check {
    public static void main(String[] args) {
        TreeNode root = L572.tc1a();
        TreeNode subRoot = L572.tc1b();
        System.out.println(inOrder(root));
        System.out.println(inOrder(subRoot));
//        System.out.println(check(root, subRoot));

        System.out.println(isSubtree(root, subRoot));
    }

    public static String inOrder(TreeNode root) {
        if (root != null) {
            return inOrder(root.left) + root.val + inOrder(root.right);
        } else {
            return "_";
        }
    }

    public static boolean check(TreeNode root, TreeNode subRoot) {
        String r = inOrder(root);
        String s = inOrder(subRoot);
        return r.contains(s);
    }

    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (subRoot == null) return true;
        if (root == null) return false;
        if (sameTree2(root, subRoot)) return true;
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public static boolean sameTree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) return true;
        if (root != null && subRoot != null && root.val == subRoot.val) {
            return sameTree(root.left, subRoot.left) && sameTree(root.right, subRoot.right);
        }
        return false;
    }

    public static boolean sameTree2(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) return true;
        if (root == null || subRoot == null || root.val != subRoot.val) return false;
        return sameTree2(root.left, subRoot.left) && sameTree2(root.right, subRoot.right);
    }
}
