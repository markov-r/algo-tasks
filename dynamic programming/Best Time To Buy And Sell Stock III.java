import java.util.Arrays;
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
        int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};
        System.out.println(maxProfit(prices));
    }
    /** This should be the standard "straightforward" DP solution:
    - create top-down DP array to store max profit per day from start to end
    - create bottom-up DP array to store the max profit from end to start
    - traverse both and find the max possible sum */

    private static int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int n = prices.length;
        int[] topDown = new int[n];                                  //Top-Down max profit for each day
        topDown[0] = 0;
        int currMin = prices[0];
        for (int i = 1; i < n; i++) {
            topDown[i] = Math.max(topDown[i - 1], prices[i] - currMin);
            if (prices[i] < currMin) currMin = prices[i];
        }
//            Arrays.stream(topDown)
//                    .forEach(x -> System.out.print(x + " "));
//            System.out.println();
        int[] bottomUp = new int[prices.length];                     //Bottom-Up max profit for each day
        bottomUp[n-1] = 0;
        int currMax = prices[n-1];
        for (int i = n - 2; i >= 0; i--) {
            bottomUp[i] = Math.max(bottomUp[i+1], currMax - prices[i]);
            if (prices[i] > currMax) currMax = prices[i];
        }
//        Arrays.stream(bottomUp)
//                .forEach(x -> System.out.print(x + " "));
//        System.out.println();
        int maxProfit = 0;                                           //Biggest sum for both DP arrays
        for (int i = 0; i < n; i++) {
            if (maxProfit < topDown[i] + bottomUp[i]) maxProfit = topDown[i] + bottomUp[i];
        }
        return maxProfit;
    }
}
