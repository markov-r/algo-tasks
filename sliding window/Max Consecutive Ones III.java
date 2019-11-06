class Solution {

    /**
     * Traverse the array and every time the number of 0s exceeds k,
     * fix the low (left) pointer accordingly so that a valid max
     * sliding window is constructed.
     * Keep track of max sliding window.
     */
    public int longestOnes(int[] nums, int k) {
        int left = 0;
        int max = 0, zeroCount = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                zeroCount++;
            }
            if (zeroCount > k) {
                while (left < right && nums[left] == 1) {
                    left++;
                }
                left++;
                zeroCount--;
            }
            max = Math.max(max, right - left + 1);
        }
        return max;
    }

    public static void main(String[] args) {
//                new int[]{1,0,1,0,1,0,1,0,1,1,0}, 2));
//                new int[]{1,0,1,0,1,1,0}, 2));

        System.out.println(new Solution().longestOnes(
//            new int[]{1}, 2));
//            new int[]{0}, 2));
//            new int[]{0,0}, 2));
//            new int[]{1,1}, 2));
//            new int[]{1,0}, 2));
//            new int[]{0,1,}, 2));
//            new int[]{1,0,1,}, 2));
//            new int[]{1,0,1,0,1}, 2));
//            new int[]{0,0,1,1,1,1}, 2));
//            new int[]{0,1,0,1,1,1,1}, 2));
//            new int[]{1,0,1,1,1,0,1,1}, 2));
//                new int[]{0,0,1,1,1,1,0,1,0}, 2));
                new int[]{1,0,1,0,0,1,1,0}, 2));
//                new int[]{0,1,1,0,1,0}, 2));
//                new int[]{1,0,1,0}, 2));
//                new int[]{0,1,0,1,0,1,0,1,1}, 2));
//                new int[]{0,1,0,1,0,1,0,1,1}, 1));

//                new int[]{0,1,0,1,0,1,0}, 1));
//                new int[]{0,1,0,1}, 1));
//                new int[]{0,1,0,1,1,0,1}, 2));
//                new int[]{0,1,0,1,0,1,1,0}, 2));


//                new int[]{0,1,0,1,0,1,0,1,1}, 0));
    }
}