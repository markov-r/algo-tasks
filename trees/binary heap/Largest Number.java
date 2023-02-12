import java.util.PriorityQueue;

class Solution {

  public String largestNumber(int[] nums) {
    PriorityQueue<String> pQueue = new PriorityQueue<>((a, b) -> (b + a).compareTo(a + b));
    for (int num : nums) {
      pQueue.add(String.valueOf(num));
    }

    StringBuilder sb = new StringBuilder();
    while (!pQueue.isEmpty()) {
      sb.append(pQueue.poll());
    }

    if (sb.charAt(0) == '0') {
      return "0";
    }

    return sb.toString();
  }

  public static void main(String[] args) {
//    System.out.println(
//        new Solution().largestNumber(new int[]{5, 54, 59, 596, 594}));
//    System.out.println(
//        new Solution().largestNumber(new int[]{5, 54, 59, 596, 594, 4, 6}));
//    System.out.println(
//        new Solution().largestNumber(new int[]{2, 223}));
//    System.out.println(
//        new Solution().largestNumber(new int[]{432, 43243}));
//    System.out.println(
//        new Solution().largestNumber(new int[]{454, 45}));
//    System.out.println(
//        new Solution().largestNumber(new int[]{00, 0}));
//    System.out.println(
//        new Solution().largestNumber(new int[]{1, 0}));
  }
    int n = nums.length;
    int startIdx = -1;
    for (int i = 0; i < n - 1; i++) {
      if (nums[i + 1] < nums[i]) {
        startIdx = i;
        break;
      }
    }
    int endIdx = -1;
    for (int i = n - 1; i > 0; i--) {
      if (nums[i - 1] > nums[i]) {
        endIdx = i;
        break;
      }
    }
    if (endIdx == -1 || startIdx == -1) {
      return 0;
    }
    if (startIdx >= endIdx) {
      return startIdx - endIdx + 1;
    }
    return endIdx - startIdx + 1;
  }
}