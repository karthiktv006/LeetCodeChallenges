package LeetCode75_V2;

public class L238_ProductArray {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(productExceptSelf(nums));
    }

    private static int[] productExceptSelf(int[] nums) {
        int[] prefix = new int[nums.length];
        int[] suffix = new int[nums.length];
        int[] res = new int[nums.length];
        prefix[0] = 1;
        suffix[nums.length - 1] = 1;

        for(int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i - 1] * nums[i - 1];
        }

        for (int j = nums.length - 2; j >= 0;j--) {
            suffix[j] = suffix[j + 1] * nums[j + 1];
        }

        for (int k = 0; k < nums.length; k++) {
            res[k] = prefix[k] * suffix[k];
        }

        return res;
    }
}
