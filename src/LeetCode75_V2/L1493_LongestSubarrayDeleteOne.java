package LeetCode75_V2;

public class L1493_LongestSubarrayDeleteOne {
    public static void main(String[] args) {
        int[] nums = {1,1,0,1};
        int[] nums2 = {0,1,1,1,0,1,1,0,1};
        int[] nums3 = {1,1,1};
        System.out.println(longestSubarray(nums3));
    }

    private static int longestSubarray(int[] nums) {
        int left = 0, maxLength = 0, zeroCount = 0;
        int k = 1;
        for (int right = 0; right < nums.length; right++) {
            if(nums[right] == 0) {
                zeroCount++;
            }

            while (zeroCount > k) {
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength - 1;
    }
}
