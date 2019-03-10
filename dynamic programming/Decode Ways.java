import java.util.*;

public class Main {

    public static void main(String[] args) {
        System.out.println(numDecodingsMemo("231247"));
        System.out.println(numDecodingsMemo("102121712"));
        System.out.println(numDecodingsMemo("6065812287883668764831544958683283296479682877898293612168136334983851946827579555449329483852397155"));
        System.out.println(numDecodingsMemo("0"));
        System.out.println(numDecodingsMemo("00"));
        System.out.println(numDecodingsMemo("100"));
        System.out.println(numDecodingsMemo("110"));
        System.out.println(numDecodingsMemo("230"));
        System.out.println(numDecodingsMemo("201"));
        System.out.println(numDecodingsMemo("2012"));
        System.out.println(numDecodingsMemo("1201"));
    }

    /** Standard DP solution
     * Traverse all substrings of len 2 and len 1
     * and add previous values if the answer is non-zero (len 1)
     * or fits in 10-26 interval (len 2).
     */

    private static int numDecodingsDP(String s) {
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 2; i <= s.length(); i++) {
            int cur = Integer.parseInt(s.charAt(i-1) + "");
            int prev = Integer.parseInt(s.charAt(i-2) + "" + s.charAt(i-1));
            if (cur != 0)
                dp[i] += dp[i-1];
            if (prev >= 10 && prev <= 26)
                dp[i] += dp[i-2];
        }
        return dp[s.length()];
    }

    private static int[] fibo = new int[46]; // int overflows after 46

    static {
        fibo[0] = 1;
        fibo[1] = 1;
        for (int i = 2; i < fibo.length; i++)
            fibo[i] = fibo[i-1] + fibo[i-2];
    }

    /** If number is only 1s and 2s, then it's a clear Fibonacci sequence
     *  If the number includes other digits, those split the number into
     *  smaller Fibonacci batches and the result will be the product
     *  of the smaller Fibonacci batches.
     *  There are some corner cases to cover, involving 0.
     *  Could have written this in a cleaner way.*/

    private static int numDecodingsFibonacci(String s) {
        System.out.print(s + " -> ");
        if (s.charAt(0) == '0') return 0;
        int prod = 1;
        int cur = 1;
        for (int i = 1; i < s.length(); i++) {
            int next = Integer.parseInt(s.charAt(i-1) + "" + s.charAt(i));
            if (next == 0) return 0;                                        //"00"
            if (s.charAt(i) == '0' && s.charAt(i-1) > '2')                  //"30", "40"
                return 0;
            if (s.charAt(i) == '0' && cur > 1)                              //"10" -> only 1 way to decode
                cur--;
            if (10 <= next && next <= 26 && s.charAt(i) != '0')
                cur++;
            else {
                prod *= fibo[cur];
                cur = 1;
            }
        }
        if (cur > 1)                //multiply the ending fibonacci sequence, e.g. "...25"
            prod *= fibo[cur];
        return prod;
    }

    /** Memoization solution - same idea as in the standard DP solution,
     *  but just written in a recursive manner. */

    private static int numDecodingsMemo(String s) {
        if (s == null || s.length() == 0)
            return 0;
        Set<String> symbols = new HashSet<>();
        for (int i = 1; i <= 26; i++)
            symbols.add(String.valueOf(i));
        Map<Integer, Integer> memo = new HashMap<>();
        return numDec(s, 0,  memo, symbols);
    }

    private static int numDec(String str, int idx,  Map<Integer, Integer> memo, Set<String> symbols) {
        if (memo.containsKey(idx))
            return memo.get(idx);
        if (idx == str.length())
            return 1;
        int result = 0;
        if (idx + 2 <= str.length() &&  symbols.contains(str.substring(idx, idx + 2)))
            result += numDec(str, idx + 2, memo, symbols);
        if (idx + 1 <= str.length() && symbols.contains(str.substring(idx, idx + 1)))
            result += numDec(str, idx + 1, memo, symbols);
        memo.put(idx, result);
        return result;
    }
}
