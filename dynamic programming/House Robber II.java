public class Main {

    public static void main(String[] args) {
//        int[] nums = new int[]{2, 3, 2};
//        int[] nums = new int[]{0, 0, 0};
//        int[] nums = new int[]{1, 2, 3, 1};
//        int[] nums = new int[]{5, 1, 1, 3};
//        int[] nums = new int[]{5, 7, 5, 4};
        int[] nums = new int[]{2, 7, 9, 5};
//        int[] nums = new int[]{2, 3, 5, 1, 1, 5};
//        int[] nums = new int[]{1, 4, 7, 1, 4, 1, 0};
        System.out.println(rob(nums));
    }

     /**Using the previous problem (House Robber)
       We can either use the first or the last element.
       So we zero first and calculate then zero last and calculate.
       The answer is the bigger of the two.*/
    private static int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        int len = nums.length;
        int[] dp = new int[len];            //can do it without arr, just two vars (prev and prevPrev)

        int oldLast = nums[len-1];          //use the first, zero the last
        nums[len-1] = 0;
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
        }
        int firstIn = dp[nums.length-1];

        nums[0] = 0; nums[len-1] = oldLast;  //use the last, zero the first
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
        }
        int lastIn = dp[nums.length-1];

        return firstIn > lastIn ? firstIn : lastIn;
    }
}
