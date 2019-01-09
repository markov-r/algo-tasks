import java.util.Arrays;
public class Main {

    //The name of the problem is the Change-Making problem
    //(https://en.wikipedia.org/wiki/Change-making_problem)
    //the most common variation of Coin Change problem.
    //Change-Making problem is a variation of the Knapsack problem,
    //more precisely - the Unbounded Knapsack problem, also known as the Complete Knapsack problem.
    //The "core" Coin Change problem is slightly different - finding the ways of making a certain change.
    //More information about Knapsack problems in the book by Martello/Toth :
    // http://www.or.deis.unibo.it/kp/KnapsackProblems.pdf

    /** Matrix dynamic programming solution
     *  First row is all Int.MAX_VALUE.
     *  The rest are filled like:
     *  - if j (current sum) is less than current coin - copy old solution from above
     *  - if j == coin => fill one
     *  - if j > coin fill use the min of (j-coin) + 1 and old solution
     *  That way we reuse the previous solutions from the same row
     *  using any number of coins of each type. */

    private static int minCoins(int coins[], int sum) {
        if (sum == 0) return 0;
        long[][] dp = new long[coins.length + 1][sum + 1];
        for (int i = 0; i <= sum; i++) {
            dp[0][i] = Integer.MAX_VALUE;
        }
        for (int i = 1; i <= coins.length; i++) {
            for (int j = 0; j <= sum; j++) {
                if (j < coins[i-1])  dp[i][j] = dp[i-1][j];
                if (j == coins[i-1]) dp[i][j] = 1;
                if (j > coins[i-1])  dp[i][j] = Math.min(dp[i-1][j], dp[i][j-coins[i-1]] + 1);
            }
        }
//        System.out.println(Arrays.deepToString(dp).replace("], ", "]\n")
//                .replace("[[", "[")
//                .replace("]]", "]"));

        return (int) dp[coins.length][sum] == Integer.MAX_VALUE ? -1 : (int) dp[coins.length][sum];
    }

    /** Simplifying the above DP
     * Use an 1D arr with sums [0..sum], initialize it with MAX_VALUE
     * Then fill it for each coin and reuse the previous arr values
     * and update only if you've found better (smaller) value. */

    private static int minCoins1dArr(int coins[], int sum) {
        int[] dp = new int[sum+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= sum; i++) {
//            dp[i] = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (i >= coin && dp[i-coin] != Integer.MAX_VALUE)
                    dp[i] = Math.min(dp[i], dp[i-coin] + 1);
            }
        }
//        System.out.println(Arrays.toString(dp));
        return dp[sum] == Integer.MAX_VALUE ? -1 : dp[sum];
    }



    public static void main(String[] args) {
        int[] nums = {1}; int sum = 0;
//        int[] nums = {1, 5}; int sum = 7;
//        int[] nums = {2, 5}; int sum = 1;
//        int[] nums  = {1, 2, 5}; int sum = 7;
//        int[] nums = {1, 2, 5}; int sum = 11;
//        int[] nums = {1, 2, 100}; int sum = 7;
//        int[] nums = {1, 3, 4}; int sum = 6;
//        int[] nums = {4, 3, 1}; int sum = 7;
//        int[] nums = {2, 3, 5}; int sum = 6;
//        int[] nums = {9, 6, 5, 1}; int sum = 11;
//        int[] nums = {83, 186, 408, 419}; int sum = 6249;
//        int[] nums = {431, 62, 88, 428}; int sum = 9084;

        System.out.println((minCoins(nums, sum)));
        System.out.println((minCoins1dArr(nums, sum)));

    }
}