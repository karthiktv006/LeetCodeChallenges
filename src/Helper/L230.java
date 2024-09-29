package Helper;

import DataStructures.TreeNode;

public class L230 {
    public static TreeNode tc1() {
        TreeNode n3 = new TreeNode(2);
        TreeNode n2 = new TreeNode(4);
        TreeNode n1 = new TreeNode(1, null, n3);
        TreeNode n0 = new TreeNode(3, n1, n2);

        return n0;
    }

    public static TreeNode tc2() {
        TreeNode n5 = new TreeNode(1);
        TreeNode n4 = new TreeNode(4);
        TreeNode n3 = new TreeNode(3, n5, null);
        TreeNode n2 = new TreeNode(6);
        TreeNode n1 = new TreeNode(3, n3, n4);
        TreeNode n0 = new TreeNode(5, n1, n2);

        return n0;
    }

    public static TreeNode tc3() {
        TreeNode n1 = new TreeNode(1);
        TreeNode n0 = new TreeNode(1, n1, null);

        return n0;
    }
}
