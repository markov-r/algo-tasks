import java.util.*;

public class Main {

    public static void main(String[] args) {
//        int[] nums = new int[]{};
//        int[] nums = new int[]{0, 2};
//        int[] nums = new int[]{2, 0};
//        int[] nums = new int[]{2, 0, 0};
//        int[] nums = new int[]{2, 0, 0, 0, 0};
//        int[] nums = new int[]{0, 2, 0, 0, 0};
        int[] nums = new int[]{0, 1, 0, 3, 12};
//        int[] nums = new int[]{2, 1};
        moveZeroes2pointers(nums);
        System.out.println(Arrays.toString(nums));
    }

    /** Copy all non-zero elements to the left of the array starting from index 0
     *  Then fill all remaining indices with 0's. */

    private static void moveZeroes(int[] nums) {
        int nonZero = 0;
        for (int i = 0; i < nums[i]; i++) {
            if (nums[i] != 0) {
                nums[nonZero] = nums[i];
                nonZero++;
            }
        }
        for (int i = nonZero; i < nums.length; i++)
            nums[i] = 0;
    }

    /** Similar to the above, but swaps instead of writing zeroes at the end */

    private static void moveZeroes2pointers(int[] nums) {
        for (int lastNonZero = 0, cur = 0; cur < nums.length; cur++) {
            if (nums[cur] != 0) {
                swap(nums, lastNonZero, cur);
                lastNonZero++;
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /** Save all zero indices and then move them one by one to the right
     *  starting from rightmost 0 then proceeding with next rightmost etc.
     *  Ineffective - worst case is almost O(n^2) when all nums are zeroes*/

    private static void moveZeroesSlow(int[] nums) {
        if (nums.length < 2) return;
        Deque<Integer> zeroes = new LinkedList<>();
        for (int i = 0; i < nums.length; i++)
            if (nums[i] == 0) zeroes.add(i);
        if (zeroes.size() == 0) return;
        if (zeroes.size() + zeroes.peekFirst() == nums.length) return;      //if all 0s already in right side
        while (zeroes.size() > 0){
            int zero = zeroes.pollLast();
            for (int i = zero; i < nums.length - 1; i++) {                  //move zero to end
                nums[i] = nums[i+1];
                nums[i+1] = 0;
            }
        }
    }
}