class Solution {

  public static void main(String[] args) {
//    System.out.println(new Solution().maximumScore(1, 1, 5));
//    System.out.println(new Solution().maximumScore(3, 3, 3));
//    System.out.println(new Solution().maximumScore(1, 1, 1));
//    System.out.println(new Solution().maximumScore(3, 5, 7));
//    System.out.println(new Solution().maximumScore(3, 4, 5));
//    System.out.println(new Solution().maximumScore(1, 1, 8));
    System.out.println(new Solution().maximumScore(1, 1, 800000));
  }

  public int maximumScore(int a, int b, int c) {
    int count = 0;
    while ((a > 0 && b > 0) || (a > 0 && c > 0) || (b > 0 && c > 0)) {
      int min = Math.min(a, Math.min(b, c));
      if (min == a) {
        b--;
        c--;
      } else if (min == b) {
        a--;
        c--;
      } else { //min == c
        a--;
        b--;
      }
      count++;
    }
    return count;
  }
}