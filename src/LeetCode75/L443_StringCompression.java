package LeetCode75;

public class L443_StringCompression {
    public static void main(String[] args) {
        char[] chars = {'a','a','b','b','c','c','c'};
        System.out.println(compress(chars));
    }

    public static int compress(char[] chars) {
        int length = chars.length;
        int prev_char = chars[0];
        int count = 1;
        int pointer = 1;

        for (int i = 1; i < length; i++) {
            if (chars[i] == prev_char) {
                count += 1;
            } else if (chars[i] != prev_char) {
                System.out.println(prev_char);
                System.out.println(count);
            }
        }

        return 0;

    }
}
