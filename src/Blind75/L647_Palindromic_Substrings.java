package Blind75;

public class L647_Palindromic_Substrings {
    public static void main(String[] args) {
        String s = "abaaba";
        System.out.println(palindromicSubstrings(s));
    }

    public static int palindromicSubstrings(String s) {
        int substringCount = 0;

        for (int i = 0; i < s.length(); i++) {
            int l = i, r = i;

            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                substringCount += 1;
                l -= 1;
                r += 1;
            }

            l = i;
            r = i + 1;

            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                substringCount += 1;
                l -= 1;
                r += 1;
            }

        }

        return substringCount;
    }
}
