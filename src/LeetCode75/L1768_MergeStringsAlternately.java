package LeetCode75;

public class L1768_MergeStringsAlternately {
    public static void main(String[] args) {
        String a = "abc";
        String b = "pqr";
        System.out.println();
        System.out.println(mergeAlternately(a, b));
    }

    public static String mergeAlternately(String word1, String word2) {
        StringBuilder str = new StringBuilder();
        int maxLen = Math.max(word1.length(), word2.length());

        for (int i = 0; i < maxLen; i++) {
            if (i < word1.length()){
                str.append(word1.charAt(i));
            }
            if (i < word2.length()) {
                str.append(word2.charAt(i));
            }
        }

        return str.toString();
    }
}
