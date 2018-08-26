import java.io.*;
import java.util.*;
import static java.lang.Character.*;

public class Main {

    private static void fakeInput() {
//        String test = "3z4";
        String test = "a1B2C3d4";
        System.setIn(new ByteArrayInputStream(test.getBytes()));
    }

    public static void main(String[] args) throws IOException {
        fakeInput();
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s = in.readLine();
        Solution.letterCasePermutation(s);
        for (String str : Solution.result) {
            System.out.println(str);
        }
    }

    static class Solution {

        static List<String> result = new ArrayList<>();

        static List<String> letterCasePermutation(String s) {
            if (s == null /*|| s.isEmpty()*/) {
                System.out.println();
                return null;
            } else {
                permuteCases(new StringBuilder(s), 0, new HashSet<>());
                return result;
            }
         }

        static void permuteCases(StringBuilder str, int index, Set<String> used) {
            for (int j = index; j < str.length(); j++) {
                if (!isDigit(str.charAt(j))) {
                    StringBuilder newLower = new StringBuilder(str);
                    char lowChar = Character.toLowerCase(str.charAt(j));
                    newLower.setCharAt(j, lowChar);
                    permuteCases(newLower, j + 1, used);

                    StringBuilder newUpper = new StringBuilder(str);
                    char upChar = Character.toUpperCase(str.charAt(j));
                    newUpper.setCharAt(j, upChar);
                    permuteCases(newUpper, j + 1, used);
                }
            }
            if (!used.isEmpty() && used.contains(str.toString())) {
                return;
            }
            result.add(str.toString());
            used.add(str.toString());
        }
    }
}

