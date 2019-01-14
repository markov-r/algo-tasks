import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        System.out.println(findMaxLength(new int[]{}));
        System.out.println(findMaxLength(new int[]{0}));
        System.out.println(findMaxLength(new int[]{0, 1}));
        System.out.println(findMaxLength(new int[]{0, 1, 1, 0, 1}));
        System.out.println(findMaxLength(new int[]{1, 1, 1, 0, 1}));
        System.out.println(findMaxLength(new int[]{1, 0, 1, 1, 0, 1, 0, 0}));
        System.out.println(findMaxLength(new int[]{1, 1, 0, 1, 0, 0, 1, 0, 0}));
    }

    /** Note down the changes coming with each arr element,
     * then find the biggest distance between two equal values.
     * The sub-array between two equal values always has equal number
     * of ones and zeroes. */
    private static int findMaxLength(int[] nums) {
        int dif = 0;
        Map<Integer, Integer> fluctuations = new HashMap<>();
        fluctuations.put(0, 0);
        int maxLen = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) dif++;
            else dif--;
            if (fluctuations.containsKey(dif)) maxLen = Math.max(maxLen, i + 1 - fluctuations.get(dif));
            else fluctuations.put(dif, i + 1);
        }
        return maxLen;
    }
}