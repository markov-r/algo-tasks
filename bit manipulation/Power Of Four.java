public class Main {

    public static void main(String[] args) {
//        System.out.println(isPowerOfFour(-1));
//        System.out.println(isPowerOfFour(0));
//        System.out.println(isPowerOfFour(1));
//        System.out.println(isPowerOfFour(2));
//        System.out.println(isPowerOfFour(3));
//        System.out.println(isPowerOfFour(4));
//        System.out.println(isPowerOfFour(64));
//        System.out.println(isPowerOfFour(512));
//        System.out.println(isPowerOfFour(Integer.MAX_VALUE));
        System.out.println(isPowerOfFour(Integer.MIN_VALUE));
    }

    /** num & (num - 1) == 0 makes sure that it's a power of two.
     *  num & 0b01010101010101010101010101010101 != 0 
     *  makes sure the 1 is in the proper place 
     *  (so that the number of zeroes after the 1 is even) */
    
    private static boolean isPowerOfFour(int num) {
        return num > 0 && (num & (num - 1)) == 0 && (num & 0b01010101010101010101010101010101) != 0;
    }
}
