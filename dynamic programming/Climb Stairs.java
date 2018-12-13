import java.math.BigInteger;

public class Main {

    public static void main(String[] args) {
        int n = 10;
        System.out.println(climbStairsDP(n));
        System.out.println(climbStairsFact(n));
    }
    /** Straightforward DP, as this is a Fibonacci sequence */
    private static int climbStairsDP(int n) {
        if (n < 4) return n;
        int first = 1;
        int second = 2;
        int current = 3;
        for (int i = 3; i <= n; i++) {
            current = first + second;
            first = second;
            second = current;
        }
        return current;
    }

    /** Starts with all twos' that we can fit, the rest (if any) are ones.
        (twos + ones)! / (twos! * ones!) gives us the count per case.
        Sum all and get the result.
        Should be possible to memoize the factorials to avoid re-computation. */

    private static int climbStairsFact(int n) {
        if (n == 0) return 0;
        int twos = n / 2;
        int ones = (n % 2);
        int count = 0;
        while (twos >= 0) {
            count += calcFactDivision(twos, ones);
            twos--;
            ones += 2;
        }
        return count;
    }

    private static int calcFactDivision(int twos, int ones) {     // (twos + ones)! / (twos! * ones!)
        int max = Math.max(ones, twos);
        int min = Math.min(ones, twos);
        BigInteger prod = BigInteger.ONE;
        for (int i = max + 1; i <= (ones + twos); i++)
            prod = prod.multiply(BigInteger.valueOf(i));
        for (int i = 2; i <= min; i++)
            prod = prod.divide(BigInteger.valueOf(i));
        return prod.intValue();
    }
}