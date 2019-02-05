public class Main {

    public static void main(String[] args) {
//        int x = 1, y = 4;
//        int x = 112512, y = 561234;
        int x = 511, y = 512;
        System.out.println(Integer.toBinaryString(x));
        System.out.println(Integer.toBinaryString(y));
        System.out.println(hammingDistance(x, y));
    }

    /** Do x ^ y (XOR), which returns 1 only when
     * the compared bits are different
     * Then count the number of ones in x ^ y */

    private static int hammingDistance(int x, int y) {
        int ones = x ^ y;
        int count = 0;
        while (ones != 0) {
            ones &= ones - 1;
            count++;
        }
        return count;
    }
}
