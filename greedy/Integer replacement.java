class Solution {
  public int integerReplacement(int n) {
    if (n == Integer.MAX_VALUE) return 32;
    int count = 0;
    while (n > 1) {
      if (n % 2 == 0)
        n /= 2;
      else if (n >= 2 && ((n - 1) & (n - 2)) == 0) // n-1 is a power of 2
        n--;
      else if ((n + 1) % 4 == 0) // if (n + 1) is divisible by 4, it's more profitable to go up
        n++;
      else
        n--;
      count++;
    }
    return count;
  }

  public static void main(String[] args) {
//    System.out.println(new Solution().integerReplacement(3));
//    System.out.println(new Solution().integerReplacement(2));
//    System.out.println(new Solution().integerReplacement(4));
//    System.out.println(new Solution().integerReplacement(7));
//    System.out.println(new Solution().integerReplacement(Integer.MAX_VALUE));
//    System.out.println(new Solution().integerReplacement(Integer.MAX_VALUE - 1));
//    System.out.println(new Solution().integerReplacement(8));
    System.out.println(new Solution().integerReplacement(39));
  }
}