package Blind75;

public class L152_Max_Product_SubArray {
    public static void main(String[] args) {
        int[] nums = {2, 3, -2, 4};
        int[] nums2 = {-2, 0, -1};
        int[] nums3 = {-3, -1, -1};
        int[] nums4 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        System.out.println(maxProductSubArray(nums4));

    }

    public static int maxProductSubArray(int[] nums) {
        int ans = nums[0];
        int dpMin = nums[0]; // the minimum so far
        int dpMax = nums[0]; // the maximum so far

        for (int i = 1; i < nums.length; ++i) {
            final int num = nums[i];
            final int prevMin = dpMin; // dpMin[i - 1]
            final int prevMax = dpMax; // dpMax[i - 1]
            if (num < 0) {
                dpMin = Math.min(prevMax * num, num);
                dpMax = Math.max(prevMin * num, num);
            } else {
                dpMin = Math.min(prevMin * num, num);
                dpMax = Math.max(prevMax * num, num);
            }
            System.out.println("min:" + dpMin);
            System.out.println("max:" + dpMax);
            System.out.println("-------------");
            ans = Math.max(ans, dpMax);
        }

        return ans;
    }
}
