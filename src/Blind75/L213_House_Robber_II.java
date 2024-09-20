package Blind75;

import java.util.Arrays;

public class L213_House_Robber_II {
    public static void main(String[] args) {
        int[] nums = {2, 1, 1, 2};
        int[] nums2 = {1, 2, 1, 1};
        System.out.println(robHelper(nums2));
        int[] arr1 = Arrays.copyOfRange(nums2, 0, nums.length - 1);
        int[] arr2 = Arrays.copyOfRange(nums2, 1, nums.length);
        System.out.println(robHelper(arr1));
        System.out.println(robHelper(arr2));

    }

    public static int robHelper(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        if (nums.length > 1) dp[1] = Math.max(nums[1], dp[0]);

        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
        }
        return dp[nums.length - 1];
    }


}
