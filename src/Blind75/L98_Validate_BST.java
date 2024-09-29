package Blind75;

import DataStructures.TreeNode;
import Helper.L98;

import java.util.ArrayList;
import java.util.List;

public class L98_Validate_BST {
    public static void main(String[] args) {
        TreeNode root = L98.tc1();
        TreeNode root2 = L98.tc2();
        TreeNode root3 = L98.tc3();
//        System.out.println(validateBST(root, Integer.MIN_VALUE));
//        System.out.println(validateBST(root2, Integer.MIN_VALUE));
//        System.out.println(validateBST(root3, Integer.MIN_VALUE));

//        System.out.println(validateBST2(root));
//        System.out.println(validateBST2(root2));
//        System.out.println(validateBST2(root3));

        System.out.println(validateBST3(root));
        System.out.println(validateBST3(root2));
        System.out.println(validateBST3(root3));
    }

    public static boolean validateBST3(TreeNode root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean validate(TreeNode root, long left, long right) {
        if (root == null) return true;
        if (root.val <= left || root.val >= right) return false;
        return validate(root.left, left, root.val) && validate(root.right, root.val, right);
    }

    public static boolean validateBST2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        System.out.println(list);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) <= list.get(i - 1)) return false;
        }
        return true;
    }

    public static void inorder(TreeNode root, List<Integer> list) {
        if (root != null) {
            inorder(root.left, list);
            list.add(root.val);
            inorder(root.right, list);
        }
    }

    public static boolean validateBST(TreeNode root, int min) {
        if (root == null) return true;
        boolean check = true;
        check = check && validateBST(root.left, min);
        System.out.println("min = " + min);
        if (root.val < min) {
            System.out.println("root.val = " + root.val);
            return false;
        }
        min = root.val;

        check = check && validateBST(root.right, min);
        return check;
    }

}
