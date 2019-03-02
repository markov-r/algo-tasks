public class Main {

    public static void main(String[] args) {
//        String str = "kucomagaremalele";
//        String str = "ananasa senakisna";
//        String str = "aaaaaaaaaa";
//        String str = "underqualified";
//        String str = "turboventilator";
//        String str = "kachamak";
//        String str = "alabama";
//        String str = "bbbab";
//        String str = "cbbd";
//        String str = "abacba";
        String str = "";
        System.out.println(longestPalindromeSubseq(str));
    }

    private static int[][] memo;

    private static int longestPalindromeSubseq(String str) {
        if (str.length()  == 0) return 0;
        memo = new int[str.length()][str.length()];
        return palindrRec(str, 0, str.length() - 1);
//        return palindrDP(str);
    }

    /** If first and last chars of substring match - result is 2 plus the middle part.
     *  If chars don't match, result is the longer (max) of:
     *  - cutting out the first char
     *  - cutting out the last char */
    private static int palindrRec(String str, int from, int to) {
        if (memo[from][to] > 0)
            return memo[from][to];
        if (from == to)
            return 1;
        if (to - from == 1)     //from and to -> consecutive
            return memo[from][to] = (str.charAt(from) == str.charAt(to)) ? 2 : 1;
        if (str.charAt(from) == str.charAt(to))
            return memo[from][to] = 2 + palindrRec(str, from + 1, to - 1);
        else
            return Math.max(memo[from+1][to] = palindrRec(str, from + 1, to),
                    memo[from][to-1] = palindrRec(str, from, to - 1));
    }
    
    /** Same approach as above, but made with standard DP with tabulation */
    
    private static int palindrDP(String str) {
        int n = str.length();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++)
            dp[i][i] = 1;              //each 1 char str is a palindrome
        int i, j;
        for (int k = 1; k < n; k++) { //k -> distance from main diagonal
            for (i = 0; i < n - k; i++) {
                j = i + k;
                if (str.charAt(i) == str.charAt(j))
                    dp[i][j] = 2 + dp[i+1][j-1];
                else dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
            }
        }
        return dp[0][n-1];
    }
    
}