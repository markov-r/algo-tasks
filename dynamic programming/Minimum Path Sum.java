import java.util.Arrays;
public class Main {

    public static void main(String[] args) {
//        int[][] grid = new int[][]{
//                {4}};
//        int[][] grid = new int[][]{
//                {1, 2, 3}};
//        int[][] grid = new int[][]{
//                {1},
//                {2},
//                {3}};
//        int[][] grid = new int[][]{
//                {0, 0, 0},
//                {0, 0, 0}};
//        int[][] grid = new int[][]{
//                {1, 2, 3},
//                {4, 5, 6}};
        int[][] grid = new int[][]{
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}};
        System.out.println(minPathSum(grid));
    }

    private static int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];      //can be optimized to use only 1D arr, not a full 2D arr
        dp[0][0] = grid[0][0];                                  //or can modify the original arr (grid)
        for (int i = 1; i < grid[0].length; i++) {    //fill 1st row
            dp[0][i] = dp[0][i-1] + grid[0][i];
        }
        for (int i = 1; i < grid.length; i++) {    //fill 1st col
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];   //choose smaller of two options then add current
            }
        }
//        System.out.println(Arrays.deepToString(dp).replace("], ", "]\n"));
        return dp[grid.length-1][grid[0].length-1];
    }
}