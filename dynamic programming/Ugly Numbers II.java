class Main {
    public static void main(String[] args) {
        System.out.println(nthUglyNumber(0));
    }

    /* Find each consecutive ugly num one by one.
    Keep track for each divisor (2, 3, 5) and always choose the smallest one.
    Every divisor's sub-sequence is the ugly sequence itself multiplied by the divisor.
    As the ugly sequence grows faster than the divisors' pointers
    we won't have the case we need to use something that has not yet been generated. */

    private static int nthUglyNumber(int n) {
        int ugly[] = new int[n + 1];
        ugly[1] = 1;
        int cnt2 = 1, cnt3 = 1, cnt5 = 1;           // current ugly num per divisor
        int cntInd2 = 1, cntInd3 = 1, cntInd5 = 1;  // pointers showing ugly num index per divisor
        for (int i = 2; i <= n; i++) {
            int nextUgly = Math.min(cnt2 * 2, Math.min(cnt3 * 3, cnt5 * 5));
            ugly[i] = nextUgly;
            if (cnt2 * 2 == nextUgly) {             // if nextUgly equals divisor(2) multiplied by divisor's counter (cnt2)
                cntInd2++;                          // step up pointer and counter now points to next ugly num
                cnt2 = ugly[cntInd2];               // use if() instead of switch() cause sometimes two (or three) counters need to be stepped up
            }
            if (cnt3 * 3 == nextUgly) {
                cntInd3++;
                cnt3 = ugly[cntInd3];
            }
            if (cnt5 * 5 == nextUgly) {
                cntInd5++;
                cnt5 = ugly[cntInd5];
            }
        }
        return ugly[n];
    }
}