import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(countBits(10)));
//        System.out.println(Arrays.toString(countBits(547)));
        System.out.println(Arrays.toString(countBits(20000000)));
//        System.out.println(Arrays.toString(countBits(200000000)));
//        System.out.println(Arrays.toString(countBits(2000000000)));
    }

    /** When reaching a power of 2 (1 in result array) and
     * all digits up to here are n, the next x digits are old n ones, adding +1 to each
     * e.g. up till now ->  0 1 1 2
     * next 4 digits are -> 1 2 2 3. */

    private static int[] countBits(int num) {
        int dp[] = new int[num+1];
        dp[0] = 0;
        for (int i = 0; i < 31; i++) {     //to fit all integer
            int start = 1 << i;
            int end = (1 << (i + 1)) - 1;
            for (int j = 1 << i; j <= Math.min(end, num); j++) {
                dp[j] = dp[j-start] + 1;
            }
        }
        return dp;
    }
}
