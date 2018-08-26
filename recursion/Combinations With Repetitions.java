
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        InputReader reader = new InputReader();
        OutputWriter writer = new OutputWriter();
        int n = reader.readInt();
        int r = reader.readInt();
        List<Integer> combination = new ArrayList<>();
        for (int i = 0; i < r; i++) {
            combination.add(0);
        }
        combine(1, 0, combination, n, r, writer);
        writer.close();
    }

    public static void combine(int start, int index, List<Integer> combination, int n, int r, OutputWriter writer) {
        if (index == r) {
            print(combination, writer);
            return;
        }
        for (int i = start; i < n + 1; i++) {
            combination.set(index, i);
            combine(i, index + 1, combination, n, r, writer);
        }
    }

    public static void print(List<Integer> combination, OutputWriter writer) {
        for (int num : combination) {
            writer.print(num + " ");
        }
        writer.printLine();
    }






    public static class InputReader {
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

    public static class OutputWriter {
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


// OLD SOLUTION

//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//
//public class Main {
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//        String numbers[] = in.readLine().split(" ");
//        int broi = Integer.parseInt(numbers[0]);
//        int r = Integer.parseInt(numbers[1]);
//        int aGay [] = new int [broi];
//        for (int i = 0; i < broi; i++) {
//            aGay[i] = i + 1;
//        }
//        int n = broi;
//        CombinationRepetition(aGay, n, r);
//    }
//
//    static void CombinationRepetition(int aGay[], int n, int r) {
//        int chosen[] = new int [r+1];
//        CombinationRepetitionUtil(chosen, aGay, 0, r, 0, n-1);
//    }
//
//    static void CombinationRepetitionUtil(int chosen[], int aGay[], int index, int r, int start, int end) {
//        if (index == r) {
//            for (int i = 0; i < r; i++)
//            System.out.printf("%d ", aGay[chosen[i]]);
//            System.out.println();
//            return;
//        }
//
//        for (int i = start; i <= end; i++) {
//            chosen[index] = i;
//            CombinationRepetitionUtil(chosen, aGay, index + 1, r, i, end);
//        }
//    }
//}
//
//
//
//
