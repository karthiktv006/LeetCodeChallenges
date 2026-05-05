package LeetCode75_V2;

public class L724_PivotIndex {
    public static void main(String[] args) {
        int[] nums = {1,7,3,6,5,6};
        System.out.println(pivotIndex(nums));
    }

    private static int pivotIndex(int[] nums) {
        int[] prefixSum = new int[nums.length];
        int[] postfixSum = new int[nums.length];

        for (int i = 1; i < nums.length; i++) {
            prefixSum[i] = nums[i-1] + prefixSum[i - 1];
        }

        for (int j = nums.length - 2; j >= 0; j--) {
            postfixSum[j] += nums[j+1] + postfixSum[j + 1];
        }

        for (int k = 0; k < nums.length; k++) {
            if (prefixSum[k] == postfixSum[k]) return k;
        }

        return -1;
    }
}
