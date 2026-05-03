package LeetCode75_V2;

public class L443_StringCompression {
    public static void main(String[] args) {
        char[] chars = {'a', 'a', 'a', 'b', 'b', 'c', 'c'};
        char[] chars2 = {'a','b','b','b','b','b','b','b','b','b','b','b','b'};
        System.out.println(compress2(chars2));
    }

    private static int compress(char[] chars) {
       int repeat = 1;
       int insertAt = 1;
       char prev = chars[0];
       for (int i = 1; i < chars.length; i++) {
           if (chars[i] == prev) {
               repeat++;
           } else  {
               if (repeat != 1) {
                   String repeatAsStr = String.valueOf(repeat);
                   for (char r:repeatAsStr.toCharArray()) {
                       chars[insertAt] = r;
                       insertAt++;
                   }
               }
               repeat = 1;
               chars[insertAt] = chars[i];
               insertAt++;
               prev = chars[i];
           }
       }
       if (repeat != 1) {
           String repeatAsStr = String.valueOf(repeat);
           for (char r:repeatAsStr.toCharArray()) {
               chars[insertAt] = r;
               insertAt++;
           }
       }

       return insertAt;

    }

    private static int compress2(char[] chars) {
        int n = chars.length;
        int index = 0;
        for (int i = 0; i < n;) {
            char current = chars[i];
            int count = 0;

            // find repeating chars
            while(i < n && chars[i] == current) {
                count++;
                i++;
            }

            // write the chars first
            chars[index++] = current;

            // write the count next
            if (count > 1) {
                for (char c : String.valueOf(count).toCharArray()) {
                    chars[index++] = c;
                }
            }

        }

        return index;
    }

    // leetcode solutions looks more optimised
    private static int compress3(char[] chars) {
        int n = chars.length;
        int idx = 0;
        for (int i = 0; i < n; i++) {
            char ch = chars[i];
            int count = 0;
            while (i < n && chars[i] == ch) {
                count++;
                i++;
            }
            if (count == 1) {
                chars[idx++] = ch;
            } else {
                chars[idx++] = ch;
                for (char digit : Integer.toString(count).toCharArray()) {
                    chars[idx++] = digit;
                }
            }
            i--;
        }
        return idx;
    }

}
