package Blind75;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class L15_3Sum {
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        System.out.println(findList(nums));
    }

    public static List<List<Integer>> findList(int[] nums) {
        Hashtable<Integer, Integer> table = new Hashtable<>(60);
        List<List<Integer>> result = new ArrayList<>(60);

        for (int i = 0; i < nums.length; i++) {
            int count = table.getOrDefault(nums[i], 0);
            table.put(nums[i], ++count);
        }

        for (int i = 0; i < nums.length; i++) {
            int i_value = nums[i];
            int count = table.get(i_value);
            table.put(i_value, --count);
            for (int j = i+1; j <nums.length -1; j++) {
                int j_value = nums[j];
                int remaining = -i_value - j_value;
                int count_j = table.get(j_value);
                table.put(i_value, --count_j);
                int r = table.getOrDefault(remaining, -2);
                if (r != -2) {
                    List<Integer> l = new ArrayList<Integer>();
                    l.add(i_value);
                    l.add(j_value);
                    l.add(remaining);
                    result.add(l);
                }
                table.put(j_value, ++count_j);
            }
            table.put(i_value, ++count);
        }

        return result;


    }
}
