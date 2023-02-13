class Solution {

  /** Find the first occurrences where the numbers are not increasing in forward direction
   *  and not decreasing in backwards direction.
   *  Then try to expand those indexes in outwards direction as much as possible.
  **/
  public int findUnsortedSubarray(int[] nums) {
    int n = nums.length;
    int startIdx = -1;
    for (int i = 0; i < n - 1; i++) {
      if (nums[i + 1] < nums[i]) {
        startIdx = i;
        break;
      }
    }

    if (startIdx == -1)
      return 0;

    int endIdx = -1;
    for (int i = n - 1; i > 0; i--) {
      if (nums[i - 1] > nums[i]) {
        endIdx = i;
        break;
      }
    }

    int minStart = Integer.MAX_VALUE;
    for (int i = startIdx + 1; i < n; i++) {
      minStart = Math.min(minStart, nums[i]);
    }

    int maxEnd = Integer.MIN_VALUE;
    for (int i = endIdx - 1; i >= 0; i--) {
      maxEnd = Math.max(maxEnd, nums[i]);
    }

    for (int i = startIdx; i >= 0; i--) {
      if (nums[i] > minStart) {
        startIdx = i;
      }
    }

    for (int i = endIdx; i < n; i++) {
      if (nums[i] < maxEnd) {
        endIdx = i;
      }
    }

    return endIdx - startIdx + 1;
  }
  
    public static void main(String[] args) {
//    System.out.println(new Solution().findUnsortedSubarray(new int[]{2, 6, 4, 8, 10, 9, 15}));
//    System.out.println(new Solution().findUnsortedSubarray(new int[]{2, 6, 4, 15}));
//    System.out.println(new Solution().findUnsortedSubarray(new int[]{1, 2, 3, 4}));
//    System.out.println(new Solution().findUnsortedSubarray(new int[]{2}));
//    System.out.println(new Solution().findUnsortedSubarray(new int[]{1, 3, 2, 2, 2}));
//    System.out.println(new Solution().findUnsortedSubarray(new int[]{1, 3, 2, 2, 2, 3}));
//    System.out.println(new Solution().findUnsortedSubarray(new int[]{1, 3, 2, 2, 3, 3, 2}));
    System.out.println(new Solution().findUnsortedSubarray(new int[]{1, 3, 2, 2, 2, 1}));
  }
}