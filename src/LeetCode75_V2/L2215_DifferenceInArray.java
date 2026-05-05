package LeetCode75_V2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class L2215_DifferenceInArray {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3};
        int[] nums2 = {2,4,6};

        System.out.println(findDifference(nums1, nums2));

    }

    private static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> nums1Set = new HashSet<>();
        Set<Integer> nums2Set = new HashSet<>();
        List<Integer> res1 = new ArrayList<>();
        List<Integer> res2 = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();

        for (int n1:nums1) {
            nums1Set.add(n1);
        }

        for (int n2: nums2) {
            nums2Set.add(n2);
        }

        for (int n1:nums1) {
            if (!nums2Set.contains(n1) && !res1.contains(n1)) res1.add(n1);
        }

        for (int n2:nums2) {
            if (!nums1Set.contains(n2) && ! res2.contains(n2)) res2.add(n2);
        }


        res.add(res1);
        res.add(res2);

        return res;

    }
}
