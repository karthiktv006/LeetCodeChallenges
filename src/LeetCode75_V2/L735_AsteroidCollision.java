package LeetCode75_V2;

import java.util.Stack;

public class L735_AsteroidCollision {
    public static void main(String[] args) {
        int[] asteroids = {5, 10, -5};
        int[] asteroids2 = {8, -8};
        int[] asteroids3 = {10,2,-5};
        int[] asteroids4 = {3,5,-6,2,-1,4};
        System.out.println(asteroidCollision(asteroids3));
    }

    private static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int ast : asteroids) {
            if (ast > 0 || stack.isEmpty()) {
                stack.push(ast);
            } else {
                while (!stack.isEmpty()) {
                    int last = stack.pop();
                    if (last + ast < 0 && stack.isEmpty()) {
                        stack.push(ast);
                        break;
                    } else if (last < 0 && ast < 0) {
                        stack.push(last);
                        stack.push(ast);
                        break;
                    } else if (last + ast > 0) {
                        stack.push(last);
                        break;
                    } else if (last + ast == 0) {
                        break;
                    }
                }

            }
        }

        int[] res = new int[stack.size()];
        int i = 0;

        for (int st:stack) {
            res[i++] = st;
        }

        return res;

    }

    // leetcode solution
    public static int[] asteroidCollision2(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int a : asteroids) {
            if (a > 0) {
                stack.push(a);
            } else {
                while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < -a) {
                    stack.pop();
                }

                if (stack.isEmpty() || stack.peek() < 0)  {
                    stack.push(a);
                }

                if (stack.peek() == -a) {
                    stack.pop();
                }
            }
        }

        int[] res = new int[stack.size()];
        int i = stack.size() - 1;

        while(!stack.isEmpty()) {
            res[i--] = stack.pop();
        }

        return res;
    }
}
