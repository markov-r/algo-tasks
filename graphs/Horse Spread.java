import java.io.*;
import java.util.*;

public class Main {

    static int [][] staMat;
    static boolean [][] visited;
    static int dRow[];
    static int dCol[];
    static int n;
    static int m;
    static int result[];

    public static void main(String[] args) {
        InputReader reader = new InputReader();
        OutputWriter writer = new OutputWriter();
        n = reader.readInt();
        m = reader.readInt();
        int row = reader.readInt();
        int col = reader.readInt();
        staMat = new int[n][m];
        visited = new boolean[n][m];
        result = new int [n];
        dRow = new int [] {-2, -2, -1, -1,  1, 1,  2, 2};
        dCol = new int [] {-1,  1, -2,  2, -2, 2, -1, 1};

        Queue<Coordinates> queue = new ArrayDeque<>();
        horseSteps (row, col, queue);
        for (int item: result) {
            writer.printLine(item);
        }
        writer.close();
    }

    static void horseSteps (int row, int col, Queue<Coordinates> queue){
            staMat[row][col] = 1;
            visited[row][col] = true;
            middleColumnCheck(row, col, 1);

            Coordinates pair = new Coordinates(row, col, 1);
            queue.offer(pair);

            while (!queue.isEmpty()) {
                Coordinates next = queue.poll();
                for (int i = 0; i < 8; i++) {
                    if (isInMatrix(next.getRow() + dRow[i], next.getCol() + dCol[i])
                            && !visited[next.getRow() + dRow[i]][next.getCol() + dCol[i]]) {

                        staMat[next.getRow() + dRow[i]][next.getCol() + dCol[i]] = next.getCount() + 1;
                        visited[next.getRow() + dRow[i]][next.getCol() + dCol[i]] = true;
                        Coordinates following = new Coordinates(next.getRow() + dRow[i],
                                next.getCol() + dCol[i],
                                next.getCount() + 1);
                        queue.offer(following);
                        MiddleColumnCheck(next.getRow() + dRow[i], next.getCol() + dCol[i], next.getCount() + 1);
                    }
                }
            }
//        System.out.println(Arrays.deepToString(staMat).replace("], ", "]\n"));
    }

    static boolean isInMatrix (int row, int col) {
        return row > -1 && col > -1 && row < n && col < m;
    }

    static void middleColumnCheck (int row, int col, int value) {
        if (col == m/2) {
            result[row] = value;
        }
    }

    static class Coordinates {
        private int row;
        private int col;
        private int count;

        Coordinates(int row, int col, int count) {
            this.row = row;
            this.col = col;
            this.count = count;
        }
        int getRow() {
            return row;
        }
        int getCol() {
            return  col;
        }
        int getCount() {
            return count;
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