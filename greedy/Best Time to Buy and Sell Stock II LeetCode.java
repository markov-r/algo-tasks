import java.io.*;
import java.util.*;

public class Main {

    private static void fakeInput() {
//        String test = "7 1 5 3 6 4";
//        String test = "1 2 3 4 5";
//        String test = "5 1 3 2 4 10 8 13";
        String test = "3 1 5 7 1 3 0 2 3 1 4 7";
        System.setIn(new ByteArrayInputStream(test.getBytes()));
    }

    public static void main(String[] args) throws IOException {
        fakeInput();
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String numbers[] = in.readLine().split(" ");
        int[] prices = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            prices[i] = Integer.parseInt(numbers[i]);
        }
        System.out.println(maxProfit(prices));
    }

    private static int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int profit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            int diff = prices[i+1] - prices[i];
            if (diff > 0) {
                profit += diff;
            }
        }
        return profit;
    }
}
