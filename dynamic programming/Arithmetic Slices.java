class Solution {
    public Solution() {
    }

    public static void main(String[] args){
//        System.out.println(new Solution().numberOfArithmeticSlices(new int[]{}));
//        System.out.println(new Solution().numberOfArithmeticSlices(new int[]{0}));
//        System.out.println(new Solution().numberOfArithmeticSlices(new int[]{0,0}));
//        System.out.println(new Solution().numberOfArithmeticSlices(new int[]{1,2,3,2,1}));
//        System.out.println(new Solution().numberOfArithmeticSlices(new int[]{1,2,3,2,1}));
//        System.out.println(new Solution().numberOfArithmeticSlices(new int[]{1,2,3,2,1,2,3,2,1,0}));
//        System.out.println(new Solution().numberOfArithmeticSlices(new int[]{1,3,5,7,9,0,0,-5,-3,-1}));
        System.out.println(new Solution().numberOfArithmeticSlices(new int[]{1,3,5,7,5,3}));
    }

    /** If a arithmetic sequence of len 3 is met starting from current position increase current counter
     *  and for each consecutive sequence step up the counter.
     *  As for e.g. 3 consecutive sequences of len 3 the total is (1 + 2 + 3) =>
     *  e.g. in [1,2,3,4,5] there is one seq of len 5, two seq of len 4 and three seq of len 3, totalling 6.
     *  When there is no valid sequence of len 3, reset counter cur to 0. */

    public int numberOfArithmeticSlices(int[] arr) {
        int sum = 0, cur = 0;
        for (int i = 0; i < arr.length - 2; i++) {
            if (arr[i+1] - arr[i] == arr[i+2] - arr[i+1]) {
                cur++;
                sum += cur;
            } else {
                cur = 0;
            }
        }
        return sum;
    }



    /** Make a dp bool array and mark as true all elements that start a valid arithmetic sequence of len 3.
     *  Then traverse the dp array and for each consecutive subsequence of true elements calculate the total number of slices.
     *  E.g. for [true, true, true, false, true, false, false] there are 2 groups - a group with len 3 and another with len 1.
     *  First sequence gives us a total ot 6 (1 + 2 + 3) solutions => 1 slice with len 5, 2 slices with len 4 and 1 slice with len 3.
     *  The second sequence gives us 1 more solution of len 3, so the total number is 7.  */

    public int numberOfArithmeticSlicesMoreSpace(int[] arr) {
        boolean[] dp = new boolean[arr.length];
        for (int i = 0; i < arr.length - 2; i++) {
            if (arr[i+1] - arr[i] == arr[i+2] - arr[i+1]) {
                dp[i] = true;
            }
        }
        int curSlice = 0, allSlices = 0;
        for (int i = 0; i < arr.length; i++) {
            if (dp[i]) {
                curSlice++;
                allSlices += curSlice;
            } else {
                curSlice = 0;
            }
        }
        return allSlices;
    }
}