import java.io.*;
import java.util.InputMismatchException;

public class Main {

    static int [][][] cuboid;

//    static void fakeInput() {
//        String test = "4 3 2\n" +
//                "0 0 0 0 | 0 0 0 0\n" +
//                "0 0 0 0 | 0 0 0 0\n" +
//                "0 0 0 0 | 0 0 0 0";
//        System.setIn(new ByteArrayInputStream(test.getBytes()));
//    }

    public static void main(String[] args) {
//        fakeInput();
        InputReader reader = new InputReader();
        OutputWriter writer = new OutputWriter();
        int w = reader.readInt();                   // w -> 4
        int h = reader.readInt();                   // h -> 2
        int d = reader.readInt();                   // d -> 3

        cuboid = new int[h][d][w];

        int totalSum = 0;
        int sumsHeight[] = new int[h];
        int sumsDepth[]  = new int[d];
        int sumsWidth[]  = new int[w];

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < d; j++) {
                for (int k = 0; k < w; k++) {
                    cuboid[i][j][k] = reader.readInt();
                    totalSum += cuboid[i][j][k];
                    sumsHeight[i] += cuboid[i][j][k];
                    sumsDepth[j] += cuboid[i][j][k];
                    sumsWidth[k] += cuboid[i][j][k];
                }
            }
        }

        int numOfElem = h * d * w;
        if (numOfElem > 1 && totalSum % 2 == 0) {
            int result = 0;

            int hSliceSums = 0;
            for (int i = 0; i < h - 1; i++) {
                hSliceSums += sumsHeight[i];
                if (hSliceSums == totalSum / 2) {
                    result++;
                }
            }

            int wSliceSums = 0;
            for (int i = 0; i < w - 1; i++) {
                wSliceSums += sumsWidth[i];
                if (wSliceSums == totalSum / 2) {
                    result++;
                }
            }

            int dSliceSums = 0;
            for (int i = 0; i < d - 1; i++) {
                dSliceSums += sumsDepth[i];
                if (dSliceSums == totalSum / 2) {
                    result++;
                }
            }

            writer.print(result);
            writer.close();
        }
        else {
            writer.printLine("0");
            writer.close();
        }


    }

//    public static void Print3DArray(int [][][] arr3D) {
//        for (int i = 0; i < arr3D.length; i++) {
//
//            if (i != arr3D.length - 1) {
//                System.out.println();
//            }
//            System.out.println("-------");
//            for (int x = 0; x < arr3D[i].length; x++) {
//                for (int j = 0; j < arr3D[i][x].length; j++) {
//                    System.out.print(arr3D[i][x][j] + " ");
//                }
//                    System.out.println();
//            }
//        }
//        System.out.println("-------");
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
            return c == '\n' || c == '\r' || c == ' ' || c == '\t' || c == -1 || c == '|';
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
