public class MinNumOfOperationsToMoveToEachBox {

  public static void main(String[] args) {
//    System.out.println(new MinNumOfOperationsToMoveToEachBox().minOperations("1011"));
//    System.out.println(new MinNumOfOperationsToMoveToEachBox().minOperations("001011"));
//    System.out.println(new MinNumOfOperationsToMoveToEachBox().minOperations("0"));
//    System.out.println(new MinNumOfOperationsToMoveToEachBox().minOperations("1"));
//    System.out.println(new MinNumOfOperationsToMoveToEachBox().minOperations("1001001010101101"));
  }

  public int[] minOperations(String boxes) {
    int n = boxes.length();

    //get first value for left to right
    int ones = 0; int total = 0;
    for (int i = 0; i < n; i++) {
      if (boxes.charAt(i) == '1') {
        total += i;
        ones++;
      }
    }

    // get sums for left to right for all rest
    int[] leftToRight = new int[n];
    leftToRight[0] = total;
    if (boxes.charAt(0) == '1') {
      ones--;
    }
    for (int i = 1; i < n; i++) {
      leftToRight[i] = leftToRight[i - 1] - ones;
      if (boxes.charAt(i) == '1') {
        ones--;
      }
    }

    //get first value for right to left
    total = 0; ones = 0;
    for (int i = n - 1; i >= 0; i--) {
      if (boxes.charAt(i) == '1') {
        total += (n - 1) - i;
        ones++;
      }
    }

    //get all values for right to left
    int[] rightToLeft = new int[n];
    rightToLeft[n-1] = total;
    if (boxes.charAt(n-1) == '1') {
      ones--;
    }
    for (int i = n - 2; i >= 0; i--) {
      rightToLeft[i] = rightToLeft[i+1] - ones;
      if (boxes.charAt(i) == '1') {
        ones--;
      }
    }

    //result is sum of two arrays
    int[] twoWays = new int[n];
    for (int i = 0; i < n; i++) {
      twoWays[i] = rightToLeft[i] + leftToRight[i];
    }

    return twoWays;
  }
}
