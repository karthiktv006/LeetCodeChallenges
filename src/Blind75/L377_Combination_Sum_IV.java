package Blind75;

public class L377_Combination_Sum_IV {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int target = 4;
        System.out.println(combi(nums, target));
    }

    public static int combiSum(int[] nums, int target) {
        if (target == 0) return 1;
        int res = 0;
        System.out.println("target:" + target);
        System.out.println("1res:" + res);
        for (int n: nums) {
            if (n <= target) {
                System.out.println("2res:" + res);
                res += combiSum(nums, target - n);
            }
        }
        return res;
    }

    public static int combi(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int n : nums) {
                if (n <= i) {
                    dp[i] += dp[i - n];
                }
            }
        }
        return dp[target];
    }


}
