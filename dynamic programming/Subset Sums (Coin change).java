import java.io.*;
import java.util.*;

public class Main {

    private static void fakeInput() {
        String test = "14\n" +
                "2 1 2 4 3 5 2 6";
        System.setIn(new ByteArrayInputStream(test.getBytes()));
    }

    //  Working for positive integers only, needs small modification for negatives
    public static void main(String[] args) throws IOException {
        fakeInput();
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int checkSum = Integer.parseInt(in.readLine());
        String[] inputStr = in.readLine().split(" ");
        int n = inputStr.length;
        int[] nums = new int[n];
        int sumAll = 0;
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(inputStr[i]);
            sumAll += nums[i];
        }
        if (checkSum > sumAll) {
            System.out.println("no");
            return;
        }

        boolean[] possible = new boolean[sumAll + 1];
        for (int i = 0; i < n; i++) {
            Set<Integer> numsToAdd = new HashSet<>();
            for (int j = 0; j < sumAll + 1; j++) {
                if (possible[j]) numsToAdd.add(j + nums[i]);
            }
            possible[nums[i]] = true;
            for (int num : numsToAdd) {
                possible[num] = true;
            }
        }
        System.out.println(possible[checkSum] ? "yes" : "no");
    }
}