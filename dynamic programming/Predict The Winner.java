import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] nums = new int[]{8, 1, 3, 2, 5};
        System.out.println(predictTheWinner(nums));
    }

    /** 1) dp[i][j] -> the difference of total gains of first minus second.
     *     i -> start position, j -> end position,
     *     e.g. dp[0][2] -> difference of gains for {8, 1, 3} = 6
     *  2) Fill the main diagonal when i == j so that it equals nums[i]
     *  3) Start filling the "smaller" diagonals right of the main
     *     Each field depends on nums[i]/nums[j] and its left or down neighbour,
     *     which we have already calculated.
     *     dp[0][n-1] (lastly calculated) gives the answer.*/

    private static boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) dp[i][i] = nums[i];
        int i, j;
        for (int k = 1; k < n; k++) {                       //k -> distance from main diagonal
            for (i = 0, j = i + k; i < n - k; i++, j++) {
                dp[i][j] = Math.max(nums[i] - dp[i+1][j],   //nums[from] - down
                        nums[j] - dp[i][j-1]);              //nums[to] - left
            }
        }
//        System.out.println(Arrays.deepToString(dp).replace("], ", "]\n").replace("[[", "[").replace("]]", "]"));
        return dp[0][n-1] >= 0;
    }

}
