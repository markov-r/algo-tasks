import java.util.HashSet;
import java.util.Set;

class Solution {
  public int partitionString(String str) {
    int count = 1;
    Set<Character> charSet = new HashSet<>();
    for (int i = 0; i < str.length(); i++) {
      if (charSet.contains(str.charAt(i))) {
        count++;
        charSet.clear();
      }
      charSet.add(str.charAt(i));
    }

    return count;
  }

  public static void main(String[] args) {
//    System.out.println(new Solution().partitionString("abacaba"));
//    System.out.println(new Solution().partitionString("aaaaaa"));
//    System.out.println(new Solution().partitionString("ababa"));
//    System.out.println(new Solution().partitionString("alabala"));
//    System.out.println(new Solution().partitionString("a"));
    System.out.println(new Solution().partitionString("abbabbaa"));
  }
}