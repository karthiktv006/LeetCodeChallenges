package Blind75;

public class L198_House_Robber {
    public static void main(String[] args) {
        int[] nums = {2, 1, 1, 2};
        System.out.println(rob2(nums));
    }

    public static int rob(int[] nums) {
        int odd = 0, even = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                even += nums[i];
            } else {
                odd += nums[i];
            }
        }
        return Math.max(odd, even);
    }

    public static int rob2(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        if (nums.length > 1) dp[1] = Math.max(nums[1], dp[0]);

        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
            System.out.println(dp[i]);
        }
        return dp[nums.length - 1];
    }
}
