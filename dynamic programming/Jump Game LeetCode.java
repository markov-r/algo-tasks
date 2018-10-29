import java.util.*;

public class Main {

    public static void main(String[] args) {
//        int[] nums = {};
//        int[] nums = {1};
//        int[] nums = {0, 2};
//        int[] nums = {2, 0, 9};
//        int[] nums = {2, 4, 2, 1, 0, 2, 0};
//        int[] nums = {1, 2, 3, 2, 1, 0, 1};
//        int[] nums = {1, 2, 0, 4, 0, 2, 1, 9};
//        int[] nums = {3, 0, 0, 5, 0, 0, 1, 0, 1};
        int[] nums = {3, 0, 0, 3, 0, 1, 3, 0, 0, 0, 2};

        System.out.println(canJumpGreedy(nums));
    }

    /** Backtracking solution -> slow */
    private static boolean canJumpBackTrack(int[] nums) {
        return (backTrack(0, nums));
    }

    /** Iterative top-down DP solution */
    private static boolean canJumpDPTopDown(int[] nums) {
        if (nums == null || nums.length == 0) return true;
        boolean[] reachable = new boolean[nums.length];
        reachable[0] = true;
        for (int i = 0; i < nums.length - 1; i++) {
            if (reachable[i]) {
                int maxJump = Math.min(i + nums[i], nums.length - 1);
                for (int j = i; j <= maxJump; j++) {
                    reachable[j] = true;
                }
            }
        }
        return reachable[reachable.length - 1];
    }

    /** Iterative bottom-up DP solution */
    private static boolean canJumpDPBottomUp(int[] nums) {
        if (nums == null || nums.length == 0) return true;
        Type[] memo = new Type[nums.length];
        for (int i = 0; i < memo.length; i++) {
            memo[i] = Type.UNKNOWN;
        }
        memo[memo.length - 1] = Type.GOOD;  //last index can reach itself
        for (int i = memo.length - 2; i >= 0; i--) {
            memo[i] = (reachesGoodInd(i, nums, memo)) ? Type.GOOD : Type.BAD;
        }
        return memo[0] == Type.GOOD;
    }

    /** Greedy solution -> fastest */
    private static boolean canJumpGreedy(int[] nums) {
        int maxSoFar = 0;
        for (int i = 0; i < nums.length; i++) {
            if (maxSoFar < i) return false;          //we've come to a block and can't go further
            maxSoFar = Math.max(maxSoFar, i + nums[i]);
        }
        return true;
    }

    /** Jump over zeroes solution -> quick */
    private static boolean canJumpZeroes(int[] nums) {
//    Zeroes are the problem and need to be jumped over.
//    So find all zeroes in the array.
//    Then for each check if it's possible to be jumped over 
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0) list.add(i);
        }
        for (int i : list) {
            if (!jumpsOver0s(nums, i - 1)) return false;
        }
        return true;
    }

    /** helper methods */
    private static boolean reachesGoodInd(int ind, int[] nums, Type[] memo) {
        int maxJump = Math.min(nums.length - 1, ind + nums[ind]);
        for (int i = ind; i <= maxJump; i++) {
            if (memo[i] == Type.GOOD) return true;
        }
        return false;
    }

    private static boolean jumpsOver0s(int[] nums, int from) {
        int i, j;
        for (i = from, j = 0; i >= 0; i--, j++) {
            if (nums[i] > j + 1) return true;
        }
        return false;
    }

    private static boolean backTrack(int i, int[] nums) {
        if (i == nums.length - 1) return true;
        int maxJump = Math.min(nums.length - 1, i + nums[i]);
        for (int j = i + 1; j <= maxJump; j++) {
            if (backTrack(j, nums)) return true;
        }
        return false;
    }

    enum Type {
        GOOD, BAD, UNKNOWN
    }
}