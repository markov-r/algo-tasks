public class Main {

    /** Find if in a given array of non-negative numbers a given sum can be made
     * as a sum of any number of the array elements.
     * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
     * Fill row by row, first with an empty array you can make only zero sum.
     * Then for every next row the sums that you can make are the old ones,
     * plus all of the old ones plus the newly added arr. element. */

    private static boolean subSetDP(int[] nums, int sum) {
        boolean[][] dp = new boolean[nums.length + 1][sum + 1];
        // if sum is not zero and subset is 0, we can't make it
        for (int i = 1; i <= sum; i++)   dp[0][i] = false;

        // if sum is 0 empty subset makes that sum
        for (int i = 0; i <= nums.length; i++)  dp[i][0] = true;

        for (int i = 1; i <= nums.length; i++){
            for(int j = 1; j <= sum; j++){
                //first copy data from top (prev solutions are solutions to current sub-problem)
                dp[i][j] = dp[i-1][j];
                //If previously was false, check if the sum can be made with new element
                if (!dp[i][j] && j >= nums[i-1])
                    dp[i][j] = dp[i-1][j-nums[i-1]];
            }
        }
        return dp[nums.length][sum];
    }

    /** Memory optimized -> use only prev and current arr[sum+1],
     * not a full matrix, as only the previous row is used. */

    private static boolean subSetDPOptimized(int[] nums, int sum) {
        boolean[] prev = new boolean[sum+1];
        // if sum is not zero and subset is 0, we can't make it
        prev[0] = true;
        for (int i = 1; i < prev.length; i++)   prev[i] = false;

        boolean[] curr = new boolean[sum + 1];
        for (int num : nums) {
            curr = new boolean[sum + 1];
            for (int j = 0; j <= sum; j++) {
                if (prev[j]) {          //copy from top
                    curr[j] = true;
                    if (j + num <= sum) //also if new elem. + old sum fits in arr. -> add it as well
                        curr[j+num] = true;
                }
            }
            prev = curr.clone(); //curr is the new prev
        }
        return curr[sum];
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 4, 2}; int sum = 7;
//         System.out.println((subSetDP(nums, sum))); 
        System.out.println((subSetDPOptimized(nums, sum)));
    }
}
