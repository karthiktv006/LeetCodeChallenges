package Blind75;

public class L5_Longest_Palindrome {
    public static void main(String[] args) {
        String s = "aacabdkacaa";
        System.out.println(longestPalindrome3(s));
    }

    //brute force
    public static String longestPalindrome(String s) {
        String max = "";

        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                String sub = s.substring(i, j+1);
                if (L125_Valid_Palindrome.validPalindrome(sub) && sub.length() > max.length()) {
                    max = sub;
                }
            }
        }
        return max;
    }

    // wrong implementation
    public static String longestPalindrome2(String s) {
        String max = "";

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                if (i - j < 0 || i + j + 1 > s.length()) break;
                if (s.charAt(i - j) == s.charAt(i + j)) {
                    System.out.println(s.charAt(i - j) + ":" + s.charAt(i + j));
                    String sub = s.substring(i - j, i + j + 1);
                    if (sub.length() > max.length()) max = sub;
                    System.out.println(max);
                }
            }
        }

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                if (i - j < 0 || i + j + 2 > s.length()) break;
                if (s.charAt(i - j) == s.charAt(i + j + 1)) {
                    String sub = s.substring(i - j, i + j + 2);
                    if (sub.length() > max.length()) max = sub;
                }

            }
        }

        return max;
    }

    public static String longestPalindrome3(String s) {
        String max = "";

        for (int i = 0; i < s.length(); i++) {
            int l = i, r = i;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                String sub = s.substring(l, r + 1);
                if (sub.length() > max.length()) max = sub;
                l -= 1;
                r += 1;
            }

            l = i;
            r = i + 1;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                String sub = s.substring(l, r + 1);
                if (sub.length() > max.length()) max = sub;
                l -= 1;
                r += 1;
            }

        }

        return max;
    }
}
