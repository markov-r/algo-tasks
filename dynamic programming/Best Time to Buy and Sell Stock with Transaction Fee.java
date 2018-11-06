import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
//        int[] prices = {};
//        int[] prices = {0};
//        int[] prices = {1, 5};
//        int[] prices = {5, 0};
//        int[] prices = {3, 0, 1};
//        int[] prices = {1, 2, 4, 9};
//        int[] prices = {0, 0, 0, 5};
//        int[] prices = {1, 0, 5, 9};
//        int[] prices = {1, 2, 3, 4, 5};
//        int[] prices = {7, 6, 4, 3, 1};
//        int[] prices = {2, 3, 5, 0, 6};
//        int[] prices = {1, 3, 2, 8, 5, 9};
//        int[] prices = {3, 2, 6, 6, 0, 3};
//        int[] prices = {1, 4, 7, 1, 5, 10};
//        int[] prices = {3, 3, 5, 0, 3, 1, 4};
        int[] prices = {1, 4, 0, 5, 8, 3, 10, 15};
        System.out.println(Arrays.toString(prices));
        int fee = 2;
        System.out.println(maxProfit(prices, fee));
    }
    private static int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        if (n < 2) return 0;
        int maxProf = 0;
        int prevMax = 0;
//        int[] dp = new int[n];
        int min = prices[0];
        for (int i = 1; i < n; i++) {
            min = Math.min(min, prices[i] - prevMax);
//            min = Math.min(min, prices[i] - dp[i-1]);
            maxProf = Math.max(prevMax, prices[i] - min - fee);
//            dp[i] = Math.max(dp[i-1], prices[i] - min - fee);
            prevMax = maxProf;
        }
        return maxProf;
//        System.out.println(Arrays.toString(dp));
//        return dp[n-1];
    }
}