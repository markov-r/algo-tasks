class Solution {
    public static void main(String[] args) {
//        System.out.println(new Solution().majorityElement(new int[]{1, 2, 2, 1, 1}));
//        System.out.println(new Solution().majorityElement(new int[]{1,1,1}));
        System.out.println(new Solution().majorityElement(new int[]{8,9,8,9,8}));
    }

    /** Divide And Conquer solution
     *  If we know the majority element in the left and in the right half
     *  of the array we can decide which is the majority element in the whole array,
     *  using straightforward counting of the number of occurrences. */
    
    public int majorityElement(int[] nums) {
        if (nums.length < 3) {
            return nums[0];
        }
        int left = findMajority(nums, 0, nums.length/2);
        int right = findMajority(nums, nums.length/2 + 1, nums.length - 1);
        return left == right ? left : moreFrequentElement(left, right, nums);
    }

    public int findMajority(int[] nums, int from, int to) {
        if (from == to) {
            return nums[from];
        }
        int mid = (to - from)/2 + from;
        int left = findMajority(nums, from, mid);
        int right = findMajority(nums, mid+1, to);
        return left == right ? left : moreFrequentElement(left, right, nums);
    }

    public int moreFrequentElement(int left, int right, int[] nums) {
        int countLeft = 0, countRight = 0;
        for (int num : nums) {
            if (num == left) {
                countLeft++;
            } else if (num == right) {
                countRight++;
            }
        }
        return countLeft > countRight ? left : right;
    }
}