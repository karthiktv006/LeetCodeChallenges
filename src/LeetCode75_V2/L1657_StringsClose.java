package LeetCode75_V2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class L1657_StringsClose {
    public static void main(String[] args) {
        String word1 = "cabbba";
        String word2 = "abbccc";
        System.out.println(closeStrings(word1, word2));
    }

    // solution taken from leetcode
    private static boolean closeStrings(String word1, String word2) {
       int[] freq1 = new int[26];
       int[] freq2 = new int[26];

       for (char c1: word1.toCharArray()) {
           freq1[c1 - 'a']++;
       }

       for (char c2: word2.toCharArray()) {
           freq2[c2 - 'a']++;
       }

       for (int i = 0; i < freq1.length; i++) {
           if ((freq1[i] == 0 && freq2[i] != 0) || (freq1[i] != 0 && freq2[i] == 0)) return false;
       }

       Arrays.sort(freq1);
       Arrays.sort(freq2);

       for (int j = 0; j  < freq1.length; j++) {
           if (freq1[j] != freq2[j]) return false;
       }

       return true;
        
    }
}
