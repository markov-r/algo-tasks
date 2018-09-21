import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {

    public static int NUM_OF_SIGNS = 3;

    static void fakeInput() {
        String test = "3\n" +
                "22 79 21";
        System.setIn(new ByteArrayInputStream(test.getBytes()));
    }

    public static void main(String[] args) {
//        fakeInput();
        InputReader reader = new InputReader();
        OutputWriter writer = new OutputWriter();
//        Scanner in = new Scanner(System.in);
        int n = reader.readInt();
        int[] numbers = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            numbers[arr_i] = reader.readInt();
        }

        Character[] signs = new Character[NUM_OF_SIGNS];
        signs[0] = '*';
        signs[1] = '+';
        signs[2] = '-';

        List<Character> current = new ArrayList<>();
        List<List<Character>> signCombos = new ArrayList<>();
        int r = n - 1;
        List<Character> combination = new ArrayList<>();
        for (int i = 0; i < r; i++) {
            combination.add(' ');
        }
        createVariations(r, signs, 0, combination, signCombos);
//        System.out.println(Arrays.toString(signCombos.toArray()));
//        System.out.println(signCombos.size());

        combine(signCombos, numbers, writer);
   }

    private static void createVariations(int r, Character[] signs, int index, List<Character> combination, List<List<Character>> signCombos) {
        if (index == r) {
            signCombos.add(new ArrayList<>());
            signCombos.get(signCombos.size() - 1).addAll(combination);
            return;
        }
        for (Character c : signs) {
            combination.set(index, c);
            createVariations(r, signs, index + 1, combination, signCombos);
        }
    }

    private static void combine(List<List<Character>> signCombos, int[] numbers, OutputWriter writer) {
        for (int i = 0; i < signCombos.size(); i++) {
            int all = numbers[0];
            StringBuilder sb = new StringBuilder();
            sb.append(numbers[0]);
            for (int j = 1; j < numbers.length; j++) {
                sb.append(signCombos.get(i).get(j-1));
                sb.append(numbers[j]);
                all = calculate(all, numbers[j], signCombos.get(i).get(j-1));
            }
            if (all % 101 == 0) {
                writer.printLine(sb.toString());
                writer.close();
                return;
            }
        }
    }

    private static int calculate (int all, int current, char c) {
        if (c == '+') {
            return all + current;
        }
        if (c == '-') {
            return all - current;
        }
        if (c == '*') {
            return all * current;
        }
        return 0;
    }

    static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;

        InputReader() {
            this.stream = System.in;
        }

        int read() {
            if (numChars == -1)
                throw new InputMismatchException();
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }

        int readInt() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        long readLong() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            long res = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        double readDouble() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            double res = 0;
            while (!isSpaceChar(c) && c != '.' && c != ',') {
                if (c == 'e' || c == 'E') {
                    return res * Math.pow(10, readInt());
                }
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = read();
            }
            if (c == '.' || c == ',') {
                c = read();
                double m = 1;
                while (!isSpaceChar(c)) {
                    if (c == 'e' || c == 'E') {
                        return res * Math.pow(10, readInt());
                    }
                    if (c < '0' || c > '9') {
                        throw new InputMismatchException();

                    }
                    m /= 10;
                    res += (c - '0') * m;
                    c = read();
                }
            }
            return res * sgn;
        }

        String readLine() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        boolean isSpaceChar(int c) {
            return c == '\n' || c == '\r' || c == ' ' || c == '\t' || c == -1;
        }
    }

    static class OutputWriter {
        private final PrintWriter writer;

        OutputWriter() {
            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        }

        void print(Object... objects) {
            for (int i = 0; i < objects.length; i++) {
                if (i != 0)
                    writer.print(' ');
                writer.print(objects[i]);
            }
        }

        void printLine(Object... objects) {
            print(objects);
            writer.println();
        }

        void close() {
            writer.close();
        }
    }

}
