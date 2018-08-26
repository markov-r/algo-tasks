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
            combine(i + 1, index + 1, combination, n, r, writer);
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






//  SLOW SOLUTION
//
//import java.io.*;
//import java.util.*;
//
//public class Main {
//
////    private static InputReader reader = new InputReader();
////    private static OutputWriter writer = new OutputWriter();
//
//    public static void main(String[] args) {
//        int n = reader.readInt();
//        int r = reader.readInt();
//        List<Integer> combination = new ArrayList<>();
//        List<Set<Integer>> usedCombos = new ArrayList<>();
//        for (int i = 0; i < r; i++) {
//            combination.add(0);
//        }
//        combine(n, r, 0, combination, new HashSet<>(), usedCombos);
//        writer.close();
//    }
//
//    private static void combine(int n, int r, int index, List<Integer> combination, HashSet<Integer> used, List<Set<Integer>> usedCombos) {
//        if (index == r) {
//            Set<Integer> temp = new HashSet<>(combination);
//            if (!usedCombos.contains(temp)) {
//                usedCombos.add(temp);
//                for (Integer s : combination) {
//                    writer.print(s + " ");
//                }
//                writer.printLine();
//            }
//            return;
//        }
//        for (int i = 1; i < n + 1; i++) {
//            if (used.contains(i)) {
//                continue;
//            }
//            used.add(i);
//            combination.set(index, i);
//            combine(n, r, index + 1, combination, used, usedCombos);
//            used.remove(i);
//        }
//    }




//   ORIGINAL SOLUTION
//
//import java.io.*;
//public class Main {
//    public static void main(String[] args) throws IOException {
//        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//        String numbers[] = in.readLine().split(" ");
//        int n = Integer.parseInt(numbers[0]);
//        int r = Integer.parseInt(numbers[1]);
//        int[] arr = new int[n];
//        for (int i = 0; i < n; i++) {
//            arr[i] = i + 1;
//        }
//        int data[] = new int[r];
//        CombinationGenerate(arr, data, 0, n - 1, 0, r);
//    }
//
//    public static void CombinationGenerate(int arr[], int data[], int start, int end, int index, int r) {
//        if (index == r) {
//            for (int i = 0; i < r; i++) {
//              System.out.print(data[i] + " ");
//              System.out.println();
//            }
//            return;
//        }
//        for (int i = start; i <= end && end - i + 1 >= r - index; i++) {
//            data[index] = arr[i];
//            CombinationGenerate(arr, data, i + 1, end, index + 1, r);
//        }
//    }
//}
