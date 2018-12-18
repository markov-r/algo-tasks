public class Main {

    public static void main(String[] args) {
        int[][] obstacleGrid = new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };
//        int[][] obstacleGrid = new int[][]{
//                {0, 1, 0},
//                {1, 0, 0},
//                {0, 0, 0}
//        };
//        int[][] obstacleGrid = new int[][]{
//                {0},
//        };
        System.out.println(uniquePathsWithObstacles(obstacleGrid));
    }

    private static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length; int n = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1) return 0;      //if start has an obstacle - cant reach end
        int[][] dp = new int[m][n];
        int curr = 1;                   
        for (int i = 0; i < m; i++) {               //fill with 1's till obstacle is met then fill 0's
            if (obstacleGrid[i][0] == 1) curr = 0;
            dp[i][0] = curr;
        }
        curr = 1;
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i] == 1) curr = 0;
            dp[0][i] = curr;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
                if (obstacleGrid[i][j] == 1) dp[i][j] = 0;      //if obstacle is met replace with 0(unreachable)
            }
        }
        return dp[m-1][n-1];
    }
}
