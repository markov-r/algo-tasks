import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {

    public Solution() {
    }

    public static void main(String[] args) {
//        System.out.println(new Solution().minSteps(36));
        System.out.println(new Solution().minSteps(351));
    }

    private static Set<Integer> primesSet;

    /** Make a lookup table (set) containing all prime numbers <= 1000.
     *  Then do a prime factorization of the number and the sum of all prime factors
     *  is equal to the number of copy/paste operations needed. */
    
    public int minSteps(int n) {
        primesSet = new HashSet<>();
        primesSet.add(2); primesSet.add(3); primesSet.add(5); primesSet.add(7); primesSet.add(11); primesSet.add(13); primesSet.add(17); primesSet.add(19); primesSet.add(23); primesSet.add(29); primesSet.add(31); primesSet.add(37); primesSet.add(41); primesSet.add(43); primesSet.add(47); primesSet.add(53); primesSet.add(59); primesSet.add(61); primesSet.add(67); primesSet.add(71); primesSet.add(73); primesSet.add(79); primesSet.add(83); primesSet.add(89); primesSet.add(97); primesSet.add(101); primesSet.add(103); primesSet.add(107); primesSet.add(109); primesSet.add(113); primesSet.add(127); primesSet.add(131); primesSet.add(137); primesSet.add(139); primesSet.add(149); primesSet.add(151); primesSet.add(157); primesSet.add(163); primesSet.add(167); primesSet.add(173);
        primesSet.add(179); primesSet.add(181); primesSet.add(191); primesSet.add(193); primesSet.add(197); primesSet.add(199); primesSet.add(211); primesSet.add(223); primesSet.add(227); primesSet.add(229); primesSet.add(233); primesSet.add(239); primesSet.add(241); primesSet.add(251); primesSet.add(257); primesSet.add(263); primesSet.add(269); primesSet.add(271); primesSet.add(277); primesSet.add(281); primesSet.add(283); primesSet.add(293); primesSet.add(307); primesSet.add(311); primesSet.add(313); primesSet.add(317); primesSet.add(331); primesSet.add(337); primesSet.add(347); primesSet.add(349); primesSet.add(353); primesSet.add(359); primesSet.add(367);
        primesSet.add(373); primesSet.add(379); primesSet.add(383); primesSet.add(389); primesSet.add(397); primesSet.add(401); primesSet.add(409); primesSet.add(419); primesSet.add(421); primesSet.add(431); primesSet.add(433); primesSet.add(439); primesSet.add(443); primesSet.add(449); primesSet.add(457); primesSet.add(461); primesSet.add(463); primesSet.add(467); primesSet.add(479); primesSet.add(487); primesSet.add(491); primesSet.add(499); primesSet.add(503); primesSet.add(509); primesSet.add(521); primesSet.add(523); primesSet.add(541); primesSet.add(547); primesSet.add(557); primesSet.add(563); primesSet.add(569); primesSet.add(571); primesSet.add(577);
        primesSet.add(587); primesSet.add(593); primesSet.add(599); primesSet.add(601); primesSet.add(607); primesSet.add(613); primesSet.add(617); primesSet.add(619); primesSet.add(631); primesSet.add(641); primesSet.add(643); primesSet.add(647); primesSet.add(653); primesSet.add(659); primesSet.add(661); primesSet.add(673); primesSet.add(677); primesSet.add(683); primesSet.add(691); primesSet.add(701); primesSet.add(709); primesSet.add(719); primesSet.add(727); primesSet.add(733); primesSet.add(739); primesSet.add(743); primesSet.add(751); primesSet.add(757); primesSet.add(761); primesSet.add(769); primesSet.add(773); primesSet.add(787); primesSet.add(797);
        primesSet.add(809); primesSet.add(811); primesSet.add(821); primesSet.add(823); primesSet.add(827); primesSet.add(829); primesSet.add(839); primesSet.add(853); primesSet.add(857); primesSet.add(859); primesSet.add(863); primesSet.add(877); primesSet.add(881); primesSet.add(883); primesSet.add(887); primesSet.add(907); primesSet.add(911); primesSet.add(919); primesSet.add(929); primesSet.add(937); primesSet.add(941); primesSet.add(947); primesSet.add(953); primesSet.add(967); primesSet.add(971); primesSet.add(977); primesSet.add(983); primesSet.add(991); primesSet.add(997);

        if (primesSet.contains(n)) return n;
        int sum = 0;
        for (int i = 2; i <= n; i++) {
            while (n % i == 0) {
                sum += i;
                n /= i;
            }
            if (primesSet.contains(n)) {
                sum += n;
                break;
            }
        }
        return sum;
    }

    /** Slow and ineffective DP solution */

    public int minStepsSlow(int n) {
        if (primesSet.contains(n)) return n;
        if (n == 1) return 0;
        int[] dp = new int[n + 1];
        dp[1] = 0;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            if (primesSet.contains(i)) {
                dp[i] = i;
                continue;
            }
            int small = -1;                
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    small = j;
                    break;
                }
            }
            int big = i / small;
            dp[i] = dp[big] + i / big;
        }
        System.out.println(Arrays.toString(dp));
        return dp[n];
    }
}