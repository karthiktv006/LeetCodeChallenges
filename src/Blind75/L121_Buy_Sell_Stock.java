package Blind75;

public class L121_Buy_Sell_Stock {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }

    private static int maxProfit(int[] prices) {
        int maxProfit = 0;
        int buy = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > buy) {
                maxProfit = Math.max(maxProfit, prices[i] - buy);
            } else {
                buy = prices[i];
            }
        }
        return maxProfit;
    }
}
