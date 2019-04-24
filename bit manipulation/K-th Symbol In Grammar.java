import com.google.common.math.LongMath;
import java.math.RoundingMode;

class Solution {

    public Solution() {
    }

    public static void main(String[] args) {
        System.out.println(new Solution().kthGrammar(1, 1));
        System.out.println(new Solution().kthGrammar(2, 1));
        System.out.println(new Solution().kthGrammar(2, 2));
        System.out.println(new Solution().kthGrammar(4,5));
        System.out.println(new Solution().kthGrammar(30,434991989));
        System.out.println(new Solution().kthGrammar(3, 4));
    }

    /** Each new row has two halves - first copy of the previous row,
     *  and the second part is the previous row inverted (1001 -> 0110).
     *  So on each recursion call we do something similar to a binary search:
     *  we subtract the length of the previous row (2^(pow-1)) and invert the bit.
     *
     *  n (row number) is not needed, instead we calculate the smallest power of 2,
     *  bigger than or equal to k.
     *  flag == false means invert bits (0->1, 1->0) */

    public int kthGrammar(int n, int k) {
        if (k < 3) return k - 1;
        return helper(k, true);
    }

    private int helper(int k, boolean flag) {
//        if (k == 1) return flag ? 0 : 1;
//        if (k == 2) return flag ? 1 : 0;
        if (k < 3) return flag ? k - 1 : k % 2;
        int pow = smallestPowOf2BiggerThanNum(k);
        return helper(k - (1 << (pow - 1)), !flag);
    }

    public int smallestPowOf2BiggerThanNum(int k) {
        int count = 0; int i = k;
        while (i != 0) {
            i = i >> 1;
            count++;     //count the place of the leftmost 1
        }
        return (k & (k-1)) == 0 ? count-1 : count;  //return 1 less for a power of two
    }

    /** DP solution based on the same idea as above
     *  Failing when StringBuilder becomes too big (over 400 mln chars) */

    public int kthGrammarDP(int n, int k) {
        StringBuilder dp = new StringBuilder("01");
        int pos = LongMath.log2((long) k, RoundingMode.CEILING); //smallest power of 2 bigger or equal to k
        for (int i = 3; i <= pos; i++) {
            int len = dp.length();
            for (int j = 0; j < len; j++) {
                if (dp.charAt(j) == '0') {
                    dp.append("1");
                } else {
                    dp.append("0");
                }
            }
        }
        return dp.charAt(k - 1) == '0' ? 0 : 1;
    }

}