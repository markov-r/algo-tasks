public class Main {

    public static void main(String[] args) {
        System.out.println(isPowerOfTwoBit(-1));
        System.out.println(isPowerOfTwoBit(0));
        System.out.println(isPowerOfTwoBit(2));
        System.out.println(isPowerOfTwoBit(12));
        System.out.println(isPowerOfTwoBit(42));
        System.out.println(isPowerOfTwoBit(77));
        System.out.println(isPowerOfTwoBit(4096));
        System.out.println(isPowerOfTwoBit(Integer.MAX_VALUE));
        System.out.println(isPowerOfTwoBit(Integer.MIN_VALUE));
    }

    /** Use the binary representation and check
     *  if the bits after the first are all zeroes
     *  The first (leftmost) bit is 1, as n > 0. */

    private static boolean isPowerOfTwoBinStr(int n) {
        if (n <= 0) return false;
        String num = Integer.toBinaryString(n);
        int i = 1;
        while (i < num.length() && num.charAt(i) == '0' ) {
            i++;
        }
        return i == num.length();
    }

    /** Binary search between the powers of two (min 0, max n)
     * If 2 ^ mid > n -> go left, if < n -> go right.
     * Gets TLE in LeetCode.*/

    private static boolean isPowerOfTwoBinSearch(int n) {
        int left = 0;
        int right = n;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (1 << mid == n) return true;
            else if (1 << mid > n) right = mid - 1;
            else left = mid + 1; // if (1 << mid < n)
        }
        return false;
    }

    /** If n is a power of 2 (1000..) n-1 is (111..)
     * So ->   10000
     *       & 01111
     *         00000 - will always equal zero.
     *  In every other case n * (n-1) will be != 0
     *  as the consecutive numbers will have at least 1
     *  in the same bit => n * (n-1) will be != 0*/

    private static boolean isPowerOfTwoBit(int n) {
//        System.out.println(Integer.toBinaryString(n));
        if (n <= 0) return false;
        return (n & (n - 1)) == 0;
    }
}