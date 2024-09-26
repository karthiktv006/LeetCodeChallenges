package Helper;

import DataStructures.TreeNode;

public class L226 {
    public static TreeNode tc1() {
        TreeNode n6 = new TreeNode(9);
        TreeNode n5 = new TreeNode(6);
        TreeNode n4 = new TreeNode(3);
        TreeNode n3 = new TreeNode(1);
        TreeNode n2 = new TreeNode(7, n5, n6);
        TreeNode n1 = new TreeNode(2, n3, n4);
        TreeNode n0 = new TreeNode(4, n1, n2);

        return n0;
    }
}
