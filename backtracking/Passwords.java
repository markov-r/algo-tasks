import java.io.*;
import java.util.*;

public class Main {

    private static int count = 0;
    private static int pswLen;
    private static int k;
    private static int[] password;
    private static OutputWriter writer;


    public static void main(String[] args) {
        InputReader reader = new InputReader();
        writer = new OutputWriter();
        pswLen = reader.readInt();
        String input = reader.readLine();
        k = reader.readInt();
        List<Integer> allDigits = new ArrayList<>();
        allDigits.add(10);
        for (int i = 1; i < 10; i++) {
            allDigits.add(i);
        }
        password = new int[pswLen];
        breakPsw(0, input, allDigits);
    }

    private static void breakPsw(int index, String input, List<Integer> digits) {
        if (index == pswLen) {
            count++;
            if (count == k) {
                StringBuilder sb = new StringBuilder();
                for (int i : password) {
                    sb.append(i);
                }
                writer.printLine(sb);
                writer.close();
                System.exit(0);
            }
            return;
        }
        for (int digit : digits) {
            password[index] = digit;
            if (digit == 10) {
                password[index] = 0;
            }
            String nextInput;
            if (input.length() > 1) {
                nextInput = input.substring(1);
            } else {
                nextInput = input.charAt(0) + "";
            }

            List<Integer> newDigits = new ArrayList<>();
            if (input.charAt(0) == '<' && digit != 1) {
                for (int i = 1; i < digit; i++) {
                    newDigits.add(i);
                }
            }
            if (input.charAt(0) == '>' && digit != 10) {
                for (int i = digit + 1; i <= 10; i++) {
                    newDigits.add(i);
                }
            }
            if (input.charAt(0) == '=') {
                newDigits.add(digit);
            }
            if (newDigits.contains(10)) {
                newDigits.remove((Integer) 10);
                newDigits.add(0, 10);
            }
            breakPsw(index + 1, nextInput, newDigits);
        }
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