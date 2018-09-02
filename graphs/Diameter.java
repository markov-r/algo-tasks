import java.io.*;
import java.util.*;

public class Main {

    private static Map<Integer, List<Vertice>> graph = new HashMap<>();
    private static long maxLen;
    private static int bestNode;

    public static void main(String[] args) {
        InputReader reader = new InputReader();
        OutputWriter writer = new OutputWriter();
        int numOfVertices = reader.readInt();
        int first = -1;
        for (int j = 0; j < numOfVertices - 1; j++) {
            first = reader.readInt();
            int second = reader.readInt();
            int weight = reader.readInt();

            List<Vertice> list;
            if (graph.containsKey(first)) {
                list = graph.get(first);
            } else {
                list = new ArrayList<>();
            }
            list.add(new Vertice(second, weight));
            graph.put(first, list);

            List<Vertice> listSec;
            if (graph.containsKey(second)) {
                listSec = graph.get(second);
            } else {
                listSec = new ArrayList<>();
            }
            listSec.add(new Vertice(first, weight));
            graph.put(second, list);

        }

//        printGraph();

        bestNode = -1;
        maxLen = -1;
        depthFirstSearch(first, -1, 0L);
//        breadthFirstSearch(0, -1, 0);
        maxLen = -1;
//        breadthFirstSearch(bestNode, -1, 0);
        depthFirstSearch(bestNode, -1, 0L);
        writer.printLine(maxLen);
        writer.close();
//        System.out.print(maxLen);
    }

    private static void printGraph() {
        for (Integer integer : graph.keySet()) {
            for (Vertice vertice : graph.get(integer)) {
                System.out.println(integer + " => " + vertice.outgoing + " W: " + vertice.weight);
            }
        }
    }

    private static void depthFirstSearch(int start, int prev, long curLen) {
        if (graph.containsKey(start)) {
            for (Vertice vert : graph.get(start)) {
                int next = vert.getOutgoing();
                if (next != prev) {
                    curLen += (long) vert.getWeight();
                    depthFirstSearch(next, start, curLen);
                    curLen -= (long) vert.getWeight();
                }
            }
        }
        if (curLen > maxLen) {
            maxLen = curLen;
            bestNode = start;
        }
    }

    private static void breadthFirstSearch(int start, int prev, long curLen) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        while (!queue.isEmpty()) {
            int next = queue.poll();
            prev = start;
            if (graph.containsKey(next) && next != prev) {
                for (Vertice vertice : graph.get(next)) {
                    queue.offer(vertice.getOutgoing());
                    curLen += (long) vertice.getWeight();
                    start = next;
                }
            }
            if (curLen > maxLen) {
                maxLen = curLen;
                bestNode = start;
            }
        }

    }

    private static class Vertice {
        int outgoing;
        int weight;

        public Vertice(int outgoing, int weight) {
            this.outgoing = outgoing;
            this.weight = weight;
        }

        public int getOutgoing() {
            return outgoing;
        }

        public int getWeight() {
            return weight;
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
