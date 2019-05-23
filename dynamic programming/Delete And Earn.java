class Solution {

    public static void main(String[] args) {
//        System.out.println(new Solution().deleteAndEarn(new int[]{2}));
//        System.out.println(new Solution().deleteAndEarn(new int[]{2,1,2}));
//        System.out.println(new Solution().deleteAndEarn(new int[]{3,1,2}));
        System.out.println(new Solution().deleteAndEarn(new int[]{2,2,3,3,3,4,6,6,7,9}));
    }

    /** Create buckets for each number (max number is 10000) and each time
     *  a number is met increase the corresponding bucket with num's value.
     *  Then just apply "House Robber" solution on buckets array. */

    public int deleteAndEarn(int[] nums) {
        int[] buckets = new int[10001];
        for (int i = 0; i < nums.length; i++) {
            buckets[nums[i]] += nums[i];
        }
        //HOUSE ROBBER SOLUTION
        int[] dp = new int[buckets.length];              //can be replaced by two vars
        dp[0] = buckets[0];
        dp[1] = Math.max(buckets[0], buckets[1]);
        for (int i = 2; i < buckets.length; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + buckets[i]);
        }
        return dp[buckets.length-1];
    }
}