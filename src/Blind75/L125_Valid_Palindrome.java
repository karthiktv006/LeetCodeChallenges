package Blind75;

public class L125_Valid_Palindrome {
    public static void main(String[] args) {
        String s = "0P";
        System.out.println(validPalindrome(s));

    }

    public static boolean validPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c :s.toCharArray()) {
            if ((c >= '0' && c <= '9') ||  (c >= 'a' && c <= 'z')) {
                sb.append(c);
            }
            if (c >= 'A' && c <= 'Z') {
              sb.append((char) (c + 32));
            }

        }
        s = sb.toString();
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) return false;
        }
        return true;
    }
}
