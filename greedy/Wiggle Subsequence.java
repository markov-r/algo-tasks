public class Main {

    public static void main(String[] args) {
//        int nums[] = new int[] {};
//        int nums[] = new int[] {1};
//        int nums[] = new int[] {1, 17};
//        int nums[] = new int[] {1, 1};
//        int nums[] = new int[] {2, 1, 1};
//        int nums[] = new int[] {2, 2, 2, 2};
//        int nums[] = new int[] {1, 2, 3, 4, 5};
//        int nums[] = new int[] {5, 4, 3, 2, 1};
        int nums[] = new int[]{1, 7, 4, 9, 2, 5};
//        int nums[] = new int[] {1, 17, 5, 10, 13, 15, 10, 5, 16, 8};
//        int nums[] = new int[] {1, 2, 1, 2, 1, 2, 1};
//        int nums[] = new int[] {1, 2, 2, 2, 2, 2, 2};
//        int nums[] = new int[] {1, 2, 2, 7, 2, 1};
//        int nums[] = new int[] {1, 2, 2, 1, 1, 2, 2};
        System.out.println(wiggleMaxLengthDP(nums));
    }

    /*  GREEDY SOLUTION
     * When you have longer than 2, increasing or decreasing sub-sequence
     * just ignore all middle elements and use the first and the last only
     * (you don't gain anything from the middle ones). Also ignore duplicates.
     * So at the end you'll have a "clean" wiggle sequence with the required length. */

    /** Count all peaks and valleys (changes of direction)
     *  of increasing and decreasing subsequences and
     *  return that count + 1 */
    private static int wiggleMaxLengthGreedy(int[] nums) {
        if (nums.length < 2) return nums.length;
        int maxLen = 1;
        int sign = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i-1] && sign != -1) {         //peak
                sign = -1;
                maxLen++;
            } else if (nums[i] > nums[i-1] && sign != 1) {   //valley
                sign = 1;
                maxLen++;
            }
        }
        return maxLen;
    }

    /** Keep track of each increasing/decreasing sequences in two arrays and
     * update crosswise when increasing/decreasing sequence is detected.
     * This solution can be optimized to use 2 vars instead of 2 arrays */

    private static int wiggleMaxLengthDP(int[] nums) {
        if (nums.length < 2) return nums.length;
        int[] up = new int[nums.length];
        int[] down = new int[nums.length];
        up[0] = down[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i-1]) {
                up[i] = down[i-1] + 1;
                down[i] = down[i-1];
            } else if (nums[i] < nums[i-1]) {
                down[i] = up[i-1] + 1;
                up[i] = up[i-1];
            } else {
                down[i] = down[i-1];
                up[i] = up[i-1];
            }
        }
        return Math.max(down[nums.length-1], up[nums.length-1]);
    }
}
