package Common;

import DataStructures.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Tree {
    public void printBinaryTree(TreeNode root) {
        if (root == null) return;
        System.out.println("root.val = " + root.val);
        printBinaryTree(root.left);
        printBinaryTree(root.right);
    }

    public void printBTLevel(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()) {
            level += 1;
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                if (node == null) {
                    System.out.print(" ");
                } else {
                    System.out.print(node.val + " ");
                    queue.add(node.left);
                    queue.add(node.right);
                }

            }
            System.out.println();

        }
    }
}
