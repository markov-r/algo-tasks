import java.util.ArrayList;
import java.util.List;

/** Count the number of ways an array with only 0s and 1s can be split into subarrays,
	such that each subarray contains exactly one 1.
*/

class CountWays {
    /** Count the zeroes between ones and note them down.
     *  E.g. in 100101 there are 2 groups with len 2 and 1.
     *  Every group of zeroes contributes with (len + 1) towards result.
     *  If there are 2 or more groups of consecutive zeroes,
     *  the result is the multiplication of those lengths for obvious reasons.
     *  Zeroes before first one or after the last one should be ignored.
     */
    public int countWays(int arr[]) {
        List<Integer> zeroSequences = new ArrayList<>();
        int zeroCount = 0;
        boolean onePresent = false; // start counting only after first 1
        for (int i : arr) {
            if (i == 1) {
                onePresent = true;
                zeroSequences.add(zeroCount + 1);
                zeroCount = 0;
            } else {
                if (onePresent) { //to handle leading 0s
                    zeroCount++;
                }
            }
        }
        int numOfWays = 1;
        for (Integer seq : zeroSequences) {
            numOfWays *= seq;
        }
        return zeroSequences.size() == 0 ? 0 : numOfWays; //if {0,0,0} return 0, not 1
    }

    public static void main(String args[]) {
//        int[] arr = {1};
//        int[] arr = {0};
//        int[] arr = {0,0,0};
//        int[] arr = {1,1,1};
//        int[] arr = {1,1,0,1};
//        int[] arr = {0,0,1,0};
//        int[] arr = {1,0,1,0,1};
//        int[] arr = {1,0,1,0,1,0,1};
//        int[] arr = {0,1,0,1,0,1,0,1};
//        int[] arr = {0,1,0,1,0,1,0,1,0,0};
        int[] arr = {0,1,0,1,0,1,0,1,0,0,1};

        System.out.println(new CountWays().countWaysGFG(arr, arr.length));
        System.out.println(new CountWays().countWays(arr));
    }
	
	 /** Solution given in geeks for geeks site
     * https://www.geeksforgeeks.org/ways-to-divide-a-binary-array-into-sub-arrays-such-that-each-sub-array-contains-exactly-one-1/
     */
    public int countWaysGFG(int arr[], int n) {
        int pos[] = new int[n];
        int p = 0, i;

        for (i = 0; i < n; i++)
        {
            if (arr[i] == 1)
            {
                pos[p] = i + 1;
                p++;
            }
        }

        if (p == 0)
        {
            return 0;
        }

        int ways = 1;
        for (i = 0; i < p - 1; i++)
        {
            ways *= pos[i + 1] - pos[i];
        }

        return ways;
    }

} 