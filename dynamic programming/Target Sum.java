class Solution {

    public static void main(String[] args) {
//        System.out.println(new Solution().findTargetSumWays(new int[]{1,1,1,1,1}, 3));
//        System.out.println(new Solution().findTargetSumWays(new int[]{2,3,5,1,2,2}, 9));
//        System.out.println(new Solution().findTargetSumWays(new int[]{1,1,1}, 1));
        System.out.println(new Solution().findTargetSumWays(new int[]{2, 3, 2}, 3));
//        System.out.println(new Solution().findTargetSumWays(new int[]{1}, 1));
    }

    /** Straightforward recursive (backtracking) solution
     *  Try all possible cases and sum the matching ones. */

    public int findTargetSumWays(int[] nums, int target) {
        return findTargetSumWays(0, 0, nums, target);
    }

    public int findTargetSumWays(int pos, int curSum, int[] nums, int target) {
        int result = 0;
        if (pos == nums.length) {
            return curSum == target ? 1 : 0;
        }
        curSum += nums[pos];    //add num
        result += findTargetSumWays(pos + 1, curSum, nums, target);
        curSum -= nums[pos];    //backtrack
        curSum -= nums[pos];    //subtract num
        result += findTargetSumWays(pos + 1, curSum, nums, target);
        return result;
    }

    /**
     * Suppose we can find out the number of times a particular sum, say sum_i​ is possible upto a particular index,
     * say i, in the given nums array, which is given by say count_i. Now, we can find out the number of times
     * the sum sum_i + nums[i] can occur easily as count_i​. Similarly, the number of times the sum sumi−nums[i]
     * occurs is also given by count_i. Thus, if we know all the sums sum_j​'s which are possible upto the jth index
     * by using various assignments, along with the corresponding count of assignments, count_j, leading to the same sum,
     * we can determine all the sums possible upto the (j+1)th index along with the corresponding count of assignments
     * leading to the new sums. */

    public int findTargetSumWaysDP(int[] nums, int target) {
        if (nums.length == 0 || target > 1000) {
            return 0;
        }
        int[][] dp = new int[nums.length][20001]; //shifting interval [-1000,0] as positive
        dp[0][1000 + nums[0]] = 1;
        dp[0][1000 - nums[0]] += 1;
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = 1000 - totalSum; j <= 1000 + totalSum; j++) {
                if (dp[i - 1][j] > 0) {
                    dp[i][j + nums[i]] += dp[i - 1][j];
                    dp[i][j - nums[i]] += dp[i - 1][j];
                }
            }
        }
        return dp[nums.length - 1][1000 + target];
    }
}