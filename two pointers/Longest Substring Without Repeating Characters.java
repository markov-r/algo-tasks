import java.util.HashMap;
import java.util.Map;

class Solution {
    /** Keep track of the best possible solution ending at the current idx (named right),
    and step left so that no repeating chars are present.
    For that reason keep a map containing the last met idx of each char.
    Note that left can only be increased (move to the right), and not decreased (go back to the left). */
    
    public int lengthOfLongestSubstring(String str) {
        final int len = str.length();
        if (len == 0) return 0;
        int left = 0, right = 0, longest = 0;
        Map<Character, Integer> map = new HashMap<>();
        map.put(str.charAt(0), 0);
        while (right < len - 1) {
            right++;
            if (map.containsKey(str.charAt(right))) {
                int oldIdx = map.get(str.charAt(right));
                left = Math.max(left, oldIdx + 1);
            }
            longest = Math.max(longest, right - left + 1);
            map.put(str.charAt(right), right);
        }
        return longest;
    }

    public static void main(String[] args) {
        System.out.println("pkewp -> " + new Solution().lengthOfLongestSubstring("pkewp"));
        System.out.println("pwkwp -> " + new Solution().lengthOfLongestSubstring("pwkwp"));
        System.out.println("pkewp -> " + new Solution().lengthOfLongestSubstring("pkewp"));
        System.out.println("pwwkewp -> " + new Solution().lengthOfLongestSubstring("pwwkewp"));
        System.out.println("aaba -> " + new Solution().lengthOfLongestSubstring("aaba"));
        System.out.println("ababc -> " + new Solution().lengthOfLongestSubstring("ababc"));
        System.out.println("pwwkew -> " + new Solution().lengthOfLongestSubstring("pwwkew"));
        System.out.println("abcabb -> " + new Solution().lengthOfLongestSubstring("abcabb"));
        System.out.println("aa -> " + new Solution().lengthOfLongestSubstring("aa"));
        System.out.println("a -> " + new Solution().lengthOfLongestSubstring("a"));
        System.out.println("aabc -> " + new Solution().lengthOfLongestSubstring("aabc"));
        System.out.println("abbc -> " + new Solution().lengthOfLongestSubstring("abbc"));
        System.out.println("abca -> " + new Solution().lengthOfLongestSubstring("abca"));
        System.out.println("abcc -> " + new Solution().lengthOfLongestSubstring("abcc"));
    }
}