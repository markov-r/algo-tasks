public class Main {

    public static void main(String[] args) {
//        int[] nums = {};
//        int[] nums = {1};
//        int[] nums = {1, 2};
//        int[] nums = {2, 0, 9};
//        int[] nums = {2, 4, 2, 1, 0, 2, 0};
//        int[] nums = {1, 2, 0, 4, 0, 2, 1, 9};
//        int[] nums = {3, 0, 0, 5, 0, 0, 1, 0, 1};

//        int[] nums = {2, 3, 1, 2, 1, 5};
//        int[] nums = {3, 2, 1, 2, 2, 1};
//        int[] nums = {3, 1, 1, 3, 1, 1, 3};
//        int[] nums = {1, 1, 1, 1, 1, 1, 1};
//        int[] nums = {7, 0, 9, 6, 9, 6, 1, 7, 9, 0, 1, 2, 9, 0, 3};
//        int[] nums = {4, 0, 3, 3, 2, 2, 3, 2, 2, 0, 1, 2, 2, 0, 5, 1, 1, 3, 4, 2, 1};
        int[] nums = {2, 0, 2, 0, 2, 0, 2, 0, 2, 0, 2, 0, 2, 0, 2, 0, 2, 0, 2, 0, 2, 0};

        System.out.println(findMinJumps(nums));
    }

		/* First possible jump is 1.. till nums[0].
			 We choose the one that takes us furthest into the array.
			 Repeat until end is reached. */

    private static int findMinJumps(int[] nums) {
        if (nums == null || nums.length <= 1) return 0;
//        if (nums.length == 2) return 1;
        int jumpsCnt = 1;             // as we have at least two elements, and there is a solution, jumps count is at least 1
        int furthestJump = nums[0];   // initially we can go as far as the first element allows
        int i = 0;                    // we start from first element
        int bestInd = 0;              // storing the best candidate's index
        while (furthestJump < nums.length - 1) {
            int maxReach = Math.min(nums.length - 1, i + nums[i]);
            for (int j = i + 1; j <= maxReach; j++) {
                int currJump = Math.min(nums.length - 1, j + nums[j]);
                if (currJump > furthestJump) {
                    furthestJump = currJump;
                    bestInd = j;
                }
            }
            i = bestInd;
            jumpsCnt++;
        }
        return jumpsCnt;
    }
}