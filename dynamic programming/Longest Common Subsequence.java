import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
//        System.out.println(new Solution().longestCommonSubsequence("abcde", "eca"));
//        System.out.println(new Solution().longestCommonSubsequence("aabaa", "bab"));
//        System.out.println(new Solution().longestCommonSubsequence("abcee", "eea"));
//        System.out.println(new Solution().longestCommonSubsequence("aaaaa", "aab"));
//        System.out.println(new Solution().longestCommonSubsequence("bbb", "bbb"));
//        System.out.println(new Solution().longestCommonSubsequence("aba", "bab"));
//        System.out.println(new Solution().longestCommonSubsequence("a", "b"));
//        System.out.println(new Solution().longestCommonSubsequence("abc", "fgh"));
//        System.out.println(new Solution().longestCommonSubsequence("abcde", "edcba"));
//        System.out.println(new Solution().longestCommonSubsequence("aabbb", "bbaaa"));
//        System.out.println(new Solution().longestCommonSubsequence("ab", "ba"));
        System.out.println(new Solution().longestCommonSubsequence("aab", "bba"));
//        System.out.println(new Solution().longestCommonSubsequence("abcde", "ace"));
    }

    /** A classical DP problem
     *  Each subproblem's solution is either:
     *  - if chars match  - upper left's value ([i-1][j-1]) + 1
     *  - if chars don't match - bigger of (left and up) */

    public int longestCommonSubsequence(String str1, String str2) {
        int s1 = str1.length(), s2 = str2.length();
        if (s1 == 0 || s2 == 0) return 0;
        int[][] dp = new int[s2][s1];
        dp[0][0] = str1.charAt(0) == str2.charAt(0) ? 1 : 0;
        for (int i = 1; i < s1; i++) {
            dp[0][i] = str1.charAt(i) == str2.charAt(0)
                    ? 1
                    : dp[0][i-1];
        }
        for (int i = 1; i < s2; i++) {
            dp[i][0] = str1.charAt(0) == str2.charAt(i)
                    ? 1
                    : dp[i-1][0];
        }

        for (int i = 1; i < s2; i++) {
            for (int j = 1; j < s1; j++) {
                int prev = Math.max(dp[i][j-1], dp[i-1][j]);
                dp[i][j] = str1.charAt(j) == str2.charAt(i)
                        ? Math.max(dp[i-1][j-1] + 1, prev) // or just dp[i-1][j-1] + 1 
                        : prev;
            }
        }
        System.out.println(Arrays.deepToString(dp).replace("], ", "]\n")
                .replace("[[", "[")
                .replace("]]", "]"));
        return dp[s2-1][s1-1];
    }

}