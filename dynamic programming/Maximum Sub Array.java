
class Solution {

    public static void main(String[] args) {
//        System.out.println(new Solution().maxSubArray(new int[]{-1, 2, -2, 3, -1, 2}));
//        System.out.println(new Solution().maxSubArray(new int[]{-1, -2, -2, -3, -1, -2}));
        System.out.println(new Solution().maxSubArray(new int[]{-1, -2, -2, -3, -1, -2}));
    }

    /** A DP solution */

    public int maxSubArrayDP(int[] nums) {
        if (nums.length == 0) return 0;
        int max = nums[0];
        int current;
        int prev = nums[0];
        for (int i = 1; i < nums.length; i++) {
            current = Math.max(nums[i], prev + nums[i]);
            if (current > max) max = current;
            prev = current;
        }
        return max;
    }

    /** Divide and Conquer solution
     *  Considering the midpoint of the array there are 3 options:
     *  - the answer lies entirely left of the midpoint
     *  - the answer lies entirely right of the midpoint
     *  - the answer crosses the midpoint
     *  The first two cases can be solved directly by recursion.
     *  The third case can be solved in linear time by starting from midpoint
     *  and going left/right keeping the max found sum.
     *  The answer for a particular instance is the best of 1), 2) and 3). */

    public int maxSubArray(int nums[]) {
        if (nums.length == 0) return 0;
        return divideAndConquer(nums, 0, nums.length - 1);
    }

    public int divideAndConquer(int nums[], int left, int right) {
        if (left == right) {
            return nums[left];
        }
        int mid = (left + right) / 2;
        int leftOfMid = divideAndConquer(nums, left, mid);
        int rightOfMid = divideAndConquer(nums, mid + 1, right);

        int currSum = 0;
        int leftSection = nums[mid];
        for (int i = mid; i >= left; i--) {
            currSum += nums[i];
            leftSection = Math.max(leftSection, currSum);
        }
        currSum = 0;
        int rightSection = nums[mid+1];
        for (int i = mid + 1; i <= right; i++) {
            currSum += nums[i];
            rightSection = Math.max(rightSection, currSum);
        }
        int crossingMid = leftSection + rightSection;
        return Math.max(Math.max(leftOfMid, rightOfMid), crossingMid);
    }
}
