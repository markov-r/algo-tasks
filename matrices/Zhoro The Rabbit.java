import java.io.*;
import java.util.InputMismatchException;


public class Main {


    public static void main(String[] args) {
        InputReader reader = new InputReader();
        OutputWriter writer = new OutputWriter();
        String numbersStr[] = reader.readLine().split(", ");
        int n = numbersStr.length;
        int [] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(numbersStr[i]);
        }

        int bestPath = 0;
        for (int startIndex = 0; startIndex < n; startIndex ++) {
            for (int step = 1; step < n; step ++) {

                int index = startIndex;
                int currentPath = 1;
                int next = index + step;
                if (next >= n) {
                next -= n;
                }
                while (numbers[index] < numbers[next]) {
                    currentPath ++;
                    index = next;
                    next = (index + step) % n;
//                    if (next >= n) {
//                        next -= n;
//                    }
                }
                    if (bestPath < currentPath) {
                    bestPath = currentPath;
                    }
            }
        }
        writer.printLine(bestPath);
        writer.close();
    }

// RECURSIVE SOLUTION
//
// public static int[] arr;
// public static int n;
// public static boolean[] visited;
//
// public static void main(String[] args) {
//     InputReader reader = new InputReader();
//     OutputWriter writer = new OutputWriter();
//     String numbers[] = reader.readLine().split(", ");
//     n = numbers.length;
//     arr = new int[n];
//
//     for (int i = 0; i < n; i++) {
//         arr[i] = Integer.parseInt(numbers[i]);
//     }
//
//     int maxJumps = 0;
//     for (int startPos = 0; startPos < n; startPos++) {
//         for (int step = 1; step < n; step++) {
//             visited = new boolean [n];
//             visited[startPos] = true;
//             int jumps = 1;
//             jumps = CheckJumps(startPos, step, jumps);
//             if (jumps > maxJumps) {
//                 maxJumps = jumps;
//             }
//         }
//     }
//     writer.printLine(maxJumps);
//     writer.close();
// }
//
// public static int CheckJumps(int startPos, int step, int jumps) {
//
//     int currInd = (startPos + step) % n;
//     if (arr[currInd] > arr[startPos] && !visited[currInd]) {
//         jumps ++;
//         visited[currInd] = true;
//         return CheckJumps(currInd, step, jumps);
//         } else {
//           return jumps;
//         }
//     }

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
            return c == '\n' || c == '\r' || c == '\t' || c == -1;
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

