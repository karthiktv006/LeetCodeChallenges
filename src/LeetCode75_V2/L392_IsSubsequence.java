package LeetCode75_V2;

public class L392_IsSubsequence {
    public static void main(String[] args) {
        String s = "abc";
        String t = "abjjskdfc";
        System.out.println(isSubsequence(s, t));
    }

    private static boolean isSubsequence(String s, String t) {
       int sp = 0;
       int tp = 0;
       while( sp < s.length() && tp < t.length()) {
           if (s.charAt(sp) == t.charAt(tp)) {
               sp++;
           }
           tp++;
       }

       return sp == s.length();
    }

}
