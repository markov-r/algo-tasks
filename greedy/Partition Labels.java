import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    public static void main(String[] args) {
//        System.out.println(new Solution().partitionLabels("abadedexzizi"));
//        System.out.println(new Solution().partitionLabels("abadedex"));
//        System.out.println(new Solution().partitionLabels("mamatidebakrivabe"));
//        System.out.println(new Solution().partitionLabels("cacatigrizni"));
        System.out.println(new Solution().partitionLabels("kuchetonespi"));
    }

    /** Collect the last occurrence of each char.
     *  Traverse the string and create an initial interval.
     *  If the last occurrence of a char is outside the current interval, extend it.
     *  When you reach the end of the interval collect the interval length then reset interval idx. */

    public List<Integer> partitionLabels(String str) {
        List<Integer> intervals = new ArrayList<>();
        Map<Character, Integer> last = new HashMap<>(); //last char occurrence idx
        for (int i = 0; i < str.length(); i++) {
            last.put(str.charAt(i), i);
        }
        int lastIdx = -1, offset = 0;
        for (int i = 0; i < str.length(); i++) {
            lastIdx = Math.max(lastIdx, last.get(str.charAt(i)));
            if (i == lastIdx) {
                intervals.add(lastIdx + 1 - offset);
                offset = lastIdx + 1;
            }
        }
        return intervals;
    }
}