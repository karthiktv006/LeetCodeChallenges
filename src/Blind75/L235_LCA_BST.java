package Blind75;

import DataStructures.TreeNode;
import Helper.L235;

public class L235_LCA_BST {
    public static void main(String[] args) {
        TreeNode root = L235.tc1();
//        TreeNode n = new TreeNode(3);
//        System.out.println(find(root, n));

        System.out.println(lca(root, root.left, root.right).val);
    }

    public static TreeNode lca(TreeNode root, TreeNode p, TreeNode q) {
        if (root == p || root == q) {
            return root;
        }
        if (root.val > q.val) {
            return lca(root.left, p, q);
        } else if (root.val < p.val) {
            return lca(root.right, p, q);
        } else {
            return root;
        }
    }

    private static boolean find(TreeNode haystack, TreeNode needle) {
        if (haystack != null) {
            if (haystack == needle) {
                return true;
            } else {
                return find(haystack.left, needle) || find(haystack.right, needle);
            }
        }
        return false;
    }

}



