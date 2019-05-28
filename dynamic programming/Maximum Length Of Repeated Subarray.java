import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().findLength(new int[]{1}, new int[]{2,1}));
//        System.out.println(new Solution().findLength(new int[]{1}, new int[]{2,1}));
//        System.out.println(new Solution().findLength(new int[]{1}, new int[]{1}));
//        System.out.println(new Solution().findLength(new int[]{2}, new int[]{2,3}));
//        System.out.println(new Solution().findLength(new int[]{7,2,3}, new int[]{2,3,5,1}));
//        System.out.println(new Solution().findLength(new int[]{2,3,4,5}, new int[]{1,2,3,4}));
//        System.out.println(new Solution().findLength(new int[]{2,2,3,3,2,3}, new int[]{2,3,2}));
//        System.out.println(new Solution().findLength(new int[]{3,2,1,6,2}, new int[]{5,3,2,1}));
    }

    /** Everytime we find a match i == j in last elements in arr1 [...i]
     *  and arr2 [...j] we increase the previous match value (upper and left) by one.
     *  The max value in the dp matrix is the answer. */

    public int findLength(int[] arr1, int[] arr2) {
        int[][] dp = new int[arr1.length][arr2.length];
        int max = dp[0][0] = arr1[0] == arr2[0] ? 1 : 0;
        for (int i = 1; i < arr2.length; i++) {
            if (arr1[0] == arr2[i]) {
                dp[0][i] = 1;
                max = Math.max(max,dp[0][i]);
            }
        }
        for (int i = 1; i < arr1.length; i++) {
            if (arr2[0] == arr1[i]) {
                dp[i][0] = 1;
                max = Math.max(max,dp[i][0]);
            }
        }
        for (int i = 1; i < arr1.length; i++) {
            for (int j = 1; j < arr2.length; j++) {
                if (arr1[i] == arr2[j]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                max = Math.max(dp[i][j], max);
            }
        }
        System.out.println(Arrays.deepToString(dp).replace("], ", "]\n")
                .replace("[[", "[")
                .replace("]]", "]"));
        return max;
    }
}