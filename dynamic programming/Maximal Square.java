import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        char[][] grid = new char[][]{
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'},
        };

//        char[][] grid = new char[][]{
//                {'1', '1', '1', '1', '1'},
//                {'1', '1', '1', '1', '1'},
//                {'1', '1', '1', '1', '1'},
//                {'1', '1', '1', '1', '1'},
//                {'1', '1', '1', '1', '1'},
//        };

//        char[][] grid = new char[][]{
//                {'0', '0', '0', '0', '0'},
//        };

//        char[][] grid = new char[][]{
//                {},
//        };

//        char[][] grid = new char[][]{
//                {'1'},
//        };
        System.out.println(maximalSquare(grid));
    }



    /** 2D DP version
     *  Each DP cell represents the number of cells of the biggest square
     *  ending with its bottom right corner in the cur. cell.
     *  Therefore first row and first column are just the grid values
     *  (as max square for each is at most 1).
     *  If cur. cell is 1 and left, up, and left-up are all > 0,
     *  then the cur. cell should also be calculated -
     *  find min from all neighbours and cur. cell is (min + 1).
     *  Can be optimized to use only 1 or 2 1D arrays. */

    private static int maximalSquareOld(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;
        int[][] dp = new int[grid.length][grid[0].length];
        int max = 0;                                //the square side's length
        for (int i = 0; i < grid.length; i++) {     //first row - values same as in grid
            dp[i][0] = grid[i][0] - '0';
            max = Math.max(max, dp[i][0]);
        }
        for (int i = 0; i < grid[0].length; i++) {
            dp[0][i] = grid[0][i] - '0';            //first column - values same as in grid
            max = Math.max(max, dp[0][i]);
        }
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                if (grid[i][j] == '1' &&            //if the 2x2 square with cur. cell as bottom right corner
                        dp[i-1][j] > 0 &&           //has all other members > 0 => cur. cell is > 1 and we need to calculate it
                        dp[i][j-1] > 0 &&
                        dp[i-1][j-1] > 0) {
                    int min = Math.min(dp[i][j-1], Math.min(dp[i-1][j], dp[i-1][j-1]));
                    dp[i][j] = min + 1;
                }
                else {
                    dp[i][j] = grid[i][j] - '0';
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        System.out.println(Arrays.deepToString(dp).replace("], ", "]\n")
                .replace("[[", "[")
                .replace("]]", "]"));

        return max * max; //total num of cells
    }

    /** Optimized/shortened version of the above, still using 2D array */
    
    private static int maximalSquare(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;
        int[][] dp = new int[grid.length+1][grid[0].length+1];
        int max = 0;
        for (int i = 1; i <= grid.length; i++) {
            for (int j = 1; j <= grid[0].length; j++) {
                if (grid[i-1][j-1] == '1') {
                    dp[i][j] = Math.min(dp[i][j-1], Math.min(dp[i-1][j], dp[i-1][j-1])) + 1;
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        System.out.println(Arrays.deepToString(dp).replace("], ", "]\n")
                .replace("[[", "[")
                .replace("]]", "]"));

        return max * max;
    }
}