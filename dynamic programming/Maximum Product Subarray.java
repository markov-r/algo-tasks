public class Main {

    /**
     * Arr[] max keeps the max product ending on this index.
     * Arr[] min - the min product ending on this index.
     */
    private static int maxProductArr(int[] nums) {
        int[] max = new int[nums.length];
        int[] min = new int[nums.length];
        max[0] = min[0] = nums[0];
        int maxProd = nums[0];
        for (int i = 1; i < nums.length; i++) {
            min[i] = Math.min(nums[i], Math.min(max[i - 1] * nums[i], min[i - 1] * nums[i]));
            max[i] = Math.max(nums[i], Math.max(max[i - 1] * nums[i], min[i - 1] * nums[i]));
            if (max[i] > maxProd) maxProd = max[i];
        }
        return maxProd;
    }

    /**
     * As only the last arr. values are used
     * arrays can be replaced by variables.
     */
    private static int maxProductVar(int[] nums) {
        int tempMaxOld = nums[0];
        int tempMinOld = nums[0];
        int tempMin, tempMax;
        int maxProd = nums[0];
        for (int i = 1; i < nums.length; i++) {
            tempMin = Math.min(nums[i], Math.min(tempMinOld * nums[i], tempMaxOld * nums[i]));
            tempMax = Math.max(nums[i], Math.max(tempMinOld * nums[i], tempMaxOld * nums[i]));
            if (tempMax > maxProd) maxProd = tempMax;
            tempMaxOld = tempMax;
            tempMinOld = tempMin;
        }
        return maxProd;
    }


    public static void main(String[] args) {
//        System.out.println(maxProduct(new int[] {0}));
//        System.out.println(maxProduct(new int[] {1}));
//        System.out.println(maxProductArr(new int[] {1, 2, 0, 1}));
//        System.out.println(maxProductVar(new int[] {1, 2, 0, 1}));
//        System.out.println(maxProduct(new int[] {1, -2, 0, 1}));
//        System.out.println(maxProduct(new int[]{-1, 2, 2, 0}));
//        System.out.println(maxProduct(new int[] {0, 2, 2, 0}));
        System.out.println(maxProductArr(new int[]{-1, 2, 0, 5, -3}));
        System.out.println(maxProductVar(new int[]{-1, 2, 0, 5, -3}));
        System.out.println(maxProductArr(new int[]{-2, 3, -2, 0, 3, -2}));
        System.out.println(maxProductVar(new int[]{-2, 3, -2, 0, 3, -2}));
//        System.out.println(maxProduct(new int[]{-1, 0, -1, 0, -1}));
//        System.out.println(maxProduct(new int[] {-1, 2, 1, -5, -3}));
//        System.out.println(maxProduct(new int[] {2, -1, 3, -2, 0}));
//        System.out.println(maxProduct(new int[]{3, -1, 1, -2, 0, 5, 2}));
//        System.out.println(maxProductArr(new int[]{-2, 3, 2, -2, 3, -1, 0, -2, 1, -2}));
//        System.out.println(maxProductVar(new int[]{-2, 3, 2, -2, 3, -1, 0, -2, 1, -2}));
    }
}
