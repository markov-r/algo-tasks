import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
//        int[][] dungeon = {{-2,  -3,  3},
//                           {-5, -10,  1},
//                           {10,  30, -5}};

//        int[][] dungeon = {{-2, -3,  3,  5},
//                           {-3, -5,  1, -3},
//                            {1,  4, -5, -1}};

//        int[][] dungeon = {{ 3, -20,  30},
//                           {-3,   4,   0}};

//        int[][] dungeon = {{ 1, -3,  3},
//                           { 0, -2,  0},
//                           {-3, -3, -3}};         //SHOULD RETURN 3

//          int[][] dungeon = {{1, -3,  2},
//                             {0, -1,  2},
//                             {0,  0, -2}};

//        int[][] dungeon = {{}};

          int[][] dungeon = {{ 1, -4, -3},
                             {-2,  0,  2},
                             { 1, -3,  3}};
        System.out.println(calculateMinimumHP(dungeon));
    }

    /** Starting from bottom right corner start calculating the minimum
     *  hit points required to survive from current cell to bottom right. */

    private static int calculateMinimumHP(int[][] maze) {
        if (maze.length == 0 || maze[0].length == 0) return 0;
        int m  = maze.length;
        int n = maze[0].length;
        int[][] dp = new int[m][n];
        dp[m-1][n-1] = Math.max(1, 1 - maze[m-1][n-1]); // hit points -> 1 if cell is positive, if negative -> 1 + abs(maze[][])
        for (int i = m - 2; i >= 0; i--) {      //rightmost column
            dp[i][n-1] = Math.max(1, dp[i+1][n-1] - maze[i][n-1]);
        }
        for (int i = n - 2; i >= 0; i--) {      //lowest row
            dp[m-1][i] = Math.max(1, dp[m-1][i+1] - maze[m-1][i]);
        }

        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                int chosen = Math.min(dp[i][j+1], dp[i+1][j]);
                dp[i][j] = Math.max(1, chosen - maze[i][j]);
            }
        }
        System.out.println(Arrays.deepToString(dp).replace("], ", "]\n").replace("[[", "[").replace("]]", "]"));
        return dp[0][0];
    }
}