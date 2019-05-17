import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().findLongestChain(new int[][]{{1,5},{1,6},{2,3},{3,4},{3,7},{8,9}}));
//        System.out.println(new Solution().findLongestChain(new int[][]{{1,2},{1,6},{2,3},{3,4},{3,7},{8,9}}));
//        System.out.println(new Solution().findLongestChain(new int[][]{{1,2},{2,3},{3,4}}));
//        System.out.println(new Solution().findLongestChain(new int[][]{{1,10},{7,8},{9,10}}));
//        System.out.println(new Solution().findLongestChain(new int[][]{{1,10},{2,7},{4,5},{7,8},{9,10}}));
//        System.out.println(new Solution().findLongestChain(new int[][]{{1,2},{3,7},{4,5},{8,9},{10,11}}));
    }

    /** A greedy solution.
     *  Sort the array first by first element, then by the second, e.g. [1,2] is before [1,4].
     *  Then start adding chains to the first element.
     *  If chain can't be extended, then check if the new pair is better than the current one
     *  (e.g. it makes sense to take [2,7] instead of [1,10], as 7 has more potential compared to 10). */

    public int findLongestChain(int[][] pairs) {
        if (pairs.length == 0 || pairs[0].length == 0) return 0;
        Arrays.sort(pairs, Comparator.comparingInt(a -> a[0]));
        int right = pairs[0][1];
        int count = 1;
        for (int i = 0; i < pairs.length; i++) {
            if (pairs[i][1] < right) {
                right = pairs[i][1];
            }
            if (pairs[i][0] > right) {
                right = pairs[i][1];
                count++;
            }
        }
        return count;
    }
}