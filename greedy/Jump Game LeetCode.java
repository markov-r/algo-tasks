import java.util.*;

public class Main {

    public static void main(String[] args) {
//        int [] nums = {1, 2, 3, 4, 3, 2, 1, 0, 1};
//        int[] nums = {1, 2, 0, 4, 0, 2, 1, 9};
//        int[] nums = {2, 0, 9};
//        int[] nums = {3, 0, 0, 3, 0, 1, 3, 0, 0, 0, 2};
//        int[] nums = {};
        int[] nums = {3, 0, 0, 5, 0, 0, 1, 0, 1};

        System.out.println(canJump(nums));
    }

/* Zeroes are the main problem and need to be jumped over, so we find all clusters of zeroes in the array.
    Then for each cluster check if it's possible to be jumped over (loop from cluster start backwards till array start(0)). */

    private static boolean canJump(int[] nums) {
        // Fill the clusters of zeroes in a list of lists
        List<List<Integer>> bigList = new ArrayList<>();
        boolean inZeroGroup = false;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0) {
                inZeroGroup = true;
                list.add(i);
            } else if (inZeroGroup) {
                bigList.add(list);
                list = new ArrayList<>();
                inZeroGroup = false;
            }
        }
        if (list.size() > 0) {
            bigList.add(list);
        }
        //Go from each zero cluster backwards till array start and check if it's possible to be jumped over
        for (List<Integer> smList : bigList) {
            if (!canJumpOver0s(nums, smList.get(0) - 1, smList.size())) {
                return false;
            }
        }
        return true;
    }

    private static boolean canJumpOver0s(int[] nums, int from, int zeroCnt) {
        int i, j;
        for (i = from, j = 0; i >= 0; i--, j++) {
            if (nums[i] > zeroCnt + j) return true;
        }
        return false;
    }

    private static void printList(List<List<Integer>> bigList) {
        for (List<Integer> list : bigList) {
            for (int i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
        System.out.println("----------");
    }
}
