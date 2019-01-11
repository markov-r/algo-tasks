public class Main {

    public static void main(String[] args) {
//        String input = "jfdfdssf";
//        String input = " 1  9  1";
//        String input = " 333";
        String input = "";
        System.out.println(longestPalindrome(input));
    }

    /** A new string is a palindrome if the new letter equals the first
     *  and the middle part (already calculated) is also a palindrome.
     *  Calculation is done diagonally, starting with main diagonal.
     *  First calculate the max palindrome count,
     *  then using the count traverse dp[][] to find
     *  a palindrome string with such length. */

    private static String longestPalindrome(String input) {
        int n = input.length();
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n - 1; i++) {
            dp[i+1][i] = true;              //"" is palindrome
        }
        for (int i = 0; i < dp.length; i++) {
            dp[i][i] = true;
        }
        int i, j, count = 1;               //find the max palindrome count
        for (int k = 1; k < n; k++) { //k -> distance from main diagonal
            for (i = 0; i < n - k; i++) {
                j = i + k;
                dp[i][j] = (input.charAt(i) == input.charAt(j) && dp[i+1][j-1]);
                if (dp[i][j])
                    count = k + 1;
            }
        }

        for (int p = n - count; p >= 0; p--) { //reconstruct a possible palindrome from count
            int q = p + count - 1;
            if (dp[p][q]) return input.substring(p, q+1);
        }
        return ""; //for input ""
    }
}
