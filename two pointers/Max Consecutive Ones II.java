/* Find the maximum number of consecutive 1s in a binary array,
    if you're allowed to flip at most one 0 to 1.
 */
class Solution {
    /**
     * Use two pointers to store the last two zeroes met.
     * Every time a new zero is met calculate sub-array length,
     * if the prev zero is flipped.
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxCount = 0, zeroCount = 0;
        int lastZero = -1, prevZero = -1; //indices of last two zeroes

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroCount++;
                if (zeroCount == 1) { //
                    lastZero = i;
                    continue;
                }
                maxCount = Math.max(maxCount, i - 1 - prevZero);
                prevZero = lastZero;
                lastZero = i;
            }
        }
        return Math.max(maxCount, nums.length - prevZero - 1);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findMaxConsecutiveOnes(
//            new int[]{1,0,1,1,1,0,1,1}));
//            new int[]{1}));
//            new int[]{0}));
//            new int[]{0,0}));
//            new int[]{1,1}));
//            new int[]{1,0}));
//            new int[]{0,1,}));
//            new int[]{1,0,1,}));
//            new int[]{1,0,1,0,1}));
//            new int[]{0,1,0,1,1,1,1}));
//            new int[]{0,0,1,1,1,1}));

//            new int[]{0,0,1,1,1,1,0,1,0}));
//            new int[]{0,1,1,0,1,0}));
                new int[]{1, 0, 1, 0}));
    }
}