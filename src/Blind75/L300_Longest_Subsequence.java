package Blind75;

public class L300_Longest_Subsequence {
    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        int[] nums2 = {0, 1, 4, 3};
        System.out.println(longSub(nums));
    }

    public static int longestSub(int[] nums) {
        int count = 1;
        int min_index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < nums[min_index]) min_index = i;
        }
        int n = nums[min_index];
        for (int j = min_index + 1; j < nums.length; j++) {
            if (nums[j] > n) {
                count++;
                n = nums[j];
            }
        }

        return count;

    }

    public static int longSub(int[] nums){
        int[] LIS = new int[nums.length];
        LIS[nums.length -1 ] = 1;
        int overMax = 0;
        for (int i = nums.length -1; i >= 0; i--) {
            int maxLen = 1;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] < nums[j])  {
                    maxLen = Math.max(maxLen, 1 + LIS[j]);
                }
            }
            LIS[i] = maxLen;
            overMax = Math.max(overMax, maxLen);
        }

        return overMax;
    }
}
