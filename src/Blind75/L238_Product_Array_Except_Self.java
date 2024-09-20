package Blind75;

import java.io.PrintStream;

public class L238_Product_Array_Except_Self {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4};

        int[] res = productExceptSelf(arr);
        for(int i : res) {
            System.out.print(i + " ");
        }

    }

    public static int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] prefix_product = new int[len];
        int right = 1;
        int[] res = new int[nums.length];
        prefix_product[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            prefix_product[i] = prefix_product[i - 1] * nums[i - 1];
        }
        for(int i = nums.length - 1; i >= 0; i--) {
            res[i] = prefix_product[i] * right;
            right = nums[i] * right;
        }

        return res;
    }
}
