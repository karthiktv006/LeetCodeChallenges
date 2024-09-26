package Helper;

import DataStructures.TreeNode;

public class L102 {
    public static TreeNode tc1() {
        TreeNode n4 = new TreeNode(7);
        TreeNode n3 = new TreeNode(15);
        TreeNode n2 = new TreeNode(20, n3, n4);
        TreeNode n1 = new TreeNode(9);
        TreeNode n0 = new TreeNode(3, n1, n2);

        return n0;
    }
}
