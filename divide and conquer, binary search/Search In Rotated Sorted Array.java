public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().search(new int[]{5, 6, 1, 2, 3}, 2));
        System.out.println(new Solution().search(new int[]{5, 1, 2, 3}, 2));
        System.out.println(new Solution().search(new int[]{2, 3, 4, 1}, 2));
        System.out.println(new Solution().search(new int[]{5, 6, 7, 8, 9}, 2));
    }

    /** First find the point at which the sorted array is rotated (breakIdx), if present.
     *  Then we have two smaller sorted arrays in which we can do binary search. */

    public int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int left = 0, right = nums.length - 1;
        int breakIdx = -1;          // rotating point
        int mid;
        while (nums[left] > nums[right]) {  //loop while the array ends are unsorted (5...2)
            if (right == left + 1) {
                breakIdx = right;
                break;
            }
            mid = (left + right) / 2;
            if (nums[left] > nums[mid]) {
                right = mid;
            } else {
                left = mid;
            }
        }
        if (breakIdx == -1) {   //no rotation, just do a standard binary search in the whole array
            return binarySearch(nums, target, 0, nums.length - 1);
        }
        if (target >= nums[left] && target <= nums[right]) {  //choose a sub-array to do binary search in
            return binarySearch(nums, target, 0, breakIdx - 1);
        } else {
            return binarySearch(nums, target, breakIdx, nums.length - 1);
        }
    }

    public int binarySearch(int[] nums, int target, int left, int right) {
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}