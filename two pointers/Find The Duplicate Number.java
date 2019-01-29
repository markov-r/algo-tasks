public class Main {

    public static void main(String[] args) {
                    //0  1  2  3  4  5
        int[] nums = {1, 4, 3, 2, 5, 2};
        System.out.println(findDuplicate(nums));
    }
		/** Boyer-Moore cycle detection algorithm */
		
    private static int findDuplicate(int[] nums) {
        int tortoise = nums[0];                 // Find the intersection point of the two runners.
        int hare = nums[0];                     // Tortoise goes ahead one step, hare goes two
        do {
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];
        } while (tortoise != hare);

        int ptr1 = nums[0];                     // Find the "entrance" to the cycle.
        int ptr2 = tortoise;
        while (ptr1 != ptr2) {
            ptr1 = nums[ptr1];
            ptr2 = nums[ptr2];
        }
        return ptr1;
    }
}
