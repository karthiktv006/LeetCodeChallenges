package LeetCode75;

public class L1071_GCD_Strings {
    public static void main(String[] args) {
        String b = "ABABAB";
        String a = "ABAB";
        System.out.println(gcdOfStrings(a, b));
    }

    public static String gcdOfStrings(String str1, String str2) {
        if (str1.length() < str2.length()) return gcdOfStrings(str2, str1);

        int len1 = str1.length();
        int len2 = str2.length();

        for (int i = len2 - 1; i >= 0; i--) {
            if (len1 % (i + 1) == 0 && len2 % (i + 1) == 0) {
                String pre = str1.substring(0, i + 1);
                int fact1 = len1 / (i + 1);
                int fact2 = len2 / (i + 1);
                StringBuilder s1 = new StringBuilder();
                StringBuilder s2 = new StringBuilder();

                for (int x = 0; x < fact1; x++) {
                    s1.append(pre);
                }

                for (int y = 0; y < fact2; y++) {
                    s2.append(pre);
                }

                if (s1.toString().equals(str1) && s2.toString().equals(str2)) return pre;

            }
        }

        return "";
    }
}
