package Blind75;

import Helper.L128;

import java.util.HashSet;
import java.util.Set;

public class L128_Longest_Consecutive_Sequence {
    public static void main(String[] args) {
        int[] nums = L128.tc2();
        System.out.println(longestConsecutive(nums));
    }

    public static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }

        int longest = 0;
        for (int n : set) {
            if (!set.contains(n - 1)) {
                int len = 1;
                while (set.contains(n + len)) {
                    len += 1;
                }
                longest = Math.max(longest, len);
            }
        }


        return longest;
    }
}
