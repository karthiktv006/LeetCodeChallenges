package Helper;

import Common.TreeNode;

public class L100 {
    public static TreeNode tc1() {
        TreeNode n2 = new TreeNode(3);
        TreeNode n1 = new TreeNode(2);
        TreeNode n0 = new TreeNode(1, n1, n2);

        return n0;
    }

    public static TreeNode tc2() {
        TreeNode n1 = new TreeNode(2);
        TreeNode n0 = new TreeNode(1, n1, null);

        return n0;
    }
}
