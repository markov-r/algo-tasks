import java.io.*;
import java.util.*;

public class Main {
    static class Edge {
        int source;
        int destination;
        int weight;

        Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    static class Graph {
        int vertices;
        ArrayList<Edge> allEdges = new ArrayList<>();

        Graph(int vertices) {
            this.vertices = vertices;
        }

        void addEgde(int source, int destination, int weight) {
            Edge edge = new Edge(source, destination, weight);
            allEdges.add(edge);
        }

        List<Edge> kruskalMST() {
            Comparator<Edge> comparator = new IntReverseComparator();
//            PriorityQueue<Edge> pq = new PriorityQueue<>(allEdges.size(), Comparator.comparingInt(o -> o.weight));
            PriorityQueue<Edge> pq = new PriorityQueue<Edge>(allEdges.size(), comparator);
            pq.addAll(allEdges);
            int[] parent = new int[vertices + 1];
            for (int i = 1; i < vertices + 1; i++) {
                parent[i] = i;
            }
            List<Edge> mst = new ArrayList<>();
            int index = 0;
            while (index < vertices - 1) {                        // process vertices - 1 edges
                Edge edge = pq.remove();
                int x_set = find(parent, edge.source);
                int y_set = find(parent, edge.destination);

                if (x_set != y_set) {   // check for cycle
                    mst.add(edge);
                    index++;
                    union(parent, x_set, y_set);
                }
            }
//            System.out.println("Maximum Spanning Tree: ");
//            printGraph(mst);
            return mst;
        }

        int find(int[] parent, int vertex) {                      // chain of parent pointers from x upwards through the tree
            if (parent[vertex] != vertex) {                       // until an element is reached whose parent is itself
                return find(parent, parent[vertex]);
            }
            return vertex;
        }

        void union(int[] parent, int x, int y) {
            int x_set_parent = find(parent, x);
            int y_set_parent = find(parent, y);
            //make x as parent of y
            parent[y_set_parent] = x_set_parent;
        }

        void printGraph(List<Edge> edgeList) {
            for (int i = 0; i < edgeList.size(); i++) {
                Edge edge = edgeList.get(i);
                System.out.println("Edge-" + i + " source: " + edge.source +
                        " destination: " + edge.destination +
                        " weight: " + edge.weight);
            }
        }

        int findSmallestEdge(List<Edge> edgeList) {
            int min = Integer.MAX_VALUE;
            for (Edge edge : edgeList) {
                if (edge.weight < min) min = edge.weight;
            }
            return min;
        }

        private class IntReverseComparator implements Comparator<Edge> {
            @Override
            public int compare(Edge e1, Edge e2) {
                return Integer.compare(e2.weight, e1.weight);
            }
        }
    }

    private static void fakeInput() {
        String test = "10 42\n" +
                "5 2 92\n" +
                "2 9 42\n" +
                "2 7 94\n" +
                "4 2 17\n" +
                "6 2 66\n" +
                "2 3 77\n" +
                "10 2 47\n" +
                "8 2 75\n" +
                "9 5 86\n" +
                "5 7 93\n" +
                "1 5 35\n" +
                "4 5 38\n" +
                "6 5 7\n" +
                "3 5 100\n" +
                "10 5 9\n" +
                "8 5 98\n" +
                "9 7 61\n" +
                "1 9 52\n" +
                "9 4 64\n" +
                "9 6 98\n" +
                "3 9 37\n" +
                "10 9 99\n" +
                "9 8 43\n" +
                "7 1 45\n" +
                "4 7 74\n" +
                "7 6 5\n" +
                "3 7 25\n" +
                "10 7 67\n" +
                "8 7 60\n" +
                "1 4 53\n" +
                "6 1 40\n" +
                "3 1 100\n" +
                "1 8 66\n" +
                "4 6 84\n" +
                "4 3 17\n" +
                "4 10 22\n" +
                "4 8 63\n" +
                "6 3 99\n" +
                "6 10 22\n" +
                "6 8 26\n" +
                "3 8 55\n" +
                "10 8 80";
        System.setIn(new ByteArrayInputStream(test.getBytes()));
    }

    public static void main(String[] args) {
        fakeInput();
        InputReader reader = new InputReader();
        int vertices = reader.readInt();
        int edges = reader.readInt();
        Graph graph = new Graph(vertices);
        for (int i = 0; i < edges; i++) {
            int source = reader.readInt();
            int destination = reader.readInt();
            int weight = reader.readInt();
            graph.addEgde(source, destination, weight);
            graph.addEgde(destination, source, weight);
        }
        List<Edge> maxST = graph.kruskalMST();
        int highestTruck = graph.findSmallestEdge(maxST);
        System.out.println(highestTruck);
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
            return c == '\n' || c == '\r' || c == ',' || c == '\t' || c == -1 || c == ' ';
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