class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().minFallingPathSum(new int[][] {{1,2,3},{4,5,6},{7,8,9}}));
        System.out.println(new Solution().minFallingPathSum(new int[][] {}));
        System.out.println(new Solution().minFallingPathSum(new int[][] {{}}));
    }

    /** Make a dp array that accumulates the best (minimum) possible solution for the given cell.
     *  Each cell will depend on the minimum of its three above cells (not all may be present).
     *  So the minimum of the last dp row will give the answer.
     */

    public int minFallingPathSum(int[][] arr) {
//        if (arr.length == 0 || arr[0].length == 0) return 0;     // not needed as per problem description
        int n = arr.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[0][i] = arr[0][i];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    dp[i][j] = arr[i][j] + Math.min(dp[i-1][j], dp[i-1][j+1]);
                } else if (j == n - 1) {
                    dp[i][j] = arr[i][j] + Math.min(dp[i-1][j], dp[i-1][j-1]);
                } else dp[i][j] = arr[i][j] + Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i-1][j+1]));
            }
        }
        int result = dp[n-1][0];
        for (int i = 1; i < n; i++) {
            if (dp[n-1][i] < result) {
                result = dp[n-1][i];
            }
        }
        return result;
    }
}