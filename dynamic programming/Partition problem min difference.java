import java.io.*;
import java.util.*;

public class Main {

    /**2D array version.
     * Variation of the Partition problem
     * (find if you can split an array to groups with equal sums)
     * In standard Partition problem we use the solution of Subset Sum problem
     * We do the same here; we traverse backwards the last row of the dp matrix
     * and find the needed difference.
     * By traversing last row of dp matrix we make sure that we find the biggest
     * possible sum less than or equal to total sum/2 .
     */

//   public static void main(String[] args) throws IOException {
//       BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//       int n = Integer.parseInt(in.readLine());
//       int[] arr = new int[n];
//       String[] input = in.readLine().split(" ");
//       for (int i = 0; i < n; i++) {
//           arr[i] = Integer.parseInt(input[i]);
//       }
//
//
//       int sum = Arrays.stream(arr).reduce(Integer::sum).getAsInt();
//       boolean[][] dp = new boolean[arr.length + 1][sum / 2 + 1];
//       dp[0][0] = true;
//
//       for (int i = 1; i <= arr.length; i++) {
//           for (int j = 0; j <= sum / 2; j++) {
//               if (dp[i-1][j])
//                   dp[i][j] = true;
//               if (dp[i-1][j] &&
//                       (j + arr[i-1] <= sum / 2))
//                   dp[i][j + arr[i-1]] = true;
//           }
//       }
//       int max = -1;
//       for (int i = sum / 2; i >= 0; i--) {
//           if (dp[arr.length][i]) {
//               max = i;
//               break;
//           }
//       }
//       System.out.println(sum - 2 * max);
//   }


    /** 1D array version.
     *  Overwrite the existing array while traversing backwards.
     *  Traversing backwards ensures that we write only to positions
     *  that we have already checked so no mismatch occurs
     *  (the newly-written value will not be re-used in the same loop iteration).
     */

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        int[] arr = new int[n];
        String[] input = in.readLine().split(" ");
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(input[i]);
        int sum = Arrays.stream(arr).reduce(Integer::sum).getAsInt();

//        boolean[][] dp2d = new boolean[arr.length + 1][sum / 2 + 1];
        boolean[] dp = new boolean[sum / 2 + 1];
//        dp2d[0][0] = true;
        dp[0] = true;

        for (int i = 1; i <= arr.length; i++) {
            for (int j = sum / 2; j >= 0; j--) {     //traverse backwards to avoid overwriting next values
//                if (dp2d[i-1][j])
//                    dp2d[i][j] = true;

//                if (dp2d[i-1][j] &&
//                        (j + arr[i-1] <= sum / 2))
//                    dp2d[i][j + arr[i-1]] = true;
                if (dp[j] &&
                        (j + arr[i-1] <= sum / 2))
                    dp[j + arr[i-1]] = true;
            }
        }
//        System.out.println(Arrays.deepToString(dp2d));
        int max = -1;
        for (int i = sum / 2; i >= 0; i--) {
//            if (dp2d[arr.length][i]) {
            if (dp[i]) {
                max = i;
                break;
            }
        }
        System.out.println(sum - 2 * max);
    }
}