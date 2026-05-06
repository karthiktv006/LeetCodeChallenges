package LeetCode75_V2;

import java.util.Stack;

public class L2390_RemoveStars {
    public static void main(String[] args) {
        String s = "leet**cod*e";
        System.out.println(removeStars(s));
    }

    private static String removeStars(String s) {
        char[] arr = s.toCharArray();
        Stack<Character> stack = new Stack<>();

        for (char a:arr) {
            if (a != '*') {
                stack.push(a);
            } else {
                stack.pop();
            }
        }

        StringBuilder sb = new StringBuilder();

        for (char st:stack) {
            sb.append(st);
        }

        return sb.toString();
    }

    // leetcode solution - use stringbuilder instead of stack
    private static String removeStars2(String s) {
        StringBuilder sb = new StringBuilder();
        int j = 0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='*'){
                sb.deleteCharAt(sb.length()-1);
            }
            else{
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
