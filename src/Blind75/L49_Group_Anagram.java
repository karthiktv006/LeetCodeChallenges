package Blind75;

import java.util.ArrayList;
import java.util.List;

public class L49_Group_Anagram {
    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        String[] strs2 = {"eat","tea"};
        group(strs);
    }

    public static List<List<String>> group(String[] strs) {
        List<List<String>> list = new ArrayList<>();
        for (String s: strs) {
            boolean anagramFound = false;
            for (List<String> strings : list) {
                if (isAnagram2(s, strings.getFirst())) {
                    strings.add(s);
                    anagramFound = true;
                    break;
                }
            }
            if (!anagramFound) {
                List<String> l = new ArrayList<>();
                l.add(s);
                list.add(l);
            }

        }

        for (List<String> ll:list) {
            System.out.println(ll);

        }
        return list;
    }

    public static boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] map = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int s_char = s.charAt(i) - 97;
            map[s_char]++;

            int t_char = t.charAt(i) - 97;
            map[t_char]--;

        }

        for (int n : map) {
            if (n != 0) return false;
        }

        return true;
    }
}
