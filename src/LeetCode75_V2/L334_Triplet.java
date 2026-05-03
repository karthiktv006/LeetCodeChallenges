package LeetCode75_V2;

public class L334_Triplet {
    public static void main(String[] args) {
        int[] nums = {2,1,5,0,4,6};
        int[] nums2 = {4,5,0,6};
        System.out.println(increasingTriplet(nums2));
    }

    private static boolean increasingTriplet(int[] nums) {
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        for(int n : nums) {
            if(n <= min1) min1 = n;
            else if(n <= min2) min2 = n;
            else return true;
        }
        return false;
    }
}
