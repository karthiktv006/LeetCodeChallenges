package Blind75;

import Common.Tree;
import DataStructures.TreeNode;
import Helper.L226;

public class L226_Invert_BT {
    public static void main(String[] args) {
        TreeNode root = L226.tc1();
        Tree t = new Tree();
        t.printBinaryTree(root);
        System.out.println("\n-----");
        TreeNode inverted = invert(root);
        t.printBinaryTree(inverted);

    }

    public static TreeNode invert(TreeNode root) {
        if (root == null) return null;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invert(root.left);
        invert(root.right);
        return root;
    }
}
