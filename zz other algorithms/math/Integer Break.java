public class Main {


    public static void main(String[] args) {
        System.out.println(integerBreak(2));
        System.out.println(integerBreak(3));
        System.out.println(integerBreak(4));
        System.out.println(integerBreak(5));
        System.out.println(integerBreak(6));
        System.out.println(integerBreak(13));
        System.out.println(integerBreak(58)); //59+ overflows
    }

    /** We keep breaking n into 3's until n gets smaller than 10, then solve the problem by brute-force.*/
    
    private static int integerBreak(int n) {
        if (n < 4) return n - 1;
        int threes = n / 3;
        int remainder = n % 3;
        if (remainder == 1) {
            threes--;
            remainder += 3;
        }
        int result = 1;
        for (int i = 0; i < threes; i++) 
            result *= 3;
        if (remainder > 0)
        result *= remainder;
        return result;
    }
}
