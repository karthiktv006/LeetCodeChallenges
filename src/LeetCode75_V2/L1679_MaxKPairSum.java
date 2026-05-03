package LeetCode75_V2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class L1679_MaxKPairSum {
    public static void main(String[] args) {
        int[] nums = {3,1,3,4,3};
        int k = 6;
        System.out.println(maxOperations(nums, k));
    }

    private static int maxOperations(int[] nums, int k) {
        int pairs = 0;
        HashMap<Integer, Integer> freq = new LinkedHashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (freq.containsKey(nums[i])) {
                freq.put(nums[i], freq.get(nums[i]) + 1);
            } else {
                freq.put(nums[i], 1);
            }
        }

        for (int key : freq.keySet()) {
            int pairKey = k - key;
            if (pairKey == key) {
                pairs += freq.get(key)/2;
            } else if (freq.containsKey(pairKey)){
                pairs += Math.min(freq.get(key), freq.get(pairKey));
                freq.put(pairKey, 0);
            }
            freq.put(key, 0);
        }

        return pairs;
    }

    // previously submitted solution - using left and right pointer
    private static int maxOperations2(int[] nums, int k) {
        Arrays.sort(nums);
        int count = 0;
        int left = 0, right = nums.length - 1;

        while (right > left) {
            int sum = nums[left] + nums[right];
            if (sum == k) {
                count += 1;
                right -= 1;
                left += 1;
            } else if (sum > k) {
                right -= 1;
            } else {
                left += 1;
            }
        }

        return count;
    }
}
