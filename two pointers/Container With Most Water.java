public class Solution {

    /** Start with two pointers at both ends of array and
     * shrink the interval each time keeping the bigger value of the two
     * */
    public int maxArea(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        int maxArea = 0;

        while (right > left) {
            maxArea = Math.max(maxArea,
                     Math.min(arr[left], arr[right]) * (right - left));
            if (arr[right] > arr[left]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
//        System.out.println(new Solution().maxArea(new int[]{3, 9, 3, 4, 7, 2, 12, 6}));
        System.out.println(new Solution().maxArea(new int[]{1, 2, 4, 3}));
    }
}
