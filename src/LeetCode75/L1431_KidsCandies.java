package LeetCode75;

import java.util.ArrayList;
import java.util.List;

public class L1431_KidsCandies {
    public static void main(String[] args) {
        int[] candies = {2,3,5,1,3};
        int extraCandies = 3;
        System.out.println(kidsWithCandies(candies, extraCandies));
    }

    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = candies[0];
        for (int c : candies) {
            max = Math.max(c, max);
        }

        List<Boolean> res = new ArrayList<>();
        for (int c : candies) {
            if (c + extraCandies >= max) {
                res.add(true);
            } else {
                res.add(false);
            }
        }

        return res;
    }
}
