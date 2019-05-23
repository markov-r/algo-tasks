class Solution {

    /** We need to find the longest sequence of alternating numbers.
     *  Keep track of "turbulent" changes and record the longest block of those.
     *  E.g. for 2,5,3,6,4 it is => up,down,up,down.
     *  For 2,3,5,1,2 answer is [3,5,1,2]
     *  For 8,8,1,6,3 answer is [8,1,6,3]
     *  When there are consecutive equal nums or they are not alternating
     *  reset counter and keep track of max len. */

    public int maxTurbulenceSize(int[] arr) {
        if (arr.length < 2) return 1;
        int len = 1, maxLen = 1;
        int sign = Integer.compare(arr[1], arr[0]);
        if (sign != 0) len++;
        maxLen = Math.max(len,maxLen);

        for (int i = 2; i < arr.length; i++) {
            int newSign = Integer.compare(arr[i], arr[i-1]);
            if (newSign == 0) {
                len = 1;    //if equal nums - len is last num only
                continue;
            }
            if (newSign == -sign) {
                len++;
            } else {
                len = 2; //if sign not changing - len is last two nums
            }
            sign = newSign;
            maxLen = Math.max(len, maxLen);
        }
        return maxLen;
    }

    public static void main(String[] args) {
//        System.out.println(new Solution().maxTurbulenceSize(new int[]{2}));
//        System.out.println(new Solution().maxTurbulenceSize(new int[]{2,2,2}));
        System.out.println(new Solution().maxTurbulenceSize(new int[]{8,8,9,10,6}));
//        System.out.println(new Solution().maxTurbulenceSize(new int[]{4,2,10,7,8}));
//        System.out.println(new Solution().maxTurbulenceSize(new int[]{1,2,3,3,2,1}));
//        System.out.println(new Solution().maxTurbulenceSize(new int[]{4,2,2,10,7,8}));
//        System.out.println(new Solution().maxTurbulenceSize(new int[]{9,4,2,10,7,8}));
//        System.out.println(new Solution().maxTurbulenceSize(new int[]{1,2,2,1,1,2,1,2}));
    }
}