package Blind75_Rev_I;

import Common.Array;

public class L238_ProductArrayExceptSelf {

    static Array array = new Array();

    public static void main(String[] args) {
        int[] tc1 = {1,2,3,4};
        int[] tc2 = {-1,1,0,-3,3};

        array.print1DArrayInteger(productExceptSelf(tc1));
        array.print1DArrayInteger(productExceptSelf(tc2));
    }

    public static int[] productExceptSelf(int[] nums) {

       int[] prefix = new int[nums.length];
       int[] suffix = new int[nums.length];

       int[] res = new int[nums.length];

       prefix[0] = 1;
       suffix[suffix.length - 1] = 1;

       for (int i = 1; i < prefix.length; i++) {
           prefix[i] = prefix[i - 1] * nums[i - 1];
       }

       array.print1DArrayInteger(prefix);

       // optimize to run once for prefix and suffix
       for (int j = suffix.length - 2; j >= 0; j--) {
           suffix[j] = suffix[j + 1] * nums[j + 1];
       }

       for (int k = 0; k < nums.length; k++) {
           res[k] = prefix[k] * suffix[k];
       }



       return res;

    }
}
