import java.io.*;
import java.util.*;

public class Main {

    private static void fakeInput() {
        String test = "2 4 3 5 1 7 6 9 8";
//        String test = "0";
        System.setIn(new ByteArrayInputStream(test.getBytes()));
    }

    public static void main(String[] args) throws IOException {
        fakeInput();
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] inputStr = in.readLine().split(" ");
        int n = inputStr.length;
        int[] seq = new int[n];
        int[] len = new int[n];
        int[] prev = new int[n];

        for (int i = 0; i < n; i++) {
            seq[i] = Integer.parseInt(inputStr[i]);
        }

        len[0] = 1;
        prev[0] = -1;
        int maxLen = 0;
        int bestInd = 0;

        for (int i = 1; i < n; i++) {
            len[i] = 1;

            for (int j = 0; j <= i - 1; j++) {
                if (seq[j] < seq[i] &&
                        len[j] + 1 > len[i]) {
                    len[i] = len[j] + 1;
                    prev[i] = j;
                }
            }
            if (len[i] > maxLen) {
                maxLen = len[i];
                bestInd = i;
            }
        }
        System.out.println("The max lenght is " + maxLen);

        List<Integer> finalSequence = new ArrayList<>();
        while (bestInd != -1) {
            finalSequence.add(seq[bestInd]);
            bestInd = prev[bestInd];
        }
        Collections.reverse(finalSequence);
        System.out.print("A possible solution is ->   ");
        for (Integer num : finalSequence) {
            System.out.print(num + " ");
        }
    }
}