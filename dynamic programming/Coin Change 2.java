import java.util.Arrays;
public class Main {

    public static void main(String[] args) {
//        int[] coins = new int[]{2, 3, 7}; int amount = 7;
//        int[] coins = new int[]{1, 2, 3}; int amount = 4;
//        int[] coins = new int[]{}; int amount = 0;
        int[] coins = new int[]{1, 2, 3}; int amount = 6;
        System.out.println(change(amount, coins));
    }

    /** Simpler 1D array version
     *  Each time a new coin is introduced via the outer loop,
     *  the current row shows num of solutions for all previous coins plus the current.
     *  - In the case of 2D array all solutions from previous (above) line
     *  are also solutions for the current line, so overwriting is acceptable.
     *  It also saves us from otherwise copying old solutions to the new row. */

    private static int change(int amount, int[] coins) {
        int[] rows = new int[amount+1]; rows[0] = 1;
        for (int i = 1; i <= coins.length; i++) {
            for (int j = coins[i-1]; j <= amount; j++) {
                rows[j] += rows[j-coins[i-1]];
            }
            System.out.println(Arrays.toString(rows));
        }
        return rows[amount];
    }
}
