package LeetCode75_V2;

public class L1768_MergeStringsAlternatively {
    public static void main(String[] args) {
        String word1 = "abcdef";
        String word2 = "xyz";

        //System.out.println(mergeAlternatively(word1, word2));
        //System.out.println(mergeAlternatively2(word2, word2));
        System.out.println(mergeAlternatively3(word1, word2));

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

    private static String mergeAlternatively2(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int maxLen = Math.max(word1.length(), word2.length());
        for (int i = 0; i < maxLen; i++) {
            if (i < word1.length()) {
                sb.append(word1.charAt(i));
            }
            if (i < word2.length()) {
                sb.append(word2.charAt(i));
            }
        }

        return sb.toString();
    }

    private static String mergeAlternatively3(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int i = 0, j= 0;
        while (i < word1.length() && j < word2.length()) {
            sb.append(word1.charAt(i++));
            sb.append(word2.charAt(j++));
        }
        sb.append(word1.substring(i));
        sb.append(word2.substring(j));

        return sb.toString();
    }
}
