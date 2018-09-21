import java.io.*;

public class Main {

    private static void fakeInput() {
        String test = "9\n" +
                "()()()()()\n" +
                ")(\n" +
                "(((**\n" +
                "*\n" +
                "\n" +
                "***\n" +
                "**\n" +
                "(**)\n" +
                "****))";
        System.setIn(new ByteArrayInputStream(test.getBytes()));
    }

    private static boolean solutionFound;

    public static void main(String[] args) throws IOException {
        fakeInput();
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());

        for (int i = 0; i < n; i++) {
            String current = in.readLine();
            if (current.length() > 0 && current.charAt(0) == ')') {
                System.out.println("no");
                continue;
            }
            if (current.length() == 0) {
                System.out.println("yes");
                continue;
            }
            solutionFound = false;
            StringBuilder curSb = new StringBuilder(current);
            checkCurrent(curSb, 0, 0);
            System.out.println(solutionFound ? "yes" : "no");
        }
    }

    private static void checkCurrent(StringBuilder curSb,  int brackets, int index) {
        for (int i = index; i < curSb.length(); i++) {
            switch (curSb.charAt(i)) {
                case '(': {
                    brackets++;
                    break;
                }
                case ')': {
                    if (brackets > 0) {
                        brackets--;
                    } else {
                        return;
                    }
                    break;
                }
                case '*': {
                    curSb.deleteCharAt(i);
                        checkCurrent(curSb, brackets, i);
                    curSb.insert(i, '*');

                    curSb.setCharAt(i, '(');
                        checkCurrent(curSb,brackets + 1, i + 1);
                    curSb.setCharAt(i, '*');

                    curSb.setCharAt(i, ')');
                    if (brackets > 0) {
                        checkCurrent(curSb, brackets - 1, i + 1);
                    }
                    curSb.setCharAt(i, '*');
                    break;
                }
            }
        }
        if (brackets == 0) {
            solutionFound = true;
        }
    }
}