public class Main {

    public static void main(String[] args) {
        System.out.println(minCostClimbingStairs(new int[]{0}));
        System.out.println(minCostClimbingStairs(new int[]{0, 1}));
        System.out.println(minCostClimbingStairs(new int[]{0, 1, 2}));
        System.out.println(minCostClimbingStairs(new int[]{1, 3, 5, 1}));
        System.out.println(minCostClimbingStairs(new int[]{5, 7, 1, 2}));
        System.out.println(minCostClimbingStairs(new int[]{2, 0, 5, 1}));
        System.out.println();
        System.out.println(minCostClimbingStairs(new int[]{5, 1, 9, 15}));
        System.out.println(minCostClimbingStairs(new int[]{1, 100, 1, 1, 1}));
        System.out.println(minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
    }

    private static int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length]; int n = dp.length;
        dp[0] = cost[0]; if (n == 1) return dp[0];
        dp[1] = Math.min(cost[0], cost[1]); if (n == 2) return dp[1];
        dp[2] = Math.min(cost[1], cost[0] + cost[2]); if (n == 3) return dp[2];
        for (int i = 3; i < cost.length; i++)
            dp[i] = Math.min(dp[i-1] + cost[i], dp[i-2] + cost[i-1]);
//        System.out.println(Arrays.toString(dp));
        return dp[n-1];
    }
}