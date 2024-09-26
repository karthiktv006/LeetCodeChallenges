package Blind75;

import DataStructures.TreeNode;
import Helper.L102;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class L102_BT_Level_Order_Traversal {
    public static void main(String[] args) {
        TreeNode root = L102.tc1();
        levelOrderTraversal(root);
    }

    public static List<List<Integer>> levelOrderTraversal(TreeNode root) {
        List<List<Integer>> list = new LinkedList<>();
        if (root == null) {
            return list;
        };
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> l = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                l.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            list.add(l);

        }
        System.out.println("list = " + list);
        return list;
    }
}
