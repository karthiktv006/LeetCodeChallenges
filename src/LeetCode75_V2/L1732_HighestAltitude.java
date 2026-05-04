package LeetCode75_V2;

public class L1732_HighestAltitude {
    public static void main(String[] args) {
        int[] gain = {-5,1,5,0,-7};
        int[] gain2 = {-4,-3,-2,-1,4,3,2};
        System.out.println(largestAltitude(gain2));
    }

    private static int largestAltitude(int[] gain) {
        int height = 0, maxHeight = 0;

        for (int i = 0; i < gain.length;i++) {
            height += gain[i];
            maxHeight = Math.max(maxHeight, height);
        }

        return maxHeight;

    }
}
