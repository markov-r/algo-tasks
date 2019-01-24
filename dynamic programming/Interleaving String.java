import javafx.util.Pair;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        System.out.println(isInterleaveDP("baabb", "baabb", "baabbaabbb"));
        System.out.println(isInterleaveDP("aabcc", "dbbca", "aadbbcbcac"));
        System.out.println(isInterleaveDP("aabcc", "dbbca", "aadbbbaccc"));
        System.out.println(isInterleaveDP("a", "b", "a"));
        System.out.println(isInterleaveDP("a", "", "a"));
        System.out.println(isInterleaveDP(
                "bbbbbabbbbabaababaaaabbababbaaabbabbaaabaaaaababbbababbbbbabbbbababbabaabababbbaabababababbbaaababaa",
                "babaaaabbababbbabbbbaabaabbaabbbbaabaaabaababaaaabaaabbaaabaaaabaabaabbbbbbbbbbbabaaabbababbabbabaab",
                "babbbabbbaaabbababbbbababaabbabaabaaabbbbabbbaaabbbaaaaabbbbaabbaaabababbaaaaaabababbababaababbababbbababbbbaaaabaabbabbaaaaabbabbaaaabbbaabaaabaababaababbaaabbbbbabbbbaabbabaabbbbabaaabbababbabbabbab"
        ));
    }

    private static Set<Pair> deadEnds;

    /** Recursion with memoization solution using HashSet of String Pairs
     *  Another, probably better option is to use 2D boolean array storing each combo of s1/s2 chars
     *  Then the recursive function becomes slightly more complicated as we also need indices as input params */

    private static boolean isInterleaveMemo(String s1, String s2, String s3) {
        deadEnds = new HashSet<>();
        if (s1.length() + s2.length() != s3.length()) return false;
        return solve(s1, s2, s3);
    }

    private static boolean solve(String s1, String s2, String s3) {
        if (deadEnds.contains(new Pair(s1, s2)))
            return false;
        if (s3.length() == 0 && s1.length() == 0 && s2.length() == 0)
            return true;
        if (s1.length() > 0 && s3.length() > 0 && s3.charAt(0) == s1.charAt(0)
                && solve(s1.substring(1), s2, s3.substring(1)))
            return true;
        if (s2.length() > 0 && s3.length() > 0 &&  s3.charAt(0) == s2.charAt(0)
                && solve(s1, s2.substring(1), s3.substring(1)))
            return true;
        deadEnds.add(new Pair(s1, s2));
        deadEnds.add(new Pair(s2, s1));
        return false;
    }

    /** 2D DP -> https://leetcode.com/problems/interleaving-string/solution/ */

    private static boolean isInterleaveDP(String s1, String s2, String s3) {
        if (s3.length() != s1.length() + s2.length())
            return false;
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        dp[0][0] = true;
        for (int i = 1; i < dp.length; i++) {
            if (dp[i-1][0] && s1.charAt(i-1) == s3.charAt(i-1))
                dp[i][0] = true;
        }

        for (int i = 1; i < dp[0].length; i++) {
            if (dp[0][i-1] && s2.charAt(i-1) == s3.charAt(i-1))
                dp[0][i] = true;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j] = (dp[i-1][j] && s1.charAt(i-1) == s3.charAt(i + j - 1)) ||    //up is true and chars match
                           (dp[i][j-1] && s2.charAt(j-1) == s3.charAt(i + j - 1));      //left is true and chars match
            }
        }
     return dp[dp.length-1][dp[0].length-1];
    }

}