package LeetCode75_V2;

public class L1004_MaxConsecutiveOnesIII {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        int[] nums3 = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        int[] nums2 = {0,0,1,1,1,0,0};
        System.out.println(longestOnes2(nums2, 0));

    }

    private static int longestOnes(int[] nums, int k) {
        int size = 0;
        int maxSize = 0;
        int left = 0;
        int right = 0;
        while (left <= right && right < nums.length) {

            if (nums[right] == 1) {
                size++;
                right++;
            } else if (k > 0) {
                size++;
                k--;
                right++;
            } else {
                while (left <= right && k == 0) {
                    if (nums[left] == 1) {
                        left++;
                    } else {
                        left++;
                        //right--;
                        k++;
                    }
                    size--;
                }
            }

            maxSize = Math.max(maxSize, size);
        }

        return maxSize;
    }

    private static int longestOnes2(int[] nums, int k) {
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

    // optimal solution from leetcode
    private static int longestOnes3(int[] nums, int k) {
        int left = 0, maxLength = 0, zeroCount = 0;
        for (int right = 0; right < nums.length; ++right) {
            if (nums[right] == 0) {
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
        return maxLength;
    }

}
