import java.util.Arrays;

public class Main {

    public static void main(String[] args){
//        String word1 = "horse", word2 = "ros";
//        String word1 = "intention", word2 = "execution";
        String word1 = "aabbbbbb", word2 = "bbbabaab";
//        String word1 = "rose", word2 = "horse";
//        String word1 = "", word2 = "";
//        String word1 = "a", word2 = "";
//        String word1 = "", word2 = "a";
//        String word1 = "aba", word2 = "bla";
//        String word1 = "abar", word2 = "ar";
        System.out.println(minDistance(word1, word2));
    }
		/** Memoization solution - similar to DP, but starting from bottom right cell 
				and traversing up to the top left, shortening each time either word1 or word2.
				The recursion bottom is when either of the strings reaches zero length, 
				as the only way to complete the task is to only add letters(if word1 is empty) or
				delete letters(if word2 is empty).
				An important optimization is that if both strings' last chars are equal 
				go for replacement of chars, as it will surely give better result compared to add/delete. */

    private static int[][] memo;

    private static int minDistance(String word1, String word2) {
        memo = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i < memo.length; i++)
            for (int j = 0; j < memo[0].length; j++)
                memo[i][j] = -1;
        return minDistanceRec(word1, word2);
    }

    private static int minDistanceRec(String word1, String word2) {
        int len1 = word1.length(), len2 = word2.length();
        if (memo[word1.length()][word2.length()] > -1)
            return memo[word1.length()][word2.length()];
        if (len1 == 0)
            return len2;
        if (len2 == 0)
            return len1;
        if (word1.charAt(len1-1) == word2.charAt(len2-1)) {  // if replacement is feasible - go for it
            return memo[word1.length()][word2.length()] = minDistanceRec(word1.substring(0, len1 - 1), word2.substring(0, len2 - 1));
        }
        return memo[word1.length()][word2.length()] = Math.min(Math.min(
                minDistanceRec(word1.substring(0, len1 - 1), word2),                            //up cell -> add
                minDistanceRec(word1, word2.substring(0, len2 - 1))),                           //left cell -> delete
                minDistanceRec(word1.substring(0, len1 - 1), word2.substring(0, len2 - 1)))     //upper left cell -> replace
                + 1;                                                                            //added cost
    }



    /** For first row it can only be achieved by adding the respective letter
     The first column can only be achieved by deleting the respective letter
     For the rest of the matrix we need to consider the three possible options
     and choose the minimum cost of all:
     - cell above + 1 (cost of deletion)
     - cell to the left + 1 (cost of addition)
     - cell both left and above (i-1,j-1) + 1(if char(i) != char(j)), else + 0 if equal.*/

    private static int minDistanceDP(String word1, String word2) {
        int len1 = word1.length(), len2 = word2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        dp[0][0] = 0;
        for (int i = 1; i < len1 + 1; i++) //add cost of deletion
            dp[i][0] = i;
        for (int i = 1; i < len2 + 1; i++) //add cost of addition
            dp[0][i] = i;

        for (int i = 1; i < len1 + 1; i++) {
            for (int j = 1; j < len2 + 1; j++) {
                int addReplCost = (word1.charAt(i-1) == word2.charAt(j-1)) ? 0 : 1; //if chars equal no additional replace cost
                int delAndAddCost = 1 + Math.min(dp[i-1][j], dp[i][j-1]);
                dp[i][j] = Math.min(delAndAddCost, dp[i-1][j-1] + addReplCost);
            }
        }
        System.out.println(Arrays.deepToString(dp).replace("], ", "]\n")
                .replace("[[", "[")
                .replace("]]", "]"));
        return dp[len1][len2];
    }

}
