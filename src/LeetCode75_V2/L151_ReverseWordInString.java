package LeetCode75_V2;

public class L151_ReverseWordInString {
    public static void main(String[] args) {
        String s = " the sky  is blue ";
        String[] strArr = s.trim().split("\\s+");

        System.out.println(reverseWords(s));
    }

    private static String reverseWords(String s) {
        String[] strArr = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = strArr.length - 1; i >= 0; i--) {
            if (i == 0) {
                sb.append(strArr[i]);
            } else {
                sb.append(strArr[i]).append(" ");
            }
        }

        return sb.toString();
    }
}
