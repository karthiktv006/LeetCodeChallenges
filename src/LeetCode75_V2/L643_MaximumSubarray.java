package LeetCode75_V2;

public class L643_MaximumSubarray {
    public static void main(String[] args) {
        int[] nums = {1,12,-5,-6,50,3};
        int[] nums2 = {0,4,0,3,2};
        System.out.println(findMaxAverage(nums2, 1));
    }

    private static double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        int maxSum = 0;

        // maxAvg is maxSum for the sliding window, so find the max sum within the range
        for (int i = 0; i < nums.length; i++) {
            if (i < k) {
                sum += nums[i];
                if (i == k - 1) maxSum = sum;
            } else {
                sum = sum + nums[i] - nums[i - k];
                maxSum = Math.max(maxSum, sum);
            }
        }

        return (double) maxSum/k;
    }
}
