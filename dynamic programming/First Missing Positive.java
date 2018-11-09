import java.util.*;

public class Main {
    public static void main(String[] args) {
//        System.out.println(firstMissingPositiveDP(new int[] {2, 2}));
//        System.out.println(firstMissingPositiveDP(new int[] {2, 2, 0}));
//        System.out.println(firstMissingPositiveDP(new int[] {3, 4, -1, 1}));
//        System.out.println(firstMissingPositiveDP(new int[] {6, 2, 4, 1}));
//        System.out.println(firstMissingPositiveDP(new int[] {3, 3, 1, 2}));
//        System.out.println(firstMissingPositiveDP(new int[] {1, 1, 2, 2}));
//        System.out.println(firstMissingPositiveDP(new int[] {3, 1, 1, 2}));
//        System.out.println(firstMissingPositiveDP(new int[] {1, 2, 3, 4, 5, 6}));
//        System.out.println(firstMissingPositiveDP(new int[] {6, 5, 4, 3, 2, 1}));
//        System.out.println(firstMissingPositiveDP(new int[] {5, 3, -1, 2, 4, 0}));
//        System.out.println(firstMissingPositiveDP(new int[] {3, 0, 1, 1, 1, 2, -3}));
//        System.out.println(firstMissingPositiveDP(new int[] {2, 3, 5, 4, 0, -1, 1}));
//        System.out.println(firstMissingPositiveDP(new int[] {2, 3, 5, 4, 0, -1, 3}));
//        System.out.println(firstMissingPositiveDP(new int[] {3, 3, 3, 0, 1, 2, -3}));
//        System.out.println(firstMissingPositiveDP(new int[] {-2, -3, -5, -4, 0, -1, -3}));
//        System.out.println(firstMissingPositiveDP(new int[] {-2, -3, -5, -4, 0, 1, -3}));
//        System.out.println(firstMissingPositiveDP(new int[] {2, 3, 5, 4, 0, -1, 3}));
//        System.out.println(firstMissingPositiveDP(new int[] {-2, -3, -5, -4, 0, -1, -3}));
//        System.out.println(firstMissingPositiveDP(new int[] {-2, -3, -5, -4, 0, 1, -3}));
//        System.out.println(firstMissingPositiveDP(new int[] {3, 3, 3, 0, 1, 2, -3}));
//        System.out.println(firstMissingPositiveDP(new int[] {1, 2, 3, 4, 5, 6}));
//        System.out.println(firstMissingPositiveDP(new int[] {5, 3, -1, 2, 4, 0}));
    }

    /** Dynamic Programming solution
     * Keep track of current best candidate and increase if that number is met in the array
     * Loop until current best stops being updated */
    private static int firstMissingPositiveDP(int[] nums) {
        int currBest = 1;
        int highestCleared = 0;                 // taking care of duplicates
        boolean stillDreaming = true;           // keep loop alive while currBest keeps being updated
        while (stillDreaming) {
            stillDreaming = false;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > 0) {
                    if (nums[i] <= currBest && nums[i] > highestCleared) {
                        currBest++;
                        stillDreaming = true;
                        highestCleared = nums[i];
                        nums[i] = 0;            // we won't use it anymore, so marking it
                    }
                }
            }
        }
        return currBest;
    }

    /** Put each number in its right place, e.g. we find 5, then swap it with A[4].
     At last, the first place where its number is not right, return the place + 1.
     Something like a custom set using the array only*/
    private static int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) return 1;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i]-1] != nums[i]) {
                int temp = nums[i];
                nums[i] = nums[nums[i]-1];
                nums[temp-1] = temp;
            }
        }
        System.out.println(Arrays.toString(nums));
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) return i + 1;
        }
        return n + 1;
    }

    /** TRIVIAL
     * Sort array, then find the first missing */
    private static int firstMissingPositiveSort(int[] nums) {
        Arrays.sort(nums);
        int min = 1;
        for (int num : nums) {
            if (num == min) min++;
        }
        return min;
    }

    /** TRIVIAL
     * Collect all >= 1 elements in a set, then scan the set */
    public int firstMissingPositiveSet(int[] nums) {
        int max = Integer.MIN_VALUE;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (num < 1) continue;
            if (num > max) max = num;
            set.add(num);
        }
        for (int i = 1; i <= max + 1; i++) {
            if (!set.contains(i)) return i;
        }
        return 1;
    }

    
}