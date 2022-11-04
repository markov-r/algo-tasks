public class MinimumSuffixFlips {

  public static void main(String[] args) {
    System.out.println(new MinimumSuffixFlips().minFlips("0101"));
  }

  public int minFlips(String target) {
    if (target.length() == 1)
      return target.charAt(0) == '0' ? 0 : 1;
    int switches = 0;
    for (int i = 1; i < target.length(); i++) {
      if (target.charAt(i) != target.charAt(i - 1)) {
        switches++;
      }
    }

    return target.charAt(0) == '0'
        ? switches
        : switches + 1;
  }
}
