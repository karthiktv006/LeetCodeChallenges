package Helper;

import DataStructures.TreeNode;

public class L572 {
    public static TreeNode tc1a() {
//        TreeNode n5 = new TreeNode(0);
        TreeNode n4 = new TreeNode(2);
        TreeNode n3 = new TreeNode(1);
        TreeNode n2 = new TreeNode(5);
        TreeNode n1 = new TreeNode(4, n3, n4);
        TreeNode n0 = new TreeNode(3, n1, n2);

        return n0;
    }

    public static TreeNode tc1b() {
        TreeNode n2 = new TreeNode(2);
        TreeNode n1 = new TreeNode(1);
        TreeNode n0 = new TreeNode(4, n1, n2);

        return n0;
    }
}
