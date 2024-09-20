package Blind75;

import java.util.ArrayList;
import java.util.List;

public class L139_Word_Break {
    public static void main(String[] args) {
        String str = "applepenapple";
        List<String> list = new ArrayList<>();
        list.add("apple");
        list.add("pen");
        System.out.println(wordBreak(str, list));

    }

    public static boolean findWord(String str, List<String> list) {
        int index = 0, prev_index = 0;

        while (index != str.length()) {
            System.out.println(index);
            for (String s: list) {
                String sub = str.substring(index, index + s.length());
                System.out.println(sub);
                if (sub.equals(s)) {
                    index += s.length();
                }

                if (index == str.length()) break;
            }
            if (index == prev_index) {
                break;
            } else {
                prev_index = index;
            }
        }


        return index == str.length();
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[s.length()] = true;
        for (int i = s.length() - 1; i >= 0; i--) {
            for (String word: wordDict) {
                if ((i + word.length()) <= s.length() && s.substring(i, i + word.length()).equals(word)) {
                    dp[i] = dp[i + word.length()];
                }
                if (dp[i]) break;
            }
        }

        return dp[0];

    }
}
