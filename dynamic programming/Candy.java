import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//        int[] arr = new int[] {};
//        int[] arr = new int[] {1};
//        int[] arr = new int[] {1, 3};
//        int[] arr = new int[] {1, 2, 2};
//        int[] arr = new int[] {1, 0, 2};
//        int[] arr = new int[] {1, 1, 1, 1, 1};
        int[] arr = new int[] {1, 2, 2, 1, 2, 1, 2};
//        int[] arr = new int[] {1, 3, 5, 3, 1, 3, 5};
//        int[] arr = new int[] {1, 2, 3, 3, 4, 4, 3, 2, 1};
//        int[] arr = new int[] {5, 5, 5, 5, 1, 5, 5, 5, 5};
//        int[] arr = new int[] {1, 2, 2, 3, 2, 1, 1, 3, 3, 3, 5};
//        int[] arr = new int[] {6, 5, 4, 3, 2, 1, 2, 1, 2, 1, 2};
        System.out.println(candyOnePass(arr));
    }

    private static int candyNaive(int[] ratings) {
        if (ratings == null || ratings.length == 0) return 0;
        int n = ratings.length;
        int[] candies = new int[n];
        Arrays.fill(candies, 1);
        boolean stillDreaming = true;
        while (stillDreaming) {
            stillDreaming = false;
            for (int i = 0; i < n - 1; i++) {
                if (ratings[i] < ratings[i+1] && candies[i] >= candies[i+1]) {
                    stillDreaming = true;
                    candies[i+1] = candies[i] + 1;
                }
                if (ratings[i] > ratings[i+1] && candies[i] <= candies[i+1]) {
                    stillDreaming = true;
                    candies[i] = candies[i+1] + 1;
                }
            }
            System.out.println("---");
        }
        System.out.println(Arrays.toString(candies));

        int sum = 0;
        for (int candy : candies) {
            sum += candy;
        }
        return sum;
    }

    private static int candyDP2arr(int[] ratings) {
        if (ratings == null || ratings.length == 0) return 0;
        int n = ratings.length;
        int[] increasing = new int[n];    //increasing sequences -> 1 2 5
        int[] decreasing = new int[n];    //decreasing sequences -> 5 3 0
        Arrays.fill(increasing, 1);
        Arrays.fill(decreasing, 1);
        for (int i = 0; i < n - 1; i++) {
            if (ratings[i+1] > ratings[i]) increasing[i+1] = increasing[i] + 1;
        }
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i+1]) decreasing[i] = decreasing[i+1] + 1;
        }
        System.out.println(Arrays.toString(increasing));
        System.out.println(Arrays.toString(decreasing));
        int[] max = new int[n];
        for (int i = 0; i < n; i++) {
            max[i] = Math.max(increasing[i], decreasing[i]);
        }
        System.out.println(Arrays.toString(max));
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += Math.max(increasing[i], decreasing[i]);
        }
        return sum;
    }
    
    private static int candyDP1arr(int[] ratings) {
        if (ratings == null || ratings.length == 0) return 0;
        int n = ratings.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 0; i < n - 1; i++) {
            if (ratings[i+1] > ratings[i]) dp[i+1] = dp[i] + 1;
        }
        int sum = dp[n-1];
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i+1]) {
                dp[i] = Math.max(dp[i], dp[i+1] + 1);
            }
            sum += dp[i];
        }
        System.out.println(Arrays.toString(dp));
        return sum;
    }

    private static int candyOnePass(int[] ratings) {
        if (ratings.length == 0) return 0;
        int sum = 1;
        int up = 0, downLen = 0, peakLen = 0;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i - 1] < ratings[i]) {
                peakLen = ++up;
                downLen = 0;
                sum += 1 + up;
            } else if (ratings[i - 1] == ratings[i])  {
                peakLen = up = downLen = 0;
                sum += 1;
            } else {
                up = 0;
                downLen++;
                sum += 1 + downLen + (peakLen >= downLen ? -1 : 0);
            }
        }
        return sum;
    }
}