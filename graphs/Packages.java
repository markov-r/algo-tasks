import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        InputReader reader = new InputReader();
        OutputWriter writer = new OutputWriter();

        int n = reader.readInt();
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int a = reader.readInt();
            int b = reader.readInt();

            if (graph.containsKey(a)) {
                graph.get(a).add(b);
            } else {
                Set<Integer> newSet = new HashSet<>();
                newSet.add(b);
                graph.put(a, newSet);
            }
        }

        int m = reader.readInt();
        int[] packages = new int[m];
        for (int i = 0; i < m; i++) {
            packages[i] = reader.readInt();
            Set<Integer> mySet = new TreeSet<>();
            mySet.add(packages[i]);
            Map<Integer, Boolean> visited = new HashMap<>();
            breadthFS(packages[i], visited, mySet, graph);

            StringBuilder sb = new StringBuilder();
            for (Integer integer : mySet) {
                sb.append(integer).append(" ");
            }
            writer.printLine(sb.toString().trim());
        }
        writer.close();
    }

    private static void breadthFS(int start, Map<Integer, Boolean> visited, Set<Integer> mySet, Map<Integer, Set<Integer>> graph) {
        visited.put(start, true);
        mySet.add(start);
        Deque<Integer> deque = new LinkedList<>();
        deque.offer(start);
        while (!deque.isEmpty()) {
            int next = deque.poll();
            if (graph.containsKey(next)) {
                for (Integer i : graph.get(next)) {
                    if (!visited.containsKey(i) || !visited.get(i)) {
                        deque.offer(i);
                        mySet.add(i);
                        visited.put(i, true);
                    }
                }
            }
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