package Blind75;

import DataStructures.TreeNode;
import Helper.L104;

import java.util.LinkedList;
import java.util.Queue;

public class L104_Maximum_Depth_BT {
    public static void main(String[] args) {
        TreeNode root = L104.tc1();
        System.out.println(maxDepthDfs(root));
        System.out.println(maxDepthBfs(root));
    }

    // use dfs
    public static int maxDepthDfs(TreeNode root) {
        if (root == null) return 0;
        System.out.println(root.val);
        return Math.max(1 + maxDepthDfs(root.left), 1 + maxDepthDfs(root.right));
    }

    // use bfs
    public static int maxDepthBfs(TreeNode root) {
        if (root == null) return 0;
        int level = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            for (int i = 0; i < queue.size(); i++) {
                TreeNode node = queue.remove();
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            level += 1;
        }
        return level;
    }
}
