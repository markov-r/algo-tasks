import java.io.*;
import java.util.*;

public class Main {

    private static void fakeInput() {
        String test = "0 0\n" +
                "5 6\n" +
                "1 # 5 4 6 4\n" +
                "3 2 # 2 6 2\n" +
                "9 1 7 6 3 1\n" +
                "8 2 7 3 8 6\n" +
                "3 6 1 3 1 2";
        System.setIn(new ByteArrayInputStream(test.getBytes()));
    }

    private static int maxJumps = 0;

    public static void main(String[] args) {
        fakeInput();
        InputReader reader = new InputReader();
        OutputWriter writer = new OutputWriter();
        int startRow = reader.readInt();
        int startCol = reader.readInt();
        int r = reader.readInt();
        int c = reader.readInt();
        int[][] matrix = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                String next = reader.readLine();
                if (next.equals("#")) {
                    matrix[i][j] = -1;
                } else {
                    matrix[i][j] = Integer.parseInt(next);
                }
            }
        }
        findMaxJumps(startRow, startCol, matrix, 0);
        writer.printLine(maxJumps);
        writer.close();
    }

    private static void findMaxJumps(int row, int col, int[][] matrix, int currentJumps) {
        int val = matrix[row][col];
        if (val == 0) {
            if (currentJumps > maxJumps) {
                maxJumps = currentJumps;
            }
            return;
        }
        int[] dx = {val, -val, 0, 0};
        int[] dy = {0, 0, val, -val};
        for (int i = 0; i < 4; i++) {
            int nextRow = row + dx[i];
            int nextCol = col + dy[i];
            if (isInMatrix(nextRow, nextCol, matrix) && isPassable(nextRow, nextCol, matrix)) {
                matrix[row][col] = 0;
                currentJumps += val;
                findMaxJumps(nextRow, nextCol, matrix, currentJumps);
                matrix[row][col] = val;
                currentJumps -= val;
            }
        }
        if (currentJumps > maxJumps) {
            maxJumps = currentJumps;
        }
    }

    private static boolean isPassable(int row, int col, int[][] matrix) {
        return matrix[row][col] != -1;
    }

    private static boolean isInMatrix(int row, int col, int[][] matrix) {
        return row > -1 && row < matrix.length && col > -1 && col < matrix[0].length;
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
            return c == '\n' || c == '\r' || c == '\t' || c == -1 || c == ' ';
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
