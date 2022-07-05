public class MinCostMoveChips {

  public static void main(String[] args) {
//    int[] chips = {2, 2, 2, 3, 3};
//    int[] chips = {1, 1, 1, 2, 2, 2, 3, 3};
//    int[] chips = {1, 1000000000, 1000000000, 1000000000};
    int[] chips = {1, 1, 2, 2, 3, 3};
    System.out.println(new MinCostMoveChips().minCostToMoveChips(chips));
  }

  public int minCostToMoveChips(int[] chips) {
    int odds = 0;
    int evens = 0;
    for (int chip : chips) {
      if (chip % 2 == 0) {
        evens++;
      } else {
        odds++;
      }
    }
    return Math.min(odds, evens);
  }
}
