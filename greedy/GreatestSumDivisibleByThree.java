package max.sum.div3;

public class GreatestSumDivisibleByThree {

  public static void main(String[] args) {
//    int[] nums = new int[]{3, 3, 9};
//    int[] nums = new int[]{3, 3, 4, 4};
//    int[] nums = new int[]{3, 3, 1};
//    int[] nums = new int[]{3, 3, 2};
//    int[] nums = new int[]{2, 2};
//    int[] nums = new int[]{1, 1};
//    int[] nums = new int[]{1, 1, 2, 2};
//    int[] nums = new int[]{1, 1, 2, 2, 3};
//    int[] nums = new int[]{3, 6, 5, 1, 8};
//    int[] nums = new int[]{3, 5, 1, 8};
//    int[] nums = new int[]{2, 1, 2};
//    int[] nums = new int[]{2, 3, 36, 8, 32, 38, 3, 30, 13, 40};
    int[] nums = new int[]{2, 3, 6, 8, 2, 8, 3, 9, 5, 10};
//    int[] nums = new int[]{2, 0, 2, 2, 2, 0, 1, 1};

    System.out.println(new GreatestSumDivisibleByThree().maxSumDivThree(nums));
  }

  /** Find the remainder of the sum of all elements.
   * If remainder is 0 then return the sum.
   * If remainder is 1 then the answer is either:
   * - remove smallest element divisible by 1 from total sum or
   * - remove the two smallest elements divisible by 2 from total sum
   * Respectively if the remainder is 2 then it's either:
   * - remove smallest element divisible by 2 from total sum or
   * - remove the two smallest elements divisible by 1 from total sum
   */
  public int maxSumDivThree (int[] nums) {
    int sum = 0;
    for (int num : nums) {
      sum += num;
    }
    int remainder = getRemainderDivThree(sum);
    if (remainder == 0)
      return sum;

    int minDiv1 = Integer.MAX_VALUE;
    int minDiv1Idx = -1;
    int minDiv1Second = Integer.MAX_VALUE;
    int minDiv2 = Integer.MAX_VALUE;
    int minDiv2Idx = -1;
    int minDiv2Second = Integer.MAX_VALUE;
    for (int i = 0; i < nums.length; i++) {
      if (getRemainderDivThree(nums[i]) == 1 &&
          nums[i] < minDiv1) {
        minDiv1 = nums[i];
        minDiv1Idx = i;
      }
      if (getRemainderDivThree(nums[i]) == 2 &&
          nums[i] < minDiv2) {
          minDiv2 = nums[i];
          minDiv2Idx = i;
      }
    }
    for (int i = 0; i < nums.length; i++) {
      if (getRemainderDivThree(nums[i]) == 1 &&
          i != minDiv1Idx &&
          nums[i] >= minDiv1 &&
          nums[i] <= minDiv1Second) {
        minDiv1Second = Math.min(minDiv1Second, nums[i]);
      }
      if (getRemainderDivThree(nums[i]) == 2 &&
          i != minDiv2Idx &&
          nums[i] >= minDiv2 &&
          nums[i] <= minDiv2Second) {
        minDiv2Second = Math.min(minDiv2Second, nums[i]);
      }
    }

    int minSumToRemove = remainder == 1
        ? Math.min(minDiv1, areNoElementsWithRemainder(minDiv2, minDiv2Second)
                             ? minDiv1 : minDiv2 + minDiv2Second)
        : Math.min(minDiv2, areNoElementsWithRemainder(minDiv1, minDiv1Second)
                             ? minDiv2 : minDiv1 + minDiv1Second);

    return sum - minSumToRemove;
  }

  private boolean areNoElementsWithRemainder(int minDiv, int minDivSecond) {
    return minDiv == Integer.MAX_VALUE || minDivSecond == Integer.MAX_VALUE;
  }

  private int getRemainderDivThree(int sum) {
    return (int) (sum * 0x55555556L >> 30) & 3;
  }
}
