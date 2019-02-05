public class Main {

    public static void main(String[] args) {
        int x = 511;
        System.out.println(isPowerOfThree(x));
    }

    /** The biggest power of 3 that fits in an integer is 1162261467.
     *  It's only divisors are all powers of 3 smaller than it.
     *  Also negative ints can't be a power of 3. */
    
    private static boolean isPowerOfThree(int n) {
        return n > 0 && 1162261467 % n == 0;
    }


}
