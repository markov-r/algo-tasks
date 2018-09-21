//generate all variations of A and B, with provided length N.
import java.io.*;
import java.util.*;

public class Main {

    static void fakeInput() {
        String test = "4\n" +
                "7 5";
        System.setIn(new ByteArrayInputStream(test.getBytes()));
    }

    public static void main(String[] args) throws IOException {
        fakeInput();
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        String numbers[] = in.readLine().split(" ");
        int a = Integer.parseInt(numbers[0]);
        int b = Integer.parseInt(numbers[1]);
        int[] nums = new int[2];
        nums[0] = Math.min(a,b);
        nums[1] = Math.max(a,b);

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            result.add(Integer.MIN_VALUE);
        }
        createVariations(n, nums, 0, result);
    }

    private static void createVariations(int n, int[] nums, int index, List<Integer> result) {
        if (index == n) {
            printVariation(result);
            return;
        }
        for (int i : nums) {
            result.set(index, i);
            createVariations(n, nums, index + 1, result);
        }
    }

    private static void printVariation(List<Integer> result) {
        for (Integer i : result) {
            System.out.print(i);
        }
        System.out.println();
    }
}