import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(new Solution().mergeTwoSortedArrays(new int[]{1,2,3,3}, new int[]{2,3,5,8})));
//        System.out.println(Arrays.toString(new Solution().mergeSort(new int[]{2, 5, 3, 1, 4})));
//        System.out.println(Arrays.toString(new Solution().mergeSort(new int[]{2, 5, 3, 1, 4, 6})));
//        System.out.println(Arrays.toString(new Solution().mergeSort(new int[]{2,5,1,7,1,2,8})));
        System.out.println(Arrays.toString(new Solution().mergeSort(new int[]{3,8,1,8,1,82,1,43,4,1,92,64,12,5,1,9})));
    }

    /** Keep dividing the array in half till length becomes 1 (then it's sorted).
     *  Then proceed with merging with the other sorted half of the array. */

    public int[] mergeSort(int[] nums) {
        if (nums.length == 1) {
            return nums;
        }
        int mid = nums.length / 2;
        int[] arr1 = mergeSort(Arrays.copyOfRange(nums,0, mid));
        int[] arr2 = mergeSort(Arrays.copyOfRange(nums, mid, nums.length));
        return mergeTwoSortedArrays(arr1, arr2);
    }

    /** Merging of two sorted arrays - maintain two pointers for each of the merging arrays
     *  and one pointer for the output array.
     *  Compare elements from both arrays and step up the pointers.
     *  When one of the arrays is finished, copy the remaining part.
     *  Could/should be optimized so that only indices of the array are passed as parameters,
     *  not the actual arrays.*/

    public int[] mergeTwoSortedArrays(int[] arr1, int[] arr2) {   //merging of two sorted arrays
        int[] sorted = new int[arr1.length + arr2.length];
        int i = 0, i1 = 0, i2 = 0;
        while (i < arr1.length + arr2.length) {
            if (i1 == arr1.length) {
                copyRemaining(sorted, i, i2, arr2);
                return sorted;
            }
            if (i2 == arr2.length) {
                copyRemaining(sorted, i, i1, arr1);
                return sorted;
            }
            if (arr1[i1] <= arr2[i2]) {
                sorted[i] = arr1[i1];
                i++;
                i1++;
            } else {
                sorted[i] = arr2[i2];
                i++;
                i2++;
            }
        }
        return sorted;
    }

    public void copyRemaining(int[] sorted, int i, int i1, int[] arr1) {
        for (int j = i; j < sorted.length; j++) {
            sorted[j] = arr1[i1];
            i1++;
        }
    }

}