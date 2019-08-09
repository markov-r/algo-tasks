class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().checkPossibility(new int[]{1,2,1,3}));
        System.out.println(new Solution().checkPossibility(new int[]{3,2,1,2}));
        System.out.println(new Solution().checkPossibility(new int[]{4,5,2,3}));
        System.out.println(new Solution().checkPossibility(new int[]{2,5,2,3}));
        System.out.println(new Solution().checkPossibility(new int[]{1,2,3,1}));
        System.out.println(new Solution().checkPossibility(new int[]{2,3,3,2,4}));
        System.out.println(new Solution().checkPossibility(new int[]{3,2,4}));
        System.out.println(new Solution().checkPossibility(new int[]{3,3,2,4}));
        System.out.println();
        System.out.println(new Solution().checkPossibility(new int[]{1,4,2,3}));
    }

    /** If the number of decreasing pairs is 2 or more, this cannot be changed to a non-decreasing one.
     *  If there are no decreasing pairs, apparently it is OK.
     *  So we're left with the case of having one decreasing pair.
     *  We need to study the elements both left and right of that pair to make sure that both cases are covered.
     *  E.g. 1,4,2,3 => 1,2,2,3 and 1,2,3,1 => 1,2,3,4.
     *  The edge cases when the pair is at the beginning or at the end need to be covered as well. */

    public boolean checkPossibility(int[] nums) {
        if (nums.length < 2) return true;
        int numOfDecr = 0, decrIdx = -1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i+1]) {
                numOfDecr++;
                decrIdx = i + 1;
            }
        }
        if (numOfDecr == 0) {
            return true;
        }
        if (numOfDecr > 1) {
            return false;
        }
        if (decrIdx == 1 || decrIdx == nums.length - 1) {
            return true;
        }
        return nums[decrIdx-1] <= nums[decrIdx+1] ||
                nums[decrIdx-2] <= nums[decrIdx] ;
    }

}