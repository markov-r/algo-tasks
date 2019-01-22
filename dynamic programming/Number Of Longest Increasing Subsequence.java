public class Main {

    public static void main(String[] args) {
//        System.out.println(lengthOfLIS(new int[]{2}));
//        System.out.println(lengthOfLIS(new int[]{2, 2}));
//        System.out.println(lengthOfLIS(new int[]{1, 3, 2, 5, 4}));
//        System.out.println(lengthOfLIS(new int[]{3, 2, 1, 0, 4}));
//        System.out.println(lengthOfLIS(new int[]{1, 2, 3, 2, 1, 4}));
//        System.out.println(lengthOfLIS(new int[]{2, 5, 3, 7, 10, 9}));
//        System.out.println(lengthOfLIS(new int[]{1, 3, 2, 4, 3, 5}));
//        System.out.println(lengthOfLIS(new int[]{1, 4, 2, 5, 3, 6}));
//        System.out.println(lengthOfLIS(new int[]{3, 2, 1, 0, 4, 5}));
//        System.out.println(lengthOfLIS(new int[]{1, 1, 2, 2, 3, 3}));
//        System.out.println(lengthOfLIS(new int[]{1, 1, 1, 2, 2, 2, 3, 3, 3}));
    }

    /** Use the standard DP solution for finding the max length of LIS
     *  Add a count array that keeps the count of solutions for each index. */

    private static int lengthOfLIS(int[] seq) {
        if (seq.length == 0) return 0;
        int n = seq.length;
        int[] len = new int[n], cnt = new int[n];
        len[0] = 1; cnt[0] = 1;
        int maxLen = 1;
        for (int i = 1; i < n; i++) {
            len[i] = 1;
            cnt[i] = 1;
            for (int j = 0; j < i; j++) {
                if (seq[i] > seq[j] &&
                        len[j] + 1 > len[i]) {
                    len[i] = len[j] + 1;
                    cnt[i] = cnt[j];            //reset the count to the number of prev solution
                }
                else if (seq[i] > seq[j] &&
                        len[j] + 1 == len[i])
                    cnt[i] += cnt[j];           //add the number of prev solutions

            }
            if (len[i] > maxLen) maxLen = len[i];
        }
        int occurrences = 0;
        for (int i = 0; i < n; i++) 
            if (len[i] == maxLen) occurrences += cnt[i];    //add all cnt with maxLen
//        System.out.println(Arrays.toString(len));
//        System.out.println(Arrays.toString(cnt));
        return occurrences;
    }
}