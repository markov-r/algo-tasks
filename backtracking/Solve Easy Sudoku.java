import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class Main {

//    static int STATIC_NUM = 1000;

    private static void fakeInput() {
        String test = "53--7----
											 6--195---
											 -98----6-
											 8---6---3
											 4--8-3--1
											 7---2---6
											 -6----28-
											 ---419--5
											 ----8--79";
        System.setIn(new ByteArrayInputStream(test.getBytes()));
    }

    public static void main(String[] args) {
        fakeInput();
        InputReader reader = new InputReader();
        OutputWriter writer = new OutputWriter();
        String [][] matrix = new String [9][9];
        for (int i = 0; i < 9; i++) {
            String[] rows = reader.readLine().split("");
            System.arraycopy(rows, 0, matrix[i], 0, 9);
        }
        List<String> digitsFilled = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            digitsFilled.add(String.valueOf(i+1));
        }

//        List<String> digits = new ArrayList<>(digitsFull);

        int countEmpty;
        do  {
            countEmpty = 0;
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (matrix[i][j].equals("-")) {
                        countEmpty++;
                        List<String> digits = new ArrayList<>(digitsFilled);
                        checkHorizontal(i, matrix, digits);
                        checkVertical(j, matrix, digits);
                        checkSquare(i, j, matrix, digits);
                        if (digits.size() == 1) {
//                            System.out.println(i + " " + j);
                            matrix[i][j] = digits.get(0);
                            countEmpty--;
                        }
                    }
                }
            }
//        System.out.println(countEmpty);
        } while (countEmpty > 0);


        for (String[] sArr : matrix) {
            for (String s : sArr) {
                writer.print(s);
            }
            writer.printLine();
        }
        writer.close();



    }

//    static int encode (int x, int y) {
//        int encoded = x * STATIC_NUM + y;
//        return encoded;
//    }

    private static void checkHorizontal(int i, String[][] matrix, List<String> digits) {
        for (int k = 0; k < 9; k++) {
            if (!matrix[i][k].equals("-")) {
                if (digits.contains(matrix[i][k])) {
                    digits.remove(matrix[i][k]);
                }
            }
        }
//        return digits;
    }

    private static void checkVertical (int j, String[][] matrix, List<String> digits) {
        for (int k = 0; k < 9; k++) {
            if (!matrix[k][j].equals("-")) {
                if (digits.contains(matrix[k][j])) {
                    digits.remove(matrix[k][j]);
                }
            }
        }
//        return digits;
    }

    private static void checkSquare(int i, int j, String[][] matrix, List<String> digits) {

        if (i >= 0 && i < 3 && j >= 0 && j < 3) {

            for (int k = 0; k < 3; k++) {
                for (int m = 0; m < 3; m++) {
                    if (!matrix[k][m].equals("-")) {
                        if (digits.contains(matrix[k][m])) {
                            digits.remove(matrix[k][m]);
                        }
                    }
                }
            }
        }

        if (i >= 0 && i < 3 && j >= 3 && j < 6) {

            for (int k = 0; k < 3; k++) {
                for (int m = 3; m < 6; m++) {
                    if (!matrix[k][m].equals("-")) {
                        if (digits.contains(matrix[k][m])) {
                            digits.remove(matrix[k][m]);
                        }
                    }
                }
            }
        }

        if (i >= 0 && i < 3 && j >= 6 && j < 9) {

            for (int k = 0; k < 3; k++) {
                for (int m = 6; m < 9; m++) {
                    if (!matrix[k][m].equals("-")) {
                        if (digits.contains(matrix[k][m])) {
                            digits.remove(matrix[k][m]);
                        }
                    }
                }
            }
        }

        if (i >= 3 && i < 6 && j >= 0 && j < 3) {

            for (int k = 3; k < 6; k++) {
                for (int m = 0; m < 3; m++) {
                    if (!matrix[k][m].equals("-")) {
                        if (digits.contains(matrix[k][m])) {
                            digits.remove(matrix[k][m]);
                        }
                    }
                }
            }
        }

        if (i >= 6 && i < 9 && j >= 0 && j < 3) {

            for (int k = 6; k < 9; k++) {
                for (int m = 0; m < 3; m++) {
                    if (!matrix[k][m].equals("-")) {
                        if (digits.contains(matrix[k][m])) {
                            digits.remove(matrix[k][m]);
                        }
                    }
                }
            }
        }

        if (i >= 3 && i < 6 && j >= 3 && j < 6) {

            for (int k = 3; k < 6; k++) {
                for (int m = 3; m < 6; m++) {
                    if (!matrix[k][m].equals("-")) {
                        if (digits.contains(matrix[k][m])) {
                            digits.remove(matrix[k][m]);
                        }
                    }
                }
            }
        }

        if (i >= 3 && i < 6 && j >= 6 && j < 9) {

            for (int k = 3; k < 6; k++) {
                for (int m = 6; m < 9; m++) {
                    if (!matrix[k][m].equals("-")) {
                        if (digits.contains(matrix[k][m])) {
                            digits.remove(matrix[k][m]);
                        }
                    }
                }
            }
        }


        if (i >= 6 && i < 9 && j >= 3 && j < 6) {

            for (int k = 6; k < 9; k++) {
                for (int m = 3; m < 6; m++) {
                    if (!matrix[k][m].equals("-")) {
                        if (digits.contains(matrix[k][m])) {
                            digits.remove(matrix[k][m]);
                        }
                    }
                }
            }
        }

        if (i >= 6 && i < 9 && j >= 6 && j < 9) {

            for (int k = 6; k < 9; k++) {
                for (int m = 6; m < 9; m++) {
                    if (!matrix[k][m].equals("-")) {
                        if (digits.contains(matrix[k][m])) {
                            digits.remove(matrix[k][m]);
                        }
                    }
                }
            }
        }
//        return digits;
    }




























// CUSTOM I/O CLASS

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
            return  c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
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