public class Main {
    public static void main(String[] args) {
//        int[] prices = {};
//        int[] prices = {1, 2};
//        int[] prices = {1, 2, 3};
//        int[] prices = {3, 0, 1};
//        int[] prices = {0, 0, 0, 5};
//        int[] prices = {1, 2, 3, 4, 5};
//        int[] prices = {7, 6, 4, 3, 1};
//        int[] prices = {2, 3, 5, 0, 6};
//        int[] prices = {3, 2, 6, 5, 0, 3};
//        int[] prices = {1, 5, 2, 4, 8, 1, 2};
        int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};
        int k = 2;
        System.out.println(maxProfitRows(k, prices));
    }

    private static int maxProfitRows(int k, int[] prices) {
        int n = prices.length;
        if (n < 2 || k == 0) return 0;
        if (k >= n/2) return calcBasicCase(prices);     //basic case
        int[] prevRow = new int[n];
        int[] currRow = new int[n];
        for (int i = 1; i <= k; i++) {
            currRow = new int[n];
            int accGain = Integer.MIN_VALUE;
            for (int j = 1; j < n; j++) {
                accGain = Math.max(accGain, prevRow[j-1] - prices[j-1]);   //current accumulated gain
                currRow[j] = Math.max(currRow[j-1], accGain + prices[j]);
            }
            prevRow = currRow;
        }
        return currRow[n-1];
    }
    private static int calcBasicCase(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) profit += prices[i] - prices[i - 1];
        }
        return profit;
    }
    private static int maxProfitMatrix(int[] prices, int k) {
        int n = prices.length;
        if (n < 2 || k == 0) return 0;
        int[][] dp = new int[k+1][n];
        for (int i = 1; i <= k; i++) {
            int accGain = Integer.MIN_VALUE;
            for (int j = 1; j < n; j++) {
                accGain = Math.max(accGain, dp[i-1][j-1] - prices[j-1]);   //current accumulated gain
                dp[i][j] = Math.max(dp[i][j-1], accGain + prices[j]);
            }
        }
        return dp[k][n-1];
    }
}