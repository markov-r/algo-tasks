public class Main {

    public static void main(String[] args) {
//        System.out.println(hammingWeight(0));    //0
//        System.out.println(hammingWeight(1));    //1
//        System.out.println(hammingWeight(2));    //10
//        System.out.println(hammingWeight(12));   //1100
//        System.out.println(hammingWeight(13));   //1101
//        System.out.println(hammingWeight(42));   //101010
//        System.out.println(hammingWeight(0b11111111111111111111111111111101));
//        System.out.println(hammingWeight(77));   //1001101
//        System.out.println(hammingWeight(4096));
//        System.out.println(hammingWeight(Integer.MAX_VALUE));
//        System.out.println(hammingWeight(Integer.MIN_VALUE));
//

        System.out.println(hammingWeightSecond(13));

//        System.out.println(Integer.toBinaryString(13));
    }

    /** Use that n & (n-1) clears (makes it 0) the rightmost 1
        E.g. ->  1101 (13)
               & 1100 (12)
                 ----
                 1100 (12)
               & 1011 (11)
                 ----
                 1000 (8)
               &  111 (7)
                 ----
                 0000    */

    private static int hammingWeightFirst(int n) {
        System.out.println(Integer.toBinaryString(n));
        int count = 0;
        while (n != 0) {
            n &= n - 1;
            count++;
        }
        return count;
    }

    /** Check rightmost bit (if n is even -> n & 1 == 0)
     * Then remove the rightmost (least significant) bit
     * (do unsigned shift right) and proceed */

    private static int hammingWeightSecond(int n) {
        int ones = 0;
        while (n != 0){
            ones += (n & 1);
            n >>>= 1;
        }
        return ones;
    }

    /** A variation of the above check
     * Shift the mask, not the number */
    
    public int hammingWeightMask(int n) {
        int bits = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) {
                bits++;
            }
            mask <<= 1;
        }
        return bits;
    }
}