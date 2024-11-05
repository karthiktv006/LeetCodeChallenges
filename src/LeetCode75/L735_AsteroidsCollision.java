package LeetCode75;

import java.util.Stack;

public class L735_AsteroidsCollision {
    public static void main(String[] args) {
        int[] nums = {10, 2, -5};
    }

    public static int[] asteroidCollision(int[] nums) {
        int len = nums.length;
        Stack<Integer> negStack = new Stack<>();
        Stack<Integer> posStack = new Stack<>();
        int start = 0, end = len;
        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) {
                start = i;
                break;
            } else {
                negStack.push(nums[i]);
            }
        }

        for (int i = len; i >= 0; i--) {
            if (nums[i] < 0) {
                end = i;
                break;
            } else {
                posStack.push(nums[i]);
            }
        }

        System.out.println("start = " + start);
        System.out.println("end = " + end);

        int maxPos = Integer.MIN_VALUE;
        int maxNeg = Integer.MAX_VALUE;

        for (int i = start; i < end; i++) {
            if (nums[i] < 0) {
                maxNeg = Math.min(maxNeg, nums[i]);
            } else {
                maxPos = Math.max(maxPos, nums[i]);
            }
        }

        int sum = maxPos + maxNeg;

        if (sum > 0) {
            negStack.push(maxPos);
        } else if (sum < 0) {
            negStack.push(maxNeg);
        }

        int[] res = new int[negStack.size() + posStack.size()];
        while (!negStack.isEmpty()) {
            posStack.push(negStack.pop());
        }
        int index = 0;
        while (!posStack.isEmpty()) {
            nums[index] = posStack.pop();
        }

        return res;

    }
}
