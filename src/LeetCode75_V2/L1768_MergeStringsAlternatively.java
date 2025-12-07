package LeetCode75_V2;

public class L1768_MergeStringsAlternatively {
    public static void main(String[] args) {
        String word1 = "abcdef";
        String word2 = "xyz";

        System.out.println(mergeAlternatively(word1, word2));

    }

    private static String mergeAlternatively(String word1, String word2) {
        int shortLen, longLen;
        shortLen = Math.min(word1.length(), word2.length());
        longLen = Math.max(word1.length(), word2.length());

        StringBuilder res = new StringBuilder();

        for (int i = 0; i < shortLen; i++) {
            res.append(word1.charAt(i)).append(word2.charAt(i));
        }
        if (word1.length() == longLen) {
            word2 = word1;
        }
        for (int i = shortLen; i < longLen; i++) {
            res.append(word2.charAt(i));
        }

        return res.toString();

    }
}
