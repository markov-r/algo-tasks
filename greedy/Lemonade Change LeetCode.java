import java.io.*;
import java.util.*;

public class Main {

    private static void fakeInput() {
//        String test = "5 5 5 10 20";
        String test = "5 5 10 10 20";
//        String test = "";

        System.setIn(new ByteArrayInputStream(test.getBytes()));
    }

    public static void main(String[] args) throws IOException {
        fakeInput();
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] input = in.readLine().split(" ");
        int[] bills = new int[input.length];        //quicker than Map
        for (int i = 0; i < input.length; i++) {
            bills[i] = Integer.parseInt(input[i]);
        }
        System.out.println(lemonadeChange(bills));
    }

    private static boolean lemonadeChange(int[] bills) {
        if (bills.length == 0) {
            return true;
        }
        int[] notes = new int[2];
        for (int bill : bills) {
            switch (bill) {
                case 5:
                    notes[0]++;
                    break;
                case 10:
                    if (notes[0] > 0) {
                        notes[0]--;
                        notes[1]++;
                    } else {
                        return false;
                    }
                    break;
                case 20:
                    if (notes[0] == 0) {
                        return false;
                    }
                    if (notes[1] > 0) {                 // first choice - give 10$ + 5$
                        notes[0]--;
                        notes[1]--;
                        break;
                    }
                    if (notes[0] > 2 && notes[1] == 0) { // second choice - give 3 x 5$
                        notes[0] -= 3;
                    } else {
                        return false;
                    }
            }
        }
        return true;
    }
}

