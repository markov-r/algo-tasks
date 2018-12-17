import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
//  int[] nums = new int[]{};
//  int[] nums = new int[]{1};
//  int[] nums = new int[]{2, 2};
//  int[] nums = new int[]{2, 9};
//  int[] nums = new int[]{2, 3, 2};
//  int[] nums = new int[]{1, 7, 9, 4};
//  int[] nums = new int[]{2, 1, 1, 2};
  int[] nums = new int[]{1, 2, 3, 1};
//  int[] nums = new int[]{2, 2, 2, 2};
//  int[] nums = new int[]{2, 4, 8, 9, 9, 3};
//  int[] nums = new int[]{2, 7, 9, 3, 1};
//  int[] nums = new int[]{9, 1, 1, 9, 1, 1, 2};
//  int[] nums = new int[]{9, 1, 9, 1, 9, 1, 1, 3};
//  int[] nums = new int[]{1, 9, 9, 1, 9, 1, 1, 3};
//  int[] nums = new int[]{1, 2, 3, 1, 1, 2, 3, 1};
//  int[] nums = new int[]{1, 9, 1, 1, 9, 1, 9, 1, 0};

        System.out.println(rob(nums));
//        if (len == 1) return nums[0];
//        if (len == 2) return Math.max(nums[0], nums[1]);
//        if (len == 3) return Math.max(nums[1], nums[0] + nums[2]);
//        if (len == 4) return Math.max(Math.max(nums[1] + nums[3], nums[0] + nums[2]), nums[0] + nums[3]);
    }

    //RECURSIVE WITH MEMOIZATION (BOTTOM-UP)
    private static int robRecMemo(int[] nums) {
        int[] memo = new int[nums.length];        //faster if memo[] is global
        Arrays.fill(memo, -1);
        return robRecMemo(nums, nums.length - 1, memo);
    }

    private static int robRecMemo(int[] nums, int i, int[] memo) {
        if (i < 0) return 0;
        if (memo[i] >= 0) return memo[i];
        return memo[i] = Math.max(robRecMemo(nums,i-2, memo) + nums[i], robRecMemo(nums,i-1, memo));
    }

    //DP TOP-DOWN
    private static int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
            int[] dp = new int[nums.length];              //array can be replaced by two vars (e.g. prev, prevPrev)
            dp[0] = nums[0];
            dp[1] = Math.max(nums[0], nums[1]);
            for (int i = 2; i < nums.length; i++) {
                dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
            }
            return dp[nums.length-1];
    }
}