package LeetCode75_V2;

public class L345_ReverseVowels {
    public static void main(String[] args) {
        System.out.println(reverseVowels("IceCreAm"));
    }

    private static String reverseVowels(String s) {
        char[] strArr = s.toCharArray();
        String vowels = "AEIOUaeiou";
        int start = 0, end = strArr.length - 1;

        while(end > start) {
            if (vowels.indexOf(strArr[start]) == -1) {
                start += 1;
                continue;
            }
            if (vowels.indexOf(strArr[end]) == -1) {
                end -= 1;
                continue;
            }

            char temp = strArr[start];
            strArr[start] = strArr[end];
            strArr[end] = temp;

            start += 1;
            end -= 1;
        }
        String res = new String(strArr);
        return res;
    }

}
