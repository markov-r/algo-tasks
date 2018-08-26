import java.io.*;
import java.util.InputMismatchException;

public class Main {

    public static int n;
    static int[][] matrix;

    public static void main(String[] args) throws IOException {

        InputReader reader = new InputReader();
        OutputWriter writer = new OutputWriter();
//        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//        n = Integer.parseInt(in.readLine());
        n = reader.readInt();
        matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
//            String[] strIn = in.readLine().split(" ");
            for (int j = 0; j < n; j++) {
//                matrix[i][j] = Integer.parseInt(strIn[j]);
                matrix[i][j] = reader.readInt();
            }
        }

        int sum = 0;

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {

                switch (matrix[row][col]) {
                    case 1:
                        if (CheckForOne(row, col)) sum += 1; break;
                    case 2:
                        if (CheckForTwo(row, col)) sum += 2; break;
                    case 3:
                        if (CheckForThree(row, col)) sum += 3; break;
                    case 4:
                        if (CheckForFour(row, col)) sum += 4; break;
                    case 5:
                        if (CheckForFive(row, col)) sum += 5; break;
                    case 6:
                        if (CheckForSix(row, col)) sum += 6; break;
                    case 7:
                        if (CheckForSeven(row, col)) sum += 7; break;
                    case 8:
                        if (CheckForEight(row, col)) sum += 8; break;
                    case 9:
                        if (CheckForNine(row, col)) sum += 9;
                }
            }
        }
//        System.out.println(sum);
        writer.printLine(sum);
        writer.close();
    }

    private static boolean CheckForOne(int row, int col) {
        return row < n - 4 && col >= 2 && col < n &&
                matrix[row][col] == 1 &&
                matrix[row + 1][col - 1] == 1 &&
                matrix[row + 2][col - 2] == 1 &&
                matrix[row + 1][col] == 1 &&
                matrix[row + 2][col] == 1 &&
                matrix[row + 3][col] == 1 &&
                matrix[row + 4][col] == 1;
    }

    private static boolean CheckForTwo(int row, int col) {
        return row < n - 4 && col >= 1 && col < n - 1 &&
                matrix[row][col] == 2 &&
                matrix[row + 1][col - 1] == 2 &&
                matrix[row + 1][col + 1] == 2 &&
                matrix[row + 2][col + 1] == 2 &&
                matrix[row + 3][col] == 2 &&
                matrix[row + 4][col - 1] == 2 &&
                matrix[row + 4][col] == 2 &&
                matrix[row + 4][col + 1] == 2;
    }

    private static boolean CheckForThree(int row, int col) {

        return row < n - 4 && col >= 2 && col < n &&
                matrix[row][col] == 3 &&
                matrix[row][col - 1] == 3 &&
                matrix[row][col - 2] == 3 &&
                matrix[row + 1][col] == 3 &&
                matrix[row + 2][col] == 3 &&
                matrix[row + 2][col - 1] == 3 &&
                matrix[row + 3][col] == 3 &&
                matrix[row + 4][col] == 3 &&
                matrix[row + 4][col - 1] == 3 &&
                matrix[row + 4][col - 2] == 3;
    }

    private static boolean CheckForFour(int row, int col) {

        return row < n - 4 && col >= 2 && col < n &&
                matrix[row][col] == 4 &&
                matrix[row + 1][col] == 4 &&
                matrix[row + 2][col] == 4 &&
                matrix[row + 2][col - 1] == 4 &&
                matrix[row + 2][col - 2] == 4 &&
                matrix[row + 1][col - 2] == 4 &&
                matrix[row][col - 2] == 4 &&
                matrix[row + 3][col] == 4 &&
                matrix[row + 4][col] == 4;

    }

    private static boolean CheckForFive(int row, int col) {

        return row < n - 4 && col >= 2 && col < n &&
                matrix[row][col] == 5 &&
                matrix[row][col - 1] == 5 &&
                matrix[row][col - 2] == 5 &&
                matrix[row + 1][col - 2] == 5 &&
                matrix[row + 2][col - 2] == 5 &&
                matrix[row + 2][col - 1] == 5 &&
                matrix[row + 2][col] == 5 &&
                matrix[row + 3][col] == 5 &&
                matrix[row + 4][col] == 5 &&
                matrix[row + 4][col - 1] == 5 &&
                matrix[row + 4][col - 2] == 5;
    }

    private static boolean CheckForSix(int row, int col) {

        return row < n - 4 && col >= 2 && col < n &&
                matrix[row][col] == 6 &&
                matrix[row][col - 1] == 6 &&
                matrix[row][col - 2] == 6 &&
                matrix[row + 1][col - 2] == 6 &&
                matrix[row + 2][col - 2] == 6 &&
                matrix[row + 3][col - 2] == 6 &&
                matrix[row + 4][col - 2] == 6 &&
                matrix[row + 4][col - 1] == 6 &&
                matrix[row + 4][col] == 6 &&
                matrix[row + 3][col] == 6 &&
                matrix[row + 2][col] == 6 &&
                matrix[row + 2][col - 1] == 6;
    }

    private static boolean CheckForSeven(int row, int col) {

        return row < n - 4 && col < n - 2 &&
                matrix[row][col] == 7 &&
                matrix[row][col + 1] == 7 &&
                matrix[row][col + 2] == 7 &&
                matrix[row + 1][col + 2] == 7 &&
                matrix[row + 2][col + 1] == 7 &&
                matrix[row + 3][col + 1] == 7 &&
                matrix[row + 4][col + 1] == 7;
    }

    private static boolean CheckForEight (int row, int col) {

        return row < n - 4 && col < n - 2 &&
                matrix[row][col]         == 8 &&
                matrix[row][col+1]       == 8 &&
                matrix[row][col+2]       == 8 &&
                matrix[row+1][col+2]     == 8 &&
                matrix[row+2][col+1]     == 8 &&
                matrix[row+3][col]       == 8 &&
                matrix[row+4][col]       == 8 &&
                matrix[row+4][col+1]     == 8 &&
                matrix[row+4][col+2]     == 8 &&
                matrix[row+3][col+2]     == 8 &&
                matrix[row+1][col]       == 8;
    }

    private static boolean CheckForNine (int row, int col) {

        return row >= 0 && col >= 0 && row < n - 4 && col < n - 2 &&
                    matrix[row][col] == 9 &&
                    matrix[row][col + 1] == 9 &&
                    matrix[row][col + 2] == 9 &&
                    matrix[row + 1][col + 2] == 9 &&
                    matrix[row + 2][col + 2] == 9 &&
                    matrix[row + 2][col + 1] == 9 &&
                    matrix[row + 1][col] == 9 &&
                    matrix[row + 3][col + 2] == 9 &&
                    matrix[row + 4][col + 2] == 9 &&
                    matrix[row + 4][col + 1] == 9 &&
                    matrix[row + 4][col] == 9;

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