public class Main {

    public static void main(String[] args) {
//        int n = 0;
//        int n = 1;
//        int n = 9;
//        int n = 130;
        int n = 120;
//        int n = 100;
//        int n = 110;
//        int n = 212;
//        int n = 220;
//        int n = 11220;
//        int n = 127768;
//        int n = 1230;
//        int n = 1001;
//        int n = 12121;
//        int n = 11111;
//        int n = 98765;
//        int n = 11111220;
//        int n = 121211212;
        System.out.println(monotoneIncreasingDigits(n));
    }

    /** Three possible cases depending upon the input:
     1) All consecutive pairs of digits are not decreasing (e.g. 123, 122, 111) => input is good already => return n
     2) There is an decreasing pair of consec. elements, note the first decreasing index (decIdx)
        2.1) there is no increasing consec. pair before the decreasing pair (e.g. 210, 220, 212)
        Decrease first digit by 1 and fill rest with 9's.
        2.2) there is an increasing pair before the decreasing pair (e.g. 120, 1230)
        Find the last increasing pair before decIdx -> incIdx
        - decrease original digit at incIdx by 1 (as it is the second element of an increasing pair it is always > 1)
        - left of incIdx => copy all from original
        - right of incIdx => fill 9's */

    private static int monotoneIncreasingDigits(int n) {
        if (n < 10) return n;
        int[] digits = numToArray(n);
        int len = digits.length;
        int[] monotone = new int[len];
        int decIdx = -1;                // first consecutive decreasing pair of elements
        int incIdx = -1;                // last consecutive increasing pair before decIdx
        for (int i = 1; i < len; i++) {
            if (digits[i] < digits[i-1]) {
                decIdx = i;
                for (int j = 1; j < decIdx; j++) {
                    if (digits[j] > digits[j-1]) {
                        incIdx = j;
                    }
                }
                break;
            }
        }
        if (decIdx == -1) return n;         // 1)   -> 123, 122, 111
        if (incIdx == -1) {                 // 2.1) -> 210, 220, 212
            monotone[0] = digits[0] - 1;
            for (int i = 1; i < len; i++) {
                monotone[i] = 9;
            }
        } else {                                    // 2.2) -> 120, 1230, 1120
            monotone[incIdx] = digits[incIdx] - 1;
            for (int i = 0; i <= incIdx - 1; i++) {
                monotone[i] = digits[i];
            }
            for (int i = incIdx + 1; i < len; i++) {
                monotone[i] = 9;
            }
        }
        return calcResult(monotone);
    }

    private static int[] numToArray(int n) {
        String numberStr = String.valueOf(n);
        int len = numberStr.length();
        char[] chars = numberStr.toCharArray();
        int[] digits = new int[len];
        for (int i = 0; i < len; i++) {
            digits[i] = chars[i] - '0';
        }
        return digits;
    }

    private static int calcResult(int[] monotone) {
        int result = 0, len = monotone.length;
        for (int i = 0; i < len; i++) {
            result += monotone[i] * Math.pow(10, len - 1 - i);
        }
        return result;
    }
}
