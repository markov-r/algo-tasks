import java.util.*;

public class Main {

    public static void main(String[] args) {
//        int [] nums = {1, 2, 3, 4, 3, 2, 1, 0, 1};
//        int[] nums = {1, 2, 0, 4, 0, 2, 1, 9};
//        int[] nums = {2, 0, 9};
//        int[] nums = {3, 0, 0, 3, 0, 1, 3, 0, 0, 0, 2};
//        int[] nums = {};
//        int[] nums = {1};
//        int[] nums = {0, 2};
        int[] nums = {3, 0, 0, 5, 0, 0, 1, 0, 1};
        System.out.println(canJump(nums));
    }

/* Zeroes are the main problem and need to be jumped over, so we find all zeroes in the array.
    Then for each zero check if it's possible to be jumped over (loop from zero index minus one backwards till array start). */

    private static boolean canJump(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0) {
                list.add(i);
            }
        }
        for (int i : list) {
            if (!canJumpOver0s(nums, i - 1)) {
                return false;
            }
        }
        return true;
    }

    private static boolean canJumpOver0s(int[] nums, int from) {
        int i, j;
        for (i = from, j = 0; i >= 0; i--, j++) {
            if (nums[i] > j + 1) return true;
        }
        return false;
    }
}
