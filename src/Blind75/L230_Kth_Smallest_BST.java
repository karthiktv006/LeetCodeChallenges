package Blind75;

import DataStructures.TreeNode;
import Helper.L230;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class L230_Kth_Smallest_BST {
    static int i = 1;
    public static void main(String[] args) {
        TreeNode root = L230.tc1();
//        System.out.println(findKthSmallest(root, 2));
        System.out.println(findKthSmallest3(root, 2));

    }

    public static int findKthSmallest3(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        int i = 0;
        while (!stack.isEmpty() || curr != null) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            i += 1;
            if (k == i) return curr.val;
            curr = curr.right;
        }
        return -1;
    }

    public static int findKthSmallest2(TreeNode root, int k) {
        int v = 0;
        if (root != null) {
            v += findKthSmallest2(root.left, k);
            System.out.println("i = " + i);
            System.out.println("k = " + k);
            System.out.println("root.val = " + root.val);
            if (k == i) {
                v = root.val;
            };
            i += 1;
            v += findKthSmallest2(root.right, k);
        }
        return v;
    }



    public static int findKthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        for (int i = 0; i < list.size(); i++) {
            if (i == k - 1) {
                return list.get(i);
            }
        }
        return -1;
    }

    private static void inorder(TreeNode root, List<Integer> list) {
        if (root != null) {
            inorder(root.left, list);
            list.add(root.val);
            inorder(root.right, list);
        }
    }
}
