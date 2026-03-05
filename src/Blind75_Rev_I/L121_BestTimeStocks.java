package Blind75_Rev_I;

public class L121_BestTimeStocks {
    public static void main(String[] args) {
        int[] tc1 = {7,1,5,3,6,4};
        int[] tc2 = {7,6,4,3,1};
        int[] tc3 = {2,4,1};
        int[] tc4 = {2,1,2,1,0,1,2};
        int[] tc5 = {3,3,5,0,0,3,1,4};

        maxProfit(tc1);
        maxProfit(tc2);
        maxProfit(tc3);
        maxProfit(tc4);
        maxProfit(tc5);

    }

    public static int maxProfit(int[] prices) {
        int min = prices[0];
        int max = 0;
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
                max = min;
            } else if (prices[i] >= max) {
                max = prices[i];

                if (max - min > maxProfit) {
                    maxProfit = max - min;
                }

            }






            System.out.println("min:" + min + "max:" + max + "maxProfit:" + maxProfit);
        }

        System.out.println(maxProfit);
        return maxProfit;
    }
}
