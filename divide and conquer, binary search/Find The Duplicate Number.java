public class Main {

    public static void main(String[] args) {
//        System.out.println(findDuplicateBS(new int[]{1, 2, 2}));
//        System.out.println(findDuplicateBS(new int[]{1, 2, 3, 3, 5, 4}));
        System.out.println(findDuplicateBS(new int[]{1, 2, 3, 5, 4, 7, 9, 8, 3, 6}));
    }

    /** Floyd's Tortoise and Hare (Cycle Detection) algorithm
     */
    private static int findDuplicateCycle(int[] nums) {
        int tortoise = nums[0];
        int hare = nums[nums[0]];
        while (hare != tortoise) {      //find intersection point of two runners
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];
        }
        hare = 0;
        while (hare != tortoise) {     //find the cycle entrance
            tortoise = nums[tortoise];
            hare = nums[hare];
        }
        return hare;
    }

    /** Binary search solution
     *  Count the number of elements smaller than mid value.
     *  Then according to the result proceed with the left
     *  or right sub-interval.
     */
    private static int findDuplicateBS(int[] nums) {
        int n = nums.length, left = 1, right = n - 1, mid, count;
        while (left < right) {
            mid = left + (right - left)/2;
            count = 0;
            for (int num : nums)
                if (num <= mid) count++;
            if (count <= mid) left = mid + 1;
            else right = mid;
        }
        return right;
    }

}