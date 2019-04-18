public class Solution {

    public Solution() {
    }

    public static void main(String[] args) {
//        System.out.println(new Solution().strangePrinter("babcba"));
//        System.out.println(new Solution().strangePrinter("abbaabba"));
//        System.out.println(new Solution().strangePrinter("ababa"));
//        System.out.println(new Solution().strangePrinter(""));
//        System.out.println(new Solution().strangePrinter("axabyb"));
//        System.out.println(new Solution().strangePrinter("ababaa"));
//        System.out.println(new Solution().strangePrinter("abcabcabc"));
//        System.out.println(new Solution().strangePrinter("ccdcadbddbaddcbccdcdabcbcddbccdcbad"));
        System.out.println(new Solution().strangePrinter("abata"));
//        System.out.println(new Solution().strangePrinter("baacdddaaddaaaaccbddbcabdaabdbbcdcbbbacbddcabcaaa"));
//        System.out.println(new Solution().strangePrinter("bacdadacbdbcabdabdbcdcbacbdcabca"));
//
    }

    /** We calculate all smaller substrings in a matrix -> dp[i][j]
     *  diagonally step by step, starting from the main diagonal (dp[i][i] equals 1).
     *  Then, e.g. for string "abata" we need to calculate the cost of "a" + cost of "bata",
     *  then "ab" + "ata" etc. and find the minimum of all splits.
     *  When last char of each of the two substrings is the same,
     *  then we need to lower the cost by 1, as they can be done in one print.
     *  Instead of last chars we can use e.g. first chars of each substring etc.,
     *  as it will give the same result. */

    public int strangePrinter(String str) {
        if (str.length() == 0) return 0;
        StringBuilder sb = new StringBuilder(str); //clear duplicate consecutive letters,
        int iter = 1;                              // "aaabb" needs the same amount of prints as "ab"
        while (iter < sb.length()) {
            if (sb.charAt(iter) == sb.charAt(iter - 1))
                sb.deleteCharAt(iter);
            else
                iter++;
        }
        str = sb.toString();

        int n = str.length();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        int i, j;
        for (int k = 1; k < n; k++) { //k -> distance from main diagonal
            for (i = 0; i < n - k; i++) {
                j = i + k;
                for (int m = i; m < j; m++) {
                    if (str.charAt(m) == str.charAt(j))
//                    if (str.charAt(i) == str.charAt(m+1))     -> another option (compare first chars of substrings)
                        dp[i][j] = Math.min(dp[i][j], dp[i][m] + dp[m+1][j] - 1);
                    else
                        dp[i][j] = Math.min(dp[i][j], dp[i][m] + dp[m+1][j]);
                }
            }
        }
        return dp[0][n - 1];
    }

}