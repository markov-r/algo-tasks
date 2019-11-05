class Solution {
    /**
     * First calculate the guaranteed-to-be-happy customers without any conversion.
     * Then calculate the converted ones in the first window with len x and add them to the previous sum.
     * Traverse all windows adding new and removing old elements and keep track of the maximum.
     */
    public int maxSatisfied(int[] customers, int[] grumpy, int x) {
        int n = customers.length;
        int current = 0;
        for (int i = 0; i < n; i++) {    //calc the guaranteed customers in non-grumpy seconds
            if (grumpy[i] == 0) {
                current += customers[i];
            }
        }

        for (int i = 0; i < x; i++) {   //add the converted grumpy customers from first window's conversions
            if (grumpy[i] == 1) {
                current += customers[i];
            }
        }
        int max = current;

        for (int i = x; i < n; i++) {   //calculate all other sliding windows
            if (grumpy[i] == 1) {
                current += customers[i];
            }
            if (grumpy[i-x] == 1) {
                current -= customers[i-x];
            }
            max = Math.max(current,max);
        }

        return max;
    }

    public static void main(String[] args) {
//        System.out.println(new Solution().maxSatisfied(new int[]{1,0,1,2,1,1,7,5}, new int[]{0,1,0,1,0,1,0,1}, 3));
        System.out.println(new Solution().maxSatisfied(new int[]{1,0,1,2,1,1,7,5}, new int[]{0,1,0,1,0,1,0,1}, 1));
    }
}