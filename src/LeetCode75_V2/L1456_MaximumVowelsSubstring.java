package LeetCode75_V2;

public class L1456_MaximumVowelsSubstring {
    public static void main(String[] args) {
        String s = "abciiidef";
        System.out.println(maxVowels(s, 4));
    }

    private static int maxVowels(String s, int k) {
        int maxVowels = 0;
        int count = 0;
        String vowels = "aeiou";
        for (int i = 0; i < k; i++) {
            if (isVowel(s.charAt(i))) {
                count++;
            }
        }

        maxVowels = count;

        for(int i = k; i < s.length(); i++) {
            if (isVowel(s.charAt(i))) {
                count++;
            }
            if (isVowel(s.charAt(i - k))) {
                count--;
            }
            maxVowels = Math.max(maxVowels, count);
        }

        return maxVowels;

    }

    // using this check beats 85% while using string to check beats only 30%
    private static boolean isVowel(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') return true;
        return false;
    }
}
