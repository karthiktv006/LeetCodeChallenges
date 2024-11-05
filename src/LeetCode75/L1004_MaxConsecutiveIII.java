package LeetCode75;

public class L1004_MaxConsecutiveIII {
    public static void main(String[] args) {
        int[] nums = {1,1,1,0,0,0,1,1,1,1,0};
        int[] nums2 = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        System.out.println(longestOnes2(nums2, 3));
    }

    public static int longestOnes(int[] nums, int k) {
        int len = nums.length;
        int left = 0, right = 0;
        int maxOnes = 0;
        int zeroes = 0;

        while (right < len) {
            if (nums[right] == 1 && zeroes <= k) {
                right += 1;
            } else if (nums[right] == 0 && zeroes <= k) {
                right += 1;
                zeroes += 1;
            }

            if (zeroes > k && nums[left] == 1) {
                left += 1;
            } else if (zeroes > k && nums[left] == 0) {
                zeroes -= 1;
                left += 1;
            }

            maxOnes = Math.max(maxOnes, right - left);
        }

        return maxOnes;
    }

    public static int longestOnes2(int[] nums, int k) {
        int start=0;
        int end=0;
        int zeros=0;

        while(end<nums.length){
            if(nums[end] == 0){
                zeros++;
            }
            end++;
            if(zeros>k){
                if(nums[start] == 0){
                    zeros--;
                }
                start++;
            }
        }
        return end-start;
    }
}
