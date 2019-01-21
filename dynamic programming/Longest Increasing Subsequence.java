public class Main {

    public static void main(String[] args) {
//        int[] nums = {4, 5, 6, 3};
//        int[] nums = {2, 5, 2, 3};
        int[] nums =  {1, 4, 2, 5, 7, 6};
//        int[] nums = {2, 4, 3, 5, 1, 7, 6, 9, 8};
//        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(lengthOfLIS(nums));
    }


    /** The DP array keeps the longest sequence (could be not being the actual longest sequence).
     * It is however used for calculation of the longest sequence length.
     If nums[i] is bigger than largest in the dp array, add it to the end;
     If it is somewhere in the middle of the sequence, return the pos that bigger than pres,
     update the array with this position if val is smaller than dp[pos];
     This is to keep the sequence element with the smallest number. */

    private static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        int[] dp = new int[n];
        dp[0] = nums[0];
        int len = 0;
        for (int i = 1; i < n; i++) {
            int pos = binarySearch(dp, len, nums[i]);
            if (nums[i] < dp[pos])
                dp[pos] = nums[i];
            if (pos > len) {
                len = pos;
                dp[len] = nums[i];
            }
        }
        return len + 1;
    }

    private static int binarySearch(int[] dp, int len, int val) {
        int left = 0;
        int right = len;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (val == dp[mid]) return mid;
            if (val > dp[mid]) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (val > dp[len]) return len + 1;
        if (val <= dp[0]) return left;
        else return right;
    }

     /** Make a DP array keeping the best solution up till current index, ending on that index.
     * For the new index check for all previous indices if the element is bigger and if it is, 
     * check how long the new length can become, and keep the longest. */
    
    public int standardDP(int[] seq) {
        if (seq.length == 0) return 0;
        int len[] = new int[seq.length];    //longest length up till current index
        len[0] = 1;
        int maxLen = 1;
        for (int i = 1; i < seq.length; i++) {
            len[i] = 1;
            for (int j = 0; j < i; j++) {
                if (seq[i] > seq[j] &&          //if current num can make prev. sequence longer
                        len[j] + 1 > len[i])    //and it will make it best result so far
                    len[i] = len[j] + 1;
            }
            if (len[i] > maxLen) maxLen = len[i];
        }
        return maxLen;
    }

}
