import java.io.*;
import java.util.*;

public class Main {

    private static void fakeInput() {
        String test = "4 5\n" +
                "7\n" +
                "1 4\n" +
                "0 3\n" +
                "1 2\n" +
                "2 1\n" +
                "3 1\n" +
                "1 2\n" +
                "2 4\n";
//        String test = "4 4\n" +
//                "11\n" +
//                "1 1\n" +
//                "2 1\n" +
//                "1 2\n" +
//                "2 1\n" +
//                "3 3\n" +
//                "0 3\n" +
//                "3 0\n" +
//                "3 1\n" +
//                "3 3\n" +
//                "1 1\n" +
//                "1 0\n";
//        String test = "10 10\n" +
//                "11\n" +
//                "0 0\n" +
//                "1 1\n" +
//                "2 2\n" +
//                "3 3\n" +
//                "4 4\n" +
//                "5 5\n" +
//                "6 6\n" +
//                "7 7\n" +
//                "8 8\n" +
//                "8 9\n" +
//                "9 9\n";
        System.setIn(new ByteArrayInputStream(test.getBytes()));
    }

    public static void main(String[] args) {
        fakeInput();
        InputReader reader = new InputReader();
        OutputWriter writer = new OutputWriter();
        int m = reader.readInt();
        int n = reader.readInt();
        int totalCoins = reader.readInt();
        int[][] coins = new int[m][n];
        for (int i = 0; i < totalCoins; i++) {
            int x = reader.readInt();
            int y = reader.readInt();
            coins[x][y] += 1;
        }

        int[][] collected = new int[m][n];
        collected[0][0] = coins[0][0];
        for (int i = 1; i < n; i++) {
            collected[0][i] = collected[0][i - 1] + coins[0][i];
        }
        for (int i = 1; i < m; i++) {
            collected[i][0] = collected[i-1][0] + coins[i][0];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                collected[i][j] = Math.max(collected[i][j-1], collected[i-1][j])
                        + coins[i][j];
            }
        }
//        writer.printLine(Arrays.deepToString(collected).replace("], ", "]\n"));
        writer.printLine(collected[m-1][n-1]);
        writer.close();
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
            return c == '\n' || c == '\r' || c == ',' || c == '\t' || c == -1 || c == ' ';
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
