package LeetCode75_V2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Set;

public class L1207_UniqueOccurrences {
    public static void main(String[] args) {
        int[] arr = {1,2,2,1,1,3};
        int[] arr2 = {1,2};
        System.out.println(uniqueOccurrences(arr2));
    }

    private static boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> map = new LinkedHashMap<>();
        Set<Integer> set = new HashSet<>();
        for (int a:arr) {
            if (map.containsKey(a)) {
                map.put(a, map.get(a) + 1);
            } else {
                map.put(a, 1);
            }
        }

        // its slow to get map.values, better to enumerate over entrySet
        // for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
        for (int m: map.values()) {
            if (set.contains(m)) {
                return false;
            } else {
                set.add(m);
            }
        }

        return true;
    }
}
