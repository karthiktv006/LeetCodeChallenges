package LeetCode75_V2;

public class L11_MostWater {
    public static void main(String[] args) {
        int[] height =  {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }

    private static int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int gap = right - left;
        int max = 0;
        while (right > left) {
            int area = Math.min(height[left], height[right]) * gap;
            max = Math.max(area, max);
            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
            gap--;
        }

        return max;
    }
}
