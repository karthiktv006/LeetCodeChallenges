package Blind75;

import java.util.Stack;

public class L20_Valid_Parentheses {
    public static void main(String[] args) {
        String s = "()[]";
        System.out.println(validParentheses(s));
    }

    public static boolean validParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        for (char i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (stack.isEmpty()){
                return false;
            } else {
                char p = stack.pop();
                if (!((c == ')' && p == '(') || (c == ']' && p == '[') || (c == '}' && p == '{'))) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

}
