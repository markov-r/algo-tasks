import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        InputReader reader = new InputReader();
        OutputWriter writer = new OutputWriter();
        int n = reader.readInt();
        int m = reader.readInt();
        int[][] staMat = new int[n][m];
        int startRow = Integer.MIN_VALUE;
        int startCol = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                staMat[i][j] = reader.readInt();
                if (staMat[i][j] == 0) {
                    startRow = i;
                    startCol = j;
                }
            }
        }

        int result = collectCoins(staMat, startRow, startCol);
        System.out.println(result);
//        writer.printLine(result);
//        writer.close();



    }

    private static int collectCoins(int[][] staMat, int row, int col) {
        int nextRow;
        int nextCol;
        int count = 0;
        while (movePossible(staMat, row, col)) {
            Coordinate coordinate = findBiggestNeighbour(row, col, staMat);
            nextRow = coordinate.getRow();
            nextCol = coordinate.getColumn();
            if (staMat[row][col] > 0) {
                staMat[row][col]--;
            }
            count++;
            col = nextCol;
            row = nextRow;
        }
        return count;
    }

    static Coordinate findBiggestNeighbour(int row, int col, int[][] staMat) {
        int left, right, up, down;
        if (isInMatrix(row, col-1, staMat)) {
            left = staMat[row][col-1];
        }
        else left = Integer.MIN_VALUE;

        if (isInMatrix(row, col+1, staMat)) {
            right = staMat[row][col+1];
        }
        else right = Integer.MIN_VALUE;

        if (isInMatrix(row-1, col, staMat)) {
            up = staMat[row-1][col];
        }
        else up = Integer.MIN_VALUE;

        if (isInMatrix(row+1, col, staMat)) {
            down = staMat[row+1][col];
        }
        else down = Integer.MIN_VALUE;

        int max = Math.max(down, Math.max(up, Math.max(left, right)));

        if (left == max) {
            return new Coordinate(row, col-1);
        }
        if (right == max) {
            return new Coordinate(row, col+1);
        }
        if (up == max) {
            return new Coordinate(row-1, col);
        }
        if (down == max) {
            return new Coordinate(row+1, col);
        }
        return new Coordinate(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    static boolean movePossible(int[][] staMat, int curRow, int curCol) {
        boolean left = true;
        boolean right = true;
        boolean up = true;
        boolean down = true;

        if (!isInMatrix(curRow, curCol+1, staMat) || staMat[curRow][curCol+1] == 0) {
            right = false;
        }
        if (!isInMatrix(curRow, curCol-1, staMat) || staMat[curRow][curCol-1] == 0) {
            left = false;
        }
        if (!isInMatrix(curRow+1, curCol, staMat) || staMat[curRow+1][curCol] == 0) {
            down = false;
        }
        if (!isInMatrix(curRow-1, curCol, staMat) || staMat[curRow-1][curCol] == 0) {
            up = false;
        }
        return left || right || up || down;
    }

    static boolean isInMatrix (int row, int col, int[][] matrix) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[0].length;
    }



    static class Coordinate {

        private int r;
        private int c;

        Coordinate(int r, int c) {
            this.r = r;
            this.c = c;
        }

        int getRow() {
            return r;
        }

        int getColumn() {
            return c;
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