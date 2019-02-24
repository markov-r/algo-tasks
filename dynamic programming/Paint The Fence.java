import java.util.Arrays;

public class Main {

    /** Given a fence with p posts and c colors,
     find out the number of ways of painting the fence
     such that at most 2 adjacent posts have the same color.
     Input: Both p and c are positive integers.

     Example: We have 4 colors and 2 posts.
     Ways when both posts have same color -> 4
     Ways when both posts have diff color -> 12
     4 (choices for 1st post) * 3(choices for 2nd post)
     Then the output is 4 + 12 = 16

     Another input -> p = 2; c = 4 => Output 16. */

    public static void main(String[] args) {
        System.out.println(paintTheFence(6, 8));
        generatorHelper("", 6, 8);
        System.out.println(count);
    }

    /** Current cell of the DP matrix is calculated as we sum the two cells above it
     *  and multiply the result by the current column value (j).
     *  First two rows are manually computed. */

    private static long paintTheFence(int posts, int colors) {
        long[][] dp = new long[posts][colors];
        for (int i = 0; i < colors; i++)    //first row
            dp[0][i] = i + 1;

        if (posts == 1) return dp[posts-1][colors-1];

        for (int i = 0; i < colors; i++)
            dp[1][i] = dp[0][i] * dp[0][i];

        if (posts == 2) return dp[posts-1][colors-1];

        for (int i = 2; i < posts; i++) {
            for (int j = 0; j < colors; j++) {
                dp[i][j] = (dp[i-1][j] + dp[i-2][j]) * j;
            }
        }
//        System.out.println(Arrays.deepToString(dp).replace("], ", "]\n")
//                .replace("[[", "[")
//                .replace("]]", "]"));
        return dp[posts-1][colors-1];
    }


    /** Simple helper function to generate all String combos, removing the ones that contain more than two equal chars. */

    private static long count = 0;

    private static void generatorHelper(String prefix, int posts, int colors) {
        char[] set = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j'};
        if (posts == 0) {
            if (!prefix.contains("aaa") && !prefix.contains("bbb") && !prefix.contains("ccc")
                    && !prefix.contains("ddd") && !prefix.contains("eee") && !prefix.contains("fff") && !prefix.contains("ggg")
                    && !prefix.contains("hhh") && !prefix.contains("iii")) {
                count++;
            }
            return;
        }
        for (int i = 0; i < colors; i++) {
            String newPrefix = prefix + set[i];
            generatorHelper(newPrefix, posts - 1, colors);
        }
    }
}