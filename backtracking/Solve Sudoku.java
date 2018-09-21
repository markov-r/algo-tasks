import java.io.*;
import java.util.*;

public class Main {

    private static void fakeInput() {
        String test = "---2---63\n" +
                "3----54-1\n" +
                "--1--398-\n" +
                "-------9-\n" +
                "---538---\n" +
                "-3-------\n" +
                "-263--5--\n" +
                "5-37----8\n" +
                "47---1---";
        System.setIn(new ByteArrayInputStream(test.getBytes()));
    }

    private static int[][] matrix = new int[9][9];

    public static void main(String[] args) {
        fakeInput();
        InputReader reader = new InputReader();
        OutputWriter writer = new OutputWriter();
        for (int i = 0; i < 9; i++) {
            String[] rows = reader.readLine().split("");
            for (int j = 0; j < 9; j++) {
                if (rows[j].equals("-")) {
                    rows[j] = "0";
                }
                matrix[i][j] = Integer.parseInt(rows[j]);
            }
        }
        solveSudoku(0, 0, writer);
    }

    private static void printMatrix(int[][] result, OutputWriter writer) {
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                writer.print(result[i][j]);
            }
            writer.printLine();
        }
        writer.close();
    }

    private static void solveSudoku(int row, int col, OutputWriter writer) {
        if (row > 8) {
            printMatrix(matrix, writer);
            return;
        }

        if (matrix[row][col] == 0) {
            for (int k = 1; k < 10; k++) {              // 1..9
                if (isValid(k, row, col, matrix)) {
                    matrix[row][col] = k;
                    Coordinate next = findNext(row, col);
                    solveSudoku(next.row, next.col, writer);
                    matrix[row][col] = 0;
                }
            }
        } else {
            Coordinate next = findNext(row, col);
            solveSudoku(next.row, next.col, writer);
        }
    }

    private static Coordinate findNext(int row, int col) {
        if (col < 8) {
            return new Coordinate(row, col + 1);
        } else {
            return new Coordinate(row + 1, 0);
        }
    }

    private static boolean isValid(int value, int i, int j, int[][] matrix) {
        //Check Horizontal
        for (int k = 0; k < 9; k++) {
            if (value == matrix[i][k]) {
                return false;
            }
        }
        //Check Vertical
        for (int k = 0; k < 9; k++) {
            if (value == matrix[k][j]) {
                return false;
            }
        }
        //Check Square
        int rowSquare = (i / 3) * 3;
        int colSquare = (j / 3) * 3;
        for (int k = 0; k < 3; k++) {
            for (int m = 0; m < 3; m++) {
                if (value == matrix[rowSquare + k][colSquare + m]) {
                    return false;
                }
            }
        }
        return true;
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
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
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

    private static class Coordinate {
        int row;
        int col;

        Coordinate(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}