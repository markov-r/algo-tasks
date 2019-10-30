import java.util.Arrays;

class Solution {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(new Solution()
//                .twoSumTwoPointers(new int[]{1,2,5,7,10},9)));
                .twoSumTwoPointers(new int[]{2,7,11,15},9)));
//                .twoSumTwoPointers(new int[]{},9))); //NOT VALID, SOLUTION SHOULD EXIST
    }

    

    public int[] twoSumTwoPointers(int[] nums, int sum) {
        int first = 0;
        int second = nums.length - 1;
        while (nums[first] + nums[second] != sum) {
            if (nums[first] + nums[second] > sum) {
                second--;
            }
            if (nums[first] + nums[second] < sum) {
                first++;
            }
        }
        return new int[]{first+1, second+1};
    }


    /**
     * Trivial solution - for each number in the array do a binary search
     * right of it, trying to find a matching pair. Works in n * logn
     */
    public int[] twoSumBinSearch(int[] nums, int sum) {

        for (int i = 0; i < nums.length; i++) {
            int matchFound = binarySearch(nums, i+1, nums.length-1, sum - nums[i]);
            if (matchFound > -1) {
                return new int[]{i + 1, matchFound + 1};
            }
        }
        return new int[]{};
    }

    private int binarySearch(int[] nums, int left, int right, int target) {
        while (left <= right) {
            int mid = (left + right)/2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }


}