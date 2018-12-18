public class Main {

    public static void main(String[] args) {
//        System.out.println(uniquePaths(0, 0));
        System.out.println(uniquePaths(0, 1));
        System.out.println(uniquePaths(5, 0));
        System.out.println(uniquePaths(1, 2));
        System.out.println(uniquePaths(5, 1));
        System.out.println(uniquePaths(15, 12));
    }

    private static int uniquePaths(int m, int n) {
//        if (n == 0 || m == 0) return 0;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}
