import java.io.*;
import java.util.InputMismatchException;

public class Main {

    public static void main(String[] args) {

        InputReader reader = new InputReader();
        OutputWriter writer = new OutputWriter();
        int n = reader.readInt();
        int m = reader.readInt();
//        int [][] aGay = new int [n][m];
        long sum = 0L;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j += 2) {
//                aGay[i][j] = 1 + 3*i + 3*j;
//                aGay[i][j+1] = 1 + 3*i + 3*(j+1);
                if (i % 2 == 0) {
                    sum += (long) 1 + 3*i + 3*j;
                    if (i != 0 && i != n - 1 && j != 0 && j != m - 1) {
                        sum += (long) 1 + 3*i + 3*j;
                    }
                }
                else {
                    sum += (long) 1 + 3*i + 3*(j+1);
                    if (i != 0 && i != n - 1 && (j+1) != 0 && (j+1) != m - 1) {
                        sum += (long) 1 + 3*i + 3*(j+1);
                    }
                }
            }
        }
        writer.printLine(sum);
        writer.close();
    }



//    public static long FindSum () {
//        long sum = 0;
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j += 2) {
//                aGay[i][j] = 1 + 3*i + 3*j;
//                aGay[i][j+1] = 1 + 3*i + 3*(j+1);
//                if (i % 2 == 0) {
//                    sum += (long) aGay[i][j];
//                    if (i != 0 && i != n - 1 && j != 0 && j != m - 1) {
////                if (!IsAtMatrixEdge(i, j)) {
//                        sum += (long) aGay[i][j];
//                    }
//                }
//                else {
//                    sum += (long) aGay[i][j+1];
//                    if (i != 0 && i != n - 1 && (j+1) != 0 && (j+1) != m - 1) {
////                if (!IsAtMatrixEdge(i, j+1)) {
//                        sum += (long) aGay[i][j+1];
//                    }
//                }
//            }
//        }
//        return sum;
//    }


//
//    public static void FindZigZagFields () {
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j+=2) {
//                if (i % 2 == 0) {
//                    marked[i][j] = true;
//                    marked[i][j+1] = false;
//                }
//                else {
//                    marked[i][j] = false;
//                    marked[i][j+1] = true;
//                }
//            }
//        }
//    }



//    public static boolean IsAtMatrixEdge (int row, int col) {
//        if (row == 0 || row == n - 1 || col == 0 || col == m - 1) {
//            return true;
//        }
//        else return false;
//    }

//    public static void FillMatrix() {
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                aGay[i][j] = 1 + 3*i + 3*j;
//            }
//        }
////        System.out.println(Arrays.deepToString(aGay).replace("], ", "]\n"));
//    }


//        long result = aGay[0][0];
//        int row = 0;
//        int col = 0;
//
//        result += GoRight(row, col).getSum();
//        int nextRow = GoRight(row, col).getRow();
//        int nextCol = GoRight(row, col).getColumn();
//        result += GoLeft(nextRow, nextCol).getSum();
//        row = GoLeft(nextRow, nextCol).getRow();
//        col = GoLeft(nextRow, nextCol).getColumn();




//    public static CoordinatesAndSum GoRight(int startRow, int startCol) {
//        long sum = 0;
//        for (int i = 1; i <= (m-2)/2; i++) {
//            startRow ++;                        // CYCLE RIGHT DOWN
//            startCol ++;
//            sum += aGay[startRow][startCol];
//
//            startRow --;                        // CYCLE RIGHT UP
//            startCol++;
//            sum += aGay[startRow][startCol];
//        }
//        startRow ++;                        // RIGHT DOWN ONCE AGAIN
//        startCol ++;
//        sum += aGay[startRow][startCol];
//        return new CoordinatesAndSum (startRow, startCol, sum);
//    }
//
//
//
//    public static CoordinatesAndSum GoLeft(int startRow, int startCol) {
//        long sum = 0;
//        for (int i = 1; i <= (m-2)/2; i++) {
//            startRow ++;                        // CYCLE LEFT DOWN
//            startCol --;
//            sum += aGay[startRow][startCol];
//
//            startRow --;                        // CYCLE LEFT UP
//            startCol--;
//            sum += aGay[startRow][startCol];
//        }
//        startRow ++;                        // LEFT DOWN ONCE AGAIN
//        startCol --;
//        sum += aGay[startRow][startCol];
//        return new CoordinatesAndSum (startRow, startCol, sum);
//    }
//
//
//
//
//
//
//
//    static class CoordinatesAndSum {
//
//        private int r;
//        private int c;
//        private long sumCl;
////        private ArrayList<Node> children;
//
//        CoordinatesAndSum(int r, int c, long sumCl) {
//            this.r = r;
//            this.c = c;
//            this.sumCl = sumCl;
////            children = new ArrayList<>();
//        }
////        void addChild(Node child) {
////            children.add(child);
////        }
//        int getRow() {
//            return r;
//        }
//        int getColumn() {
//            return  c;
//        }
//        long getSum() {
//            return sumCl;
//        }
//
//    }











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