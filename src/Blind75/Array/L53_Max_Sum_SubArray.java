package Blind75.Array;

public class L53_Max_Sum_SubArray {
    public static void main(String[] args) {
        int[] arr = {1, -4, 6, -5, 3};
        int[] arr2 = {-2,1,-3,4,-1,2,1,-5,4};
        int[] arr3 = {5,4,-1,7,8};

        System.out.println(maxSubArray(arr3));
    }

    public static int maxSubArray(int[] arr) {
        int overallMax = Integer.MIN_VALUE, currentMax = 0;
        for (int i = 0; i < arr.length; i++) {
            currentMax += arr[i];

            if (currentMax > overallMax) {
                overallMax = currentMax;
            }

            if (currentMax < 0) {
                currentMax = 0;
            }
        }

        return overallMax;
    }
}
