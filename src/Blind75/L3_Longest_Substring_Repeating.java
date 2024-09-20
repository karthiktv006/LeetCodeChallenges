package Blind75;

public class L3_Longest_Substring_Repeating {
    public static void main(String[] args) {
        String str = "bbbbb";
        System.out.println(longest(str));
    }

    public static int longestSubstring(String s) {
        if (s.length() == 1) {
            return 1;
        }
        int overallMax = 0;
        for (int start = 0; start < s.length() - 1; start++) {
            int max = 1;
            for (int end = start + 1; end < s.length(); end++) {
                String sub = s.substring(start, end);
                if (sub.indexOf(s.charAt(end)) > -1) {
                    break;
                } else {
                    max++;
                    overallMax = Math.max(max, overallMax);
                }
            }
            overallMax = Math.max(max, overallMax);
        }
        return overallMax;
    }

    public static int longest(String s) {
        if (s.length() == 0) return 0;

        int start = 0, end = 1, max = 1, overallMax = 1;
        while (end < s.length()) {
            String sub = s.substring(start, end);
            if (sub.indexOf(s.charAt(end)) > -1) {
                start++;
                max--;
            } else {
                end++;
                max++;
            }
            overallMax = Math.max(max, overallMax);
        }
        return overallMax;
    }
}
