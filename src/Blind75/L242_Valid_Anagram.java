package Blind75;

import java.util.HashMap;
import java.util.Map;

public class L242_Valid_Anagram {
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";

        System.out.println(isAnagram2(s, t));
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        Map<Character, Integer> map = new HashMap<>();
        for (char ch = 'a'; ch <= 'z'; ++ch)
            map.put(ch, 0);

        for (int i = 0; i < s.length(); i++) {
            char s_char = s.charAt(i);
            int s_char_count = map.getOrDefault(s_char, 0);
            map.put(s_char, ++s_char_count);

            char t_char = t.charAt(i);
            int t_char_count = map.getOrDefault(t_char, 0);
            map.put(t_char, --t_char_count);
        }

        for (int n : map.values()) {
            if (n != 0) return false;
        }

        return true;
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
