package LeetCode75_V2;

public class L1071_GCD_Strings {
    public static void main(String[] args) {
        String str1 = "ABABAB";
        String str2 = "ABAB";

        System.out.println(gcdOfStrings(str1, str2));
    }

    private static String gcdOfStrings(String str1, String str2) {
        int minLen = Math.min(str1.length(), str2.length());

        for (int l = minLen; l > 0; l--) {
            if (str1.length() % l == 0 && str2.length() % l == 0) {
                String prefix = str1.substring(0, l);
                int times1 = str1.length() / l;
                int times2 = str2.length() / l;

                StringBuilder sb1 = new StringBuilder();
                StringBuilder sb2 = new StringBuilder();

                String s1 = prefix.repeat(times1);
                String s2 = prefix.repeat(times2);

                if (s1.equals(str1) && s2.equals(str2)) {
                    return prefix;
                }
            }
        }
        return "";
    }

}
