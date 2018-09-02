import java.io.*;
import java.util.*;

public class Main {

    private static int count = 0;

    private static void fakeInput() {
        String test = "2\n" +
                "10";
        System.setIn(new ByteArrayInputStream(test.getBytes()));
    }

    public static void main(String[] args) {
        fakeInput();
        InputReader reader = new InputReader();
        OutputWriter writer = new OutputWriter();
        int n = reader.readInt();
        int k = reader.readInt();
        int[][] mat = new int[n+1][k+1];

        for (int j = 2; j <= k; j++) {
            mat[1][j] = j-1;
        }

        for (int j = 2; j <= k; j++) {
            mat[2][j] = mat[1][j] * j;
        }
        if (n == 2) {
            writer.printLine(mat[n][k]);
            writer.close();
            return;
        }

        for (int j = 2; j <= k; j++) {
            mat[3][j] = mat[2][j] * j - mat[1][j];
        }

        if (n == 3) {
            writer.printLine(mat[n][k]);
            writer.close();
            return;
        }


        for (int i = 4; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                mat[i][j] = mat[i-1][j]*j - mat[i-3][j]*(j-1);
            }
        }

//        System.out.println(Arrays.deepToString(mat).replace("], ", "]\n"));

//        generateBins(n, k, new StringBuilder());
//        System.out.println(count);

        writer.printLine(mat[n][k]);
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

    private static void generateBins(int n, int k, StringBuilder sb) {

        if (sb.length() == n) {
            if (!sb.toString().contains("00") &&
                    sb.charAt(0) != '0') {
                count++;
            }
            return;
        }
        for (int i = 0; i < k; i++) {
            if (sb.length() == 0 && i == 0) {
                continue;
            }
            sb.append(i);
            generateBins(n, k, sb);
            sb.setLength(sb.length() - 1);
        }
    }
}
