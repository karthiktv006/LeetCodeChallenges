package LeetCode75_V2;

import java.util.Stack;

public class L394_DecodeString {
    public static void main(String[] args) {
        String s = "3[a]2[bc]";
        String s2 = "3[a2[c]]";
        String s3 = "10[leetcode]";
        System.out.println(decodeString(s3));
        char a = '9';
        System.out.println((int) a);
    }

    private static String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c:s.toCharArray()) {
            if ((int) c >= 48 || (int) c <= 57 ) {
                
            }
            if (c != ']') {
                stack.push(c);
            } else {
                Stack<Character> temp = new Stack<>();
                while (stack.peek() != '[') {
                    temp.push(stack.pop());
                }
                stack.pop();
                int times = stack.pop() - '0';

                char[] arrTemp = new char[temp.size()];
                for (int i = 0; i < arrTemp.length; i++) {
                    arrTemp[i] = temp.pop();
                }
                for (int i = 0; i < times; i++) {
                    for (int j = 0; j < arrTemp.length; j++) {
                        stack.push(arrTemp[j]);
                    }
                }

            }
        }

        int size = stack.size();
        char[] res = new char[size];


        for (int j = size - 1; j >= 0; j--) {
            res[j] = stack.pop();
        }

        return String.valueOf(res);
    }
}
