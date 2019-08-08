class Solution {

/** Scan the array and use two pointers which are stepped when 
	the current sum becomes bigger or smaller than the target. */

    public static void main(String[] args) {
        System.out.println(new Solution().numSubarraysWithSum(new int[]{1, 0, 1, 0, 1}, 2));
//        System.out.println(new Solution().numSubarraysWithSum(new int[]{1}, 100));
//        System.out.println(new Solution().numSubarraysWithSum(new int[]{1, 1, 1, 1, 1}, 2));
//        System.out.println(new Solution().numSubarraysWithSum(new int[]{0,0,0}, 2));
//        System.out.println(new Solution().numSubarraysWithSum(new int[]{1,0,1}, 1));
//        System.out.println(new Solution().numSubarraysWithSum(new int[]{1,0,1}, 0));
    }

    public int numSubarraysWithSum(int[] arr, int target) {
        int n = arr.length;
        int left = 0, right = 0;
        int count = 0, sum = 0;
        for (; right < n; right++) {
            sum += arr[right];
            while (left < right && sum > target) {
                sum -= arr[left];
                left++;
            }
            if (sum == target) {
                count++;
                for (int i = left; i < right && arr[i] == 0; i++) {
                    count++;
                }
            }
        }
        return count;
    }
}