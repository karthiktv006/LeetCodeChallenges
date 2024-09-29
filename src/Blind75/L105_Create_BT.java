package Blind75;

import Common.Array;
import Common.Tree;
import DataStructures.TreeNode;
import Helper.L105;
import Helper.L572;

import java.util.Arrays;

public class L105_Create_BT {
    public static void main(String[] args) {
        int[] pre1 = L105.tc1()[0];
        int[] in1 = L105.tc1()[1];
        TreeNode res1 = createBT(pre1, in1);
        new Tree().printBinaryTree(res1);

        System.out.println();

        int[] pre2 = L105.tc2()[0];
        int[] in2= L105.tc2()[1];
        TreeNode res2 = createBT(pre2, in2);
        new Tree().printBinaryTree(res2);

        System.out.println();

        int[] pre3 = L105.tc3()[0];
        int[] in3 = L105.tc3()[1];
        TreeNode res3 = createBT(pre3, in3);
        new Tree().printBinaryTree(res3);
    }


    // try to clean-up array creation part
    public static TreeNode createBT(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }

        if (preorder.length == 1) {
            return new TreeNode(preorder[0]);
        }

        int preFirst = preorder[0];
        TreeNode root = new TreeNode(preFirst);
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == preFirst) {
                int[] inLeft = Arrays.copyOfRange(inorder, 0, i);
                int[] inRight = (i + 1) < inorder.length ? Arrays.copyOfRange(inorder, i + 1, inorder.length) : new int[0];
                int [] preLeft = Arrays.copyOfRange(preorder, 1, 1 + i);
                int[] preRight = (i + 1) < preorder.length ? Arrays.copyOfRange(preorder, 1 + i, preorder.length) : new int[0];
                root.left = createBT(preLeft, inLeft);
                root.right = createBT(preRight, inRight);
            }
        }
        return root;

    }

    public static void pre(TreeNode root) {
        if (root != null) {
            System.out.print(root.val + ",");
            pre(root.left);
            pre(root.right);
        }
    }

    public static void in(TreeNode root) {
        if (root != null) {
            in(root.left);
            System.out.print(root.val + ",");
            in(root.right);
        }
    }


}
