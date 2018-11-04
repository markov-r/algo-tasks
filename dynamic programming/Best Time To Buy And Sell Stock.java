public class Main {

    public static void main(String[] args) {
//        int[] prices = {};
//        int[] prices = {1};
//        int[] prices = {2, 1};
//        int[] prices = {2, 3, 6, 1, 4};
//        int[] prices = {100, 80, 120, 130, 70, 60, 100, 125};
//        int[] prices = {7, 9, 5, 6, 3, 2};
//        int[] prices = {7, 1, 5, 3, 6, 4};
        int[] prices = {6, 5, 4, 3, 2, 1};
        System.out.println(maxProfit(prices));
    }

    private static int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int min = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > min) {
                maxProfit = Math.max(maxProfit, prices[i] - min);
            } else {
                min = prices[i];
            }
        }
        return maxProfit;
    }
}