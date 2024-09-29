package Helper;

import DataStructures.TreeNode;

public class L235 {
    public static TreeNode tc1() {
        TreeNode n8 = new TreeNode(5);
        TreeNode n7 = new TreeNode(3);
        TreeNode n6 = new TreeNode(9);
        TreeNode n5 = new TreeNode(7);
        TreeNode n4 = new TreeNode(4, n7, n8);
        TreeNode n3 = new TreeNode(0);
        TreeNode n2 = new TreeNode(8, n5, n6);
        TreeNode n1 = new TreeNode(2, n3, n4);
        TreeNode n0 = new TreeNode(6, n1, n2);

        return n0;
    }
}
