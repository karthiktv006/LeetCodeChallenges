package LeetCode75_V2;

import java.util.ArrayList;
import java.util.List;

public class L1431_KidsCandies {
    public static void main(String[] args){
        int[] candies = {2,3,5,1,3};
        int extraCandies = 3;
        System.out.println(kidsWithCandies(candies, extraCandies));
    }

    private static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> res = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        int i = 0, j = 0;
        while (i < candies.length) {
            if (candies[i] > max) {
                max = candies[i];
            }
            i++;
        }
        while (j < candies.length) {
            if (candies[j] + extraCandies >= max) {
                res.add(true);
            } else {
                res.add(false);
            }
            j++;
        }
        return res;
    }
}
