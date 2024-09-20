package Blind75;

public class L153_Min_RotatedArray {
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        int[] nums2 = {3,4,5,1,2};
        int[] nums3 = {11,13,15,17};
        int[] nums4 = {2, 1};
        int[] nums5 = {2,3,1};
        int[] nums6 = {5,1,2,3,4};
        System.out.println(findMin(nums));

//
//        {1, 2, 3, 4, 5}
//        {5, 1, 2, 3, 4}
//        {3, 4, 5, 1, 2}
    }

    public static int findMin(int[] nums) {
        int start = 0, end = nums.length -1, mid = (start + end) / 2;

        while (start != mid) {
            System.out.println("start: " + start + ":" + nums[start] );
            System.out.println("mid: " + mid + ":" + nums[mid] );
            System.out.println("end: " + end + ":" + nums[end] );
            System.out.println("----------");
            if (nums[mid] < nums[end]) {
                end = mid;
            } else {
                start = mid;
            }
            mid = (start + end) / 2;
        }

        return Math.min(nums[start], nums[end]);

    }

}
