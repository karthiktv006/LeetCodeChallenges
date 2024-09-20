package Blind75;

import java.util.HashMap;
import java.util.Map;

public class L424_Longest_Repeating_Character_Replacement {
    public static void main(String[] args) {
        String s = "KRSCDCSONAJNHLBMDQGIFCPEKPOHQIHLTDIQGEKLRLCQNBOHNDQGHJPNDQPERNFSSSRDEQLFPCCCARFMDLHADJADAGNNSBNCJQOF";
        String s2 = "ABAB";
        int k = 4;
        System.out.println(longestRepeating(s, k));
        System.out.println(longestRepeating(s2, 2));
    }

    public static int longestRepeating(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch = 'A'; ch <= 'Z'; ch++) {
            map.put(ch, 0);
        }

        int l = 0, r = 0, max_f = 0, max_len = 0;

        while (r < s.length()) {
            int count = map.get(s.charAt(r)) + 1;
            map.put(s.charAt(r), count);
            if (count > max_f) max_f = count;
            int changeNeeded = r - l + 1 - max_f;
            System.out.println("count = " + count);
            System.out.println("l = " + l);
            System.out.println("r = " + r);
            System.out.println("l_char = " + s.charAt(l));
            System.out.println("r_char = " + s.charAt(r));
            System.out.println("max_f = " + max_f);
            System.out.println("changeNeeded = " + changeNeeded);
            if (changeNeeded <= k) {

                max_len = Math.max(max_len, r - l + 1);
                System.out.println("max_len = " + max_len);
                r++;
            } else {
                int c = map.get(s.charAt(l)) - 1;
                map.put(s.charAt(l), c);
                --count;
                l++;
                r++;
            }
            System.out.println();
        }

        return max_len;
    }
}
