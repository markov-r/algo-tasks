import java.io.*;
import java.util.*;

import static java.lang.Math.log;

public class Main {

    private static void fakeInput() {
//        String test = "7 8 3\n" +
//                "4 1\n" +
//                "7 3\n" +
//                "1 6";
        String test = "4116 4121 282\n" +
                "934 1243\n" +
                "3711 1544\n" +
                "3889 3797\n" +
                "3654 604\n" +
                "1741 1842\n" +
                "2512 779\n" +
                "2153 1938\n" +
                "345 3569\n" +
                "2800 216\n" +
                "2096 4\n" +
                "3817 4117\n" +
                "2552 953\n" +
                "1317 2612\n" +
                "2561 552\n" +
                "3690 1052\n" +
                "2987 2882\n" +
                "2775 3759\n" +
                "624 3398\n" +
                "3189 2460\n" +
                "3203 4091\n" +
                "197 1826\n" +
                "3619 3183\n" +
                "2191 640\n" +
                "2729 2887\n" +
                "3267 2072\n" +
                "2215 4111\n" +
                "111 98\n" +
                "872 615\n" +
                "1893 1916\n" +
                "3002 2394\n" +
                "160 1762\n" +
                "3232 3864\n" +
                "1021 640\n" +
                "3507 1206\n" +
                "4076 3882\n" +
                "2886 21\n" +
                "3768 2887\n" +
                "1064 2127\n" +
                "3053 502\n" +
                "2269 615\n" +
                "2022 3208\n" +
                "4111 3009\n" +
                "2321 3229\n" +
                "2929 1889\n" +
                "3003 3126\n" +
                "3135 1080\n" +
                "2264 1589\n" +
                "969 1332\n" +
                "3081 1940\n" +
                "3425 4002\n" +
                "2937 2253\n" +
                "3615 428\n" +
                "1898 3502\n" +
                "2753 236\n" +
                "2569 3275\n" +
                "3519 710\n" +
                "2156 1770\n" +
                "1161 1604\n" +
                "3111 3731\n" +
                "2391 1463\n" +
                "2442 2367\n" +
                "3207 2522\n" +
                "3708 2590\n" +
                "452 2889\n" +
                "1696 38\n" +
                "2735 3982\n" +
                "235 4116\n" +
                "2544 3357\n" +
                "3883 3891\n" +
                "3757 1150\n" +
                "1227 3121\n" +
                "3362 263\n" +
                "3077 2101\n" +
                "266 1944\n" +
                "2470 928\n" +
                "3341 1324\n" +
                "831 1557\n" +
                "1645 3516\n" +
                "603 2049\n" +
                "542 167\n" +
                "1057 770\n" +
                "614 1192\n" +
                "1630 342\n" +
                "3414 390\n" +
                "1707 1861\n" +
                "2075 3670\n" +
                "1511 1785\n" +
                "1814 920\n" +
                "1831 1587\n" +
                "1881 1542\n" +
                "138 1488\n" +
                "3607 3097\n" +
                "2762 1555\n" +
                "1825 2485\n" +
                "1161 1252\n" +
                "2674 1622\n" +
                "777 3043\n" +
                "2658 1820\n" +
                "899 2396\n" +
                "1794 3078\n" +
                "735 386\n" +
                "825 596\n" +
                "2490 1825\n" +
                "197 3905\n" +
                "4050 3558\n" +
                "3496 2995\n" +
                "114 338\n" +
                "1256 1025\n" +
                "1906 3720\n" +
                "1075 1118\n" +
                "3243 2819\n" +
                "2701 2985\n" +
                "3489 797\n" +
                "626 1469\n" +
                "1550 1804\n" +
                "1657 1901\n" +
                "1017 774\n" +
                "2376 2682\n" +
                "1186 2957\n" +
                "2115 2483\n" +
                "2012 1357\n" +
                "58 1425\n" +
                "310 108\n" +
                "607 998\n" +
                "2029 3821\n" +
                "832 3286\n" +
                "67 3525\n" +
                "3679 145\n" +
                "492 2383\n" +
                "3503 2871\n" +
                "1931 2848\n" +
                "2451 1648\n" +
                "2455 2294\n" +
                "2026 1086\n" +
                "71 3193\n" +
                "1190 2502\n" +
                "3394 268\n" +
                "2822 2864\n" +
                "3040 489\n" +
                "582 281\n" +
                "2817 4093\n" +
                "2054 2011\n" +
                "297 1413\n" +
                "614 3332\n" +
                "2615 107\n" +
                "802 759\n" +
                "1717 711\n" +
                "494 3700\n" +
                "1863 2898\n" +
                "2703 2744\n" +
                "3107 3747\n" +
                "3029 4118\n" +
                "2984 947\n" +
                "2764 493\n" +
                "3078 3542\n" +
                "1489 2342\n" +
                "1540 2470\n" +
                "367 3611\n" +
                "3986 1783\n" +
                "129 472\n" +
                "2864 1077\n" +
                "780 436\n" +
                "285 1445\n" +
                "2388 1080\n" +
                "2602 4034\n" +
                "3900 3878\n" +
                "2887 3417\n" +
                "452 600\n" +
                "3665 3981\n" +
                "3251 192\n" +
                "2402 2220\n" +
                "3620 4059\n" +
                "3864 3349\n" +
                "1199 539\n" +
                "2282 1064\n" +
                "3682 748\n" +
                "118 2065\n" +
                "674 2451\n" +
                "501 600\n" +
                "3865 204\n" +
                "2909 3689\n" +
                "1266 2419\n" +
                "3535 1292\n" +
                "2487 386\n" +
                "22 1091\n" +
                "174 1746\n" +
                "1275 645\n" +
                "1184 3934\n" +
                "844 4020\n" +
                "3755 2403\n" +
                "3958 147\n" +
                "1442 3037\n" +
                "1280 2933\n" +
                "3290 3072\n" +
                "242 372\n" +
                "1701 37\n" +
                "1186 200\n" +
                "3874 219\n" +
                "826 2444\n" +
                "499 3687\n" +
                "2670 3313\n" +
                "3543 1474\n" +
                "2220 1884\n" +
                "2055 2022\n" +
                "2692 2121\n" +
                "1353 2051\n" +
                "3681 3781\n" +
                "1899 1000\n" +
                "241 3496\n" +
                "3327 1243\n" +
                "1214 3837\n" +
                "3593 2511\n" +
                "1508 3396\n" +
                "1751 77\n" +
                "2290 327\n" +
                "3502 4066\n" +
                "200 1613\n" +
                "3955 2145\n" +
                "1840 3111\n" +
                "1471 3550\n" +
                "881 1097\n" +
                "3458 424\n" +
                "2456 877\n" +
                "2279 1109\n" +
                "193 3518\n" +
                "399 3813\n" +
                "3170 2538\n" +
                "2988 2563\n" +
                "3582 2920\n" +
                "4094 1010\n" +
                "1119 1284\n" +
                "3005 742\n" +
                "1439 802\n" +
                "3133 2407\n" +
                "1361 291\n" +
                "1495 3497\n" +
                "1933 1733\n" +
                "1006 2780\n" +
                "3787 2248\n" +
                "2430 836\n" +
                "2214 1871\n" +
                "2868 3911\n" +
                "2102 3373\n" +
                "432 1206\n" +
                "857 691\n" +
                "1182 150\n" +
                "396 2322\n" +
                "3297 3388\n" +
                "552 864\n" +
                "1924 2765\n" +
                "1180 2662\n" +
                "2077 2102\n" +
                "2257 2904\n" +
                "1577 3367\n" +
                "2967 3616\n" +
                "3965 234\n" +
                "2963 1006\n" +
                "2479 3793\n" +
                "2403 655\n" +
                "3226 2529\n" +
                "3618 4014\n" +
                "1577 2793\n" +
                "4006 1402\n" +
                "3840 884\n" +
                "2428 199\n" +
                "1616 3911\n" +
                "2484 2951\n" +
                "3724 747\n" +
                "3045 1418\n" +
                "3130 571\n" +
                "2899 592\n" +
                "1411 1792\n" +
                "2390 246\n" +
                "1788 315\n" +
                "1719 2520\n" +
                "3713 747\n" +
                "3281 3212\n" +
                "155 1659\n" +
                "2865 946\n" +
                "428 1041\n" +
                "2486 195\n" +
                "3917 2269\n";
        System.setIn(new ByteArrayInputStream(test.getBytes()));
    }

    private static Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
    private static int NODES;

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        fakeInput();
        InputReader reader = new InputReader();
        OutputWriter writer = new OutputWriter();
        int n = reader.readInt();
        int m = reader.readInt();
        int b = reader.readInt();
        NODES = b + 2;                                      // beers + start + end
        Coordinate start = new Coordinate(0, 0);
        Coordinate end = new Coordinate(n - 1, m - 1);
        Map<Integer, Coordinate> intToCoord = new HashMap<>();
        intToCoord.put(0, start);
        intToCoord.put(b + 1, end);

        Map<Integer, Integer> startMap = new HashMap<>();
        for (int i = 1; i < b + 1; i++) {
            int bRow = reader.readInt();
            int bCol = reader.readInt();
            Coordinate curBeer = new Coordinate(bRow, bCol);
            startMap.put(i, bRow + bCol - 5);
            intToCoord.put(i, curBeer);

            Map<Integer, Integer> toEnd = new HashMap<>();
            int beerToEnd = Math.abs(end.row - bRow) + Math.abs(end.col - bCol);
            toEnd.put(b + 1, beerToEnd);
            graph.put(i, toEnd);
        }
        graph.put(0, startMap);

        for (int i = 1; i < b + 1; i++) {
            for (int j = 1; j < b + 1; j++) {
                if (i == j) {
                    continue;
                }
                Map<Integer, Integer> current = graph.get(i);
                int weight = Math.abs(intToCoord.get(i).row - intToCoord.get(j).row) + Math.abs(intToCoord.get(i).col - intToCoord.get(j).col) - 5;
                current.put(j, weight);
            }
        }
//        printGraph();

        writer.printLine(dijkstraSimple(0, NODES - 1));
//        writer.printLine(dijkstraBinaryHeap(0, NODES - 1));
//        writer.printLine(Main.dijkstraFibonacciHeap(0, NODES - 1));
        long elapsedTime = System.currentTimeMillis() - startTime;
        writer.printLine(elapsedTime);
        writer.close();
    }

    private static int dijkstraBinaryHeap(int start, int end) {
        int[] distances = new int[NODES];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[start] = 0;
        Set<Integer> visited = new HashSet<>();
        Queue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(node -> node.distance));
        queue.offer(new Node(start, 0));

        while (!queue.isEmpty()) {
            Node top = queue.poll();
            int topVertex = top.getVertex();

            if (topVertex == end) break;               //not affecting performance
            if (visited.contains(topVertex)) continue;
            visited.add(topVertex);
            if (graph.get(topVertex) == null) continue;
            for (Map.Entry<Integer, Integer> next : graph.get(topVertex).entrySet()) {
                int nextVertex = next.getKey();
                int nextWeight = next.getValue();
                int newDistance = distances[topVertex] + nextWeight;

                if (newDistance < distances[nextVertex]) {
                    distances[nextVertex] = newDistance;
                    queue.offer(new Node(nextVertex, newDistance));
                }
            }
        }
        return distances[end];
    }

    private static int dijkstraFibonacciHeap(int start, int end) {
        int[] distances = new int[NODES];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[start] = 0;
        Set<Integer> visited = new HashSet<>();
        Queue<Node> queue = new FibonacciHeap(Comparator.comparingInt(Node::getDistance));
        queue.offer(new Node(start, 0));

        while (!queue.isEmpty()) {
            Node top = queue.poll();
            int topVertex = top.getVertex();
            if (visited.contains(topVertex)) continue;

            visited.add(topVertex);
            if (graph.get(topVertex) == null) continue;
            for (Map.Entry<Integer, Integer> next : graph.get(topVertex).entrySet()) {
                int nextVertex = next.getKey();
                int nextWeight = next.getValue();
                int newDistance = distances[topVertex] + nextWeight;

                if (newDistance < distances[nextVertex]) {
                    distances[nextVertex] = newDistance;
                    queue.offer(new Node(nextVertex, newDistance));
                }
            }
        }
        return distances[end];
    }

    private static int dijkstraSimple(int start, int end) {
        int[] distances = new int[NODES];
        boolean[] used = new boolean[NODES];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[start] = 0;

        for (int i = 0; i < NODES; i++) {
            int cur = chooseNode(distances, used);
            used[cur] = true;
            for (int j = 0; j < NODES; j++) {
                if (!used[j]
                        && graph.get(cur).containsKey(j)
                        && graph.get(cur).get(j) != Integer.MAX_VALUE
                        && distances[j] > distances[cur] + graph.get(cur).get(j)) {
                    distances[j] = distances[cur] + graph.get(cur).get(j);
                }
            }
        }
        return distances[end];
    }

    private static int chooseNode(int[] distances, boolean[] used) {
        int min = Integer.MAX_VALUE;
        int minInd = -1;
        for (int i = 0; i < NODES; i++) {
            if (!used[i] && distances[i] < min) {
                min = distances[i];
                minInd = i;
            }
        }
        return minInd;
    }

    public static class Node {
        private int vertex;
        private int distance;

        Node(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }

        public int getVertex() {
            return vertex;
        }

        public void setVertex(int vertex) {
            this.vertex = vertex;
        }

        public int getDistance() {
            return distance;
        }

        public void setDistance(int distance) {
            this.distance = distance;
        }
    }



    static class Coordinate {
        int row;
        int col;

        Coordinate(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public int getRow() {
            return row;
        }

        public int getCol() {
            return col;
        }
    }

//    static void printGraph() {
//        for (Integer coordinate : graph.keySet()) {
//            System.out.println("------------");
//            System.out.println("From " + coordinate + " to: ");
//            for (Integer c2 : graph.get(coordinate).keySet()) {
//                System.out.println("Coordinate -> " + c2 + " weight - " + graph.get(coordinate).get(c2));
//            }
//        }
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
            return c == '\n' || c == '\r' || c == ',' || c == ' ' || c == '\t' || c == -1;
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

    public static final class FibonacciHeap<E>
            implements Queue<E> {

        /**
         * The <i>Phi</i> constant value.
         */
        private final double LOG_PHI = log((1 + Math.sqrt(5)) / 2);

        /**
         * A simple index of stored elements.
         */
        private final Set<E> elementsIndex = new HashSet<E>();

        /**
         * The comparator, or null if priority queue uses elements'
         * natural ordering.
         */
        private final Comparator<? super E> comparator;

        /**
         * The number of nodes currently in {@code H} is kept in {@code n[H]}.
         */
        private int size = 0;

        /**
         * {@code t(H)} the number of trees in the root list.
         */
        private int trees = 0;

        /**
         * {@code m(H)} the number of marked nodes in {@code H}.
         */
        private int markedNodes = 0;

        /**
         * The root of the tree containing a minimum key {@code min[H]}.
         */
        private FibonacciHeapNode<E> minimumNode;

        /**
         * Creates a {@link FibonacciHeap} that orders its elements according to their natural ordering.
         */
        public FibonacciHeap() {
            this(null);
        }

        /**
         * Creates a {@link FibonacciHeap} that orders its elements according to the specified comparator.
         *
         * @param comparator the comparator that will be used to order this queue.
         *                   If null, the natural ordering of the elements will be used.
         */
        public FibonacciHeap( /* @Nullable */Comparator<? super E> comparator) {
            this.comparator = comparator;
        }

        /**
         * Moves the target node in the {@code H} root nodes.
         *
         * @param node the node has to be moved in the {@code H} root nodes
         * @see #add(Object)
         * @see #consolidate()
         * @see #cut(FibonacciHeapNode, FibonacciHeapNode)
         */
        private void moveToRoot(FibonacciHeapNode<E> node) {
            // 8'  if min[H] = NIL
            if (isEmpty()) {
                // then min[H] <- x
                minimumNode = node;
            } else {
                // 7 concatenate the root list containing x with root list H
                node.getLeft().setRight(node.getRight());
                node.getRight().setLeft(node.getLeft());

                node.setLeft(minimumNode);
                node.setRight(minimumNode.getRight());
                minimumNode.setRight(node);
                node.getRight().setLeft(node);

                // 8''  if key[x] < key[min[H]]
                if (compare(node, minimumNode) < 0) {
                    // 9     then min[H] <- x
                    minimumNode = node;
                }
            }
        }

        /**
         * {@inheritDoc}
         *
         * <pre>FIB-HEAP-INSERT(H, x)
         * 1  degree[x] &larr; 0
         * 2  p[x] &larr; NIL
         * 3  child[x] &larr; NIL
         * 4  left[x] &larr; x
         * 5  right[x] &larr; x
         * 6  mark[x] &larr; FALSE
         * 7  concatenate the root list containing x with root list H
         * 8  if min[H] = NIL or key[x] &lt; key[min[H]]
         * 9     then min[H] &larr; x
         * 10  n[H] &larr; n[H] + 1</pre>
         */
        public boolean add(E e) {
            if (e == null) {
                throw new IllegalArgumentException("Null elements not allowed in this FibonacciHeap implementation.");
            }

            // 1-6 performed in the node initialization
            FibonacciHeapNode<E> node = new FibonacciHeapNode<E>(e);

            // 7-9 performed in the #moveToRoot( FibonacciHeapNode<E> ) method
            moveToRoot(node);

            // 10  n[H] <- n[H] + 1
            size++;

            elementsIndex.add(e);

            return true;
        }

        /**
         * {@inheritDoc}
         */
        public boolean addAll(Collection<? extends E> c) {
            for (E element : c) {
                add(element);
            }

            return true;
        }

        /**
         * {@inheritDoc}
         */
        public void clear() {
            minimumNode = null;
            size = 0;
            trees = 0;
            markedNodes = 0;
            elementsIndex.clear();
        }

        /**
         * {@inheritDoc}
         */
        public boolean contains(Object o) {
            if (o == null) {
                return false;
            }

            return elementsIndex.contains(o);
        }

        /**
         * {@inheritDoc}
         */
        public boolean containsAll(Collection<?> c) {
            if (c == null) {
                return false;
            }

            for (Object o : c) {
                if (!contains(o)) {
                    return false;
                }
            }

            return true;
        }

        /**
         * {@inheritDoc}
         */
        public boolean isEmpty() {
            return minimumNode == null;
        }

        /**
         * {@inheritDoc}
         */
        public Iterator<E> iterator() {
            throw new UnsupportedOperationException();
        }

        /**
         * {@inheritDoc}
         */
        public boolean remove(Object o) {
            throw new UnsupportedOperationException();
        }

        /**
         * {@inheritDoc}
         */
        public boolean removeAll(Collection<?> c) {
            throw new UnsupportedOperationException();
        }

        /**
         * {@inheritDoc}
         */
        public boolean retainAll(Collection<?> c) {
            throw new UnsupportedOperationException();
        }

        /**
         * {@inheritDoc}
         */
        public int size() {
            return size;
        }

        /**
         * {@inheritDoc}
         */
        public Object[] toArray() {
            throw new UnsupportedOperationException();
        }

        /**
         * {@inheritDoc}
         */
        public <T> T[] toArray(T[] a) {
            throw new UnsupportedOperationException();
        }

        /**
         * {@inheritDoc}
         */
        public E element() {
            if (isEmpty()) {
                throw new NoSuchElementException();
            }
            return peek();
        }

        /**
         * {@inheritDoc}
         */
        public boolean offer(E e) {
            return add(e);
        }

        /**
         * {@inheritDoc}
         */
        public E peek() {
            if (isEmpty()) {
                return null;
            }

            return minimumNode.getElement();
        }

        /**
         * {@inheritDoc}
         *
         * <pre>FIB-HEAP-EXTRACT-MIN(H)
         * 1  z &larr; min[H]
         * 2  if z &ne; NIL
         * 3      then for each child x of z
         * 4               do add x to the root list of H
         * 5                  p[x] &larr; NIL
         * 6           remove z from the root list of H
         * 7           if z = right[z]
         * 8              then min[H] &larr; NIL
         * 9              else min[H] &larr; right[z]
         * 10                   CONSOLIDATE(H)
         * 11           n[H] &larr; n[H] - 1
         * 12  return z</pre>
         */
        public E poll() {
            // 2  if z &ne; NIL
            if (isEmpty()) {
                return null;
            }

            // 1  z <- min[H]
            FibonacciHeapNode<E> z = minimumNode;
            int numOfKids = z.getDegree();

            FibonacciHeapNode<E> x = z.getChild();
            FibonacciHeapNode<E> tempRight;

            while (numOfKids > 0) {
                // 3  for each child x of z
                tempRight = x.getRight();

                // 4  do add x to the root list of H
                moveToRoot(x);

                // 5  p[x] <- NIL
                x.setParent(null);

                x = tempRight;
                numOfKids--;
            }

            // 6  remove z from the root list of H
            z.getLeft().setRight(z.getRight());
            z.getRight().setLeft(z.getLeft());

            // 7  if z = right[z]
            if (z == z.getRight()) {
                // 8  min[H] <- NIL
                minimumNode = null;
            } else {
                // 9  min[H] <- right[z]
                minimumNode = z.getRight();
                // 10  CONSOLIDATE(H)
                consolidate();
            }

            // 11  n[H] <- n[H] - 1
            size--;

            E minimum = z.getElement();
            elementsIndex.remove(minimum);
            // 12  return z
            return minimum;
        }

        /**
         * {@inheritDoc}
         */
        public E remove() {
            // FIB-HEAP-EXTRACT-MIN(H)

            if (isEmpty()) {
                throw new NoSuchElementException();
            }

            return poll();
        }

        /**
         * Implements the {@code CONSOLIDATE(H)} function.
         *
         * <pre>CONSOLIDATE(H)
         * 1 for i &larr; 0 to D(n[H])
         * 2      do A[i] &larr; NIL
         * 3 for each node w in the root list of H
         * 4      do x &larr; w
         * 5         d &larr; degree[x]
         * 6         while A[d] &ne; NIL
         * 7            do y &larr; A[d]
         * 8               if key[x] &gt; key[y]
         * 9                  then exchange x &harr; y
         * 10                FIB-HEAP-LINK(H,y,x)
         * 11                A[d] &larr; NIL
         * 12                d &larr; d + 1
         * 13         A[d] &larr; x
         * 14 min[H] &larr; NIL
         * 15 for i &larr; 0 to D(n[H])
         * 16      do if A[i] &ne; NIL
         * 17            then add A[i] to the root list of H
         * 18                 if min[H] = NIL or key[A[i]] &le; key[min[H]]
         * 19                    then min[H] &larr; A[i]</pre>
         */
        private void consolidate() {
            if (isEmpty()) {
                return;
            }

            // D( n[H] ) <= log_phi( n[H] )
            // -> log_phi( n[H] ) = log( n[H] ) / log( phi )
            // -> D( n[H] ) = log( n[H] ) / log( phi )
            int arraySize = ((int) Math.floor(log(size) / LOG_PHI));

            // 1  for i <- 0 to D(n[H])
            List<FibonacciHeapNode<E>> nodeSequence = new ArrayList<FibonacciHeapNode<E>>(arraySize);
            for (int i = 0; i < arraySize; i++) {
                // 2      do A[i] <- NIL
                nodeSequence.add(i, null);
            }

            int numRoots = 0;

            // 3  for each node x in the root list of H
            // 4  do x &larr; w
            FibonacciHeapNode<E> x = minimumNode;

            if (x != null) {
                numRoots++;
                x = x.getRight();

                while (x != minimumNode) {
                    numRoots++;
                    x = x.getRight();
                }
            }

            while (numRoots > 0) {
                // 5  d <- degree[x]
                int degree = x.getDegree();
                FibonacciHeapNode<E> next = x.getRight();

                // 6  while A[d] != NIL
                while (nodeSequence.get(degree) != null) {
                    // 7  do y <- A[d]
                    FibonacciHeapNode<E> y = nodeSequence.get(degree);

                    // 8  if key[x] > key[y]
                    if (compare(x, y) > 0) {
                        // 9  exchange x <-> y
                        FibonacciHeapNode<E> pointer = y;
                        y = x;
                        x = pointer;
                    }

                    // 10  FIB-HEAP-LINK(H,y,x)
                    link(y, x);

                    // 11  A[d] <- NIL
                    nodeSequence.set(degree, null);

                    // 12  d <- d + 1
                    degree++;
                }

                // 13  A[d] <- x
                nodeSequence.set(degree, x);

                x = next;
                numRoots--;
            }

            // 14  min[H] <- NIL
            minimumNode = null;

            // 15  for i <- 0 to D(n[H])
            for (FibonacciHeapNode<E> pointer : nodeSequence) {
                if (pointer == null) {
                    continue;
                }
                if (minimumNode == null) {
                    minimumNode = pointer;
                }

                // 16 if A[i] != NIL
                // We've got a live one, add it to root list.
                if (minimumNode != null) {
                    //  First remove node from root list.
                    moveToRoot(pointer);
                }
            }
        }

        /**
         * Implements the {@code FIB-HEAP-LINK(H, y, x)} function.
         *
         * <pre>FIB-HEAP-LINK(H, y, x)
         * 1  remove y from the root list of H
         * 2  make y a child of x, incrementing degree[x]
         * 3  mark[y]  FALSE</pre>
         *
         * @param y the node has to be removed from the root list
         * @param x the node has to to become fater of {@code y}
         */
        private void link(FibonacciHeapNode<E> y, FibonacciHeapNode<E> x) {
            // 1 remove y from the root list of H
            y.getLeft().setRight(y.getRight());
            y.getRight().setLeft(y.getLeft());

            y.setParent(x);

            if (x.getChild() == null) {
                // 2 make y a child of x, incrementing degree[x]
                x.setChild(y);
                y.setRight(y);
                y.setLeft(y);
            } else {
                y.setLeft(x.getChild());
                y.setRight(x.getChild().getRight());
                x.getChild().setRight(y);
                y.getRight().setLeft(y);
            }

            x.incraeseDegree();

            // 3 mark[y] <- FALSE
            y.setMarked(false);
            markedNodes++;
        }

        /**
         * Implements the {@code CUT(H,x,y)} function.
         *
         * <pre>CUT(H,x,y)
         * 1  remove x from the child list of y, decrementing degree[y]
         * 2  add x to the root list of H
         * 3  p[x] &larr; NIL
         * 4  mark[x] &larr; FALSE</pre>
         *
         * @param x the node has to be removed from {@code y} children
         * @param y the node has to be updated
         */
        private void cut(FibonacciHeapNode<E> x, FibonacciHeapNode<E> y) {
            // add x to the root list of H
            moveToRoot(x);

            // remove x from the child list of y, decrementing degree[y]
            y.decraeseDegree();
            // p[x] <- NIL
            x.setParent(null);

            // mark[x] <- FALSE
            x.setMarked(false);
            markedNodes--;
        }

        /**
         * Implements the {@code CASCADING-CUT(H,y)} function.
         *
         * <pre>CASCADING-CUT(H,y)
         * 1  z &larr; p[y]
         * 2  if z &ne; NIL
         * 3     then if mark[y] = FALSE
         * 4             then mark[y] &larr; TRUE
         * 5             else CUT(H,y,z)
         * 6                  CASCADING-CUT(H,z)</pre>
         *
         * @param y the target node to apply CASCADING-CUT
         */
        private void cascadingCut(FibonacciHeapNode<E> y) {
            // z <- p[y]
            FibonacciHeapNode<E> z = y.getParent();

            // if z != NIL
            if (z != null) {
                // if mark[y] = FALSE
                if (!y.isMarked()) {
                    // then mark[y]  TRUE
                    y.setMarked(true);
                    markedNodes++;
                } else {
                    // else CUT(H,y,z)
                    cut(y, z);
                    // CASCADING-CUT(H,z)
                    cascadingCut(z);
                }
            }
        }

        /**
         * The potential of Fibonacci heap {@code H} is then defined by
         * {@code t(H) + 2m(H)}.
         *
         * @return The potential of this Fibonacci heap.
         */
        public int potential() {
            return trees + 2 * markedNodes;
        }

        /**
         * Compare the given objects according to to the specified comparator if not null,
         * according to their natural ordering otherwise.
         *
         * @param o1 the first {@link FibonacciHeap} node to be compared
         * @param o2 the second {@link FibonacciHeap} node to be compared
         * @return a negative integer, zero, or a positive integer as the first argument is
         * less than, equal to, or greater than the second
         */
        private int compare(FibonacciHeapNode<E> o1, FibonacciHeapNode<E> o2) {
            if (comparator != null) {
                return comparator.compare(o1.getElement(), o2.getElement());
            }
            @SuppressWarnings("unchecked") // it will throw a ClassCastException at runtime
                    Comparable<? super E> o1Comparable = (Comparable<? super E>) o1.getElement();
            return o1Comparable.compareTo(o2.getElement());
        }

        /**
         * Creates a String representation of this Fibonacci heap.
         *
         * @return String of this.
         */
        public String toString() {
            if (minimumNode == null) {
                return "FibonacciHeap=[]";
            }

            // create a new stack and put root on it
            Stack<FibonacciHeapNode<E>> stack = new Stack<FibonacciHeapNode<E>>();
            stack.push(minimumNode);

            StringBuilder buf = new StringBuilder("FibonacciHeap=[");

            // do a simple breadth-first traversal on the tree
            while (!stack.empty()) {
                FibonacciHeapNode<E> curr = stack.pop();
                buf.append(curr);
                buf.append(", ");

                if (curr.getChild() != null) {
                    stack.push(curr.getChild());
                }

                FibonacciHeapNode<E> start = curr;
                curr = curr.getRight();

                while (curr != start) {
                    buf.append(curr);
                    buf.append(", ");

                    if (curr.getChild() != null) {
                        stack.push(curr.getChild());
                    }

                    curr = curr.getRight();
                }
            }

            buf.append(']');

            return buf.toString();
        }

    }

    static final class FibonacciHeapNode<E> {

        /**
         * The stored node value.
         */
        private final E element;

        /**
         * Reference to the parent node, if any.
         */
        private FibonacciHeapNode<E> parent;

        /**
         * {@code left[x]}.
         */
        private FibonacciHeapNode<E> left = this;

        /**
         * {@code right[x]}.
         */
        private FibonacciHeapNode<E> right = this;

        /**
         * Reference to the first child node.
         */
        private FibonacciHeapNode<E> child;

        /**
         * The number of children in the child list of node {@code x} is stored in {@code degree[x]}.
         */
        private int degree;

        /**
         * {@code mark[x]} indicates whether node {@code x} has lost a child since
         * the last time {@code x} was made the child of another node.
         */
        private boolean marked;

        /**
         * Build a new {@link FibonacciHeap} node with the given value.
         *
         * @param element the node value has to be stored.
         */
        public FibonacciHeapNode(E element) {
            // 1  degree[x] &larr; 0
            degree = 0;
            // 2  p[x] <- NIL
            setParent(null);
            // 3  child[x] <- NIL
            setChild(null);
            // 4  left[x] <- x
            setLeft(this);
            // 5  right[x] <- x
            setRight(this);
            // 6  mark[x] <- FALSE
            setMarked(false);

            // set the adapted element
            this.element = element;
        }

        /**
         * Returns the reference to the parent node, if any.
         *
         * @return the reference to the parent node, if any.
         */
        public FibonacciHeapNode<E> getParent() {
            return parent;
        }

        /**
         * Sets the reference to the parent node.
         *
         * @param parent the reference to the parent node
         */
        public void setParent(FibonacciHeapNode<E> parent) {
            this.parent = parent;
        }

        /**
         * Returns the left node reference.
         *
         * @return the left node reference.
         */
        public FibonacciHeapNode<E> getLeft() {
            return left;
        }

        /**
         * Sets the left node reference.
         *
         * @param left the left node reference.
         */
        public void setLeft(FibonacciHeapNode<E> left) {
            this.left = left;
        }

        /**
         * Returns the right node reference.
         *
         * @return the right node reference.
         */
        public FibonacciHeapNode<E> getRight() {
            return right;
        }

        /**
         * Sets the right node reference.
         *
         * @ param left the right node reference.
         */
        public void setRight(FibonacciHeapNode<E> right) {
            this.right = right;
        }

        /**
         * Returns the reference to the first child node.
         *
         * @return the reference to the first child node.
         */
        public FibonacciHeapNode<E> getChild() {
            return child;
        }

        /**
         * Sets the reference to the first child node.
         *
         * @param child the reference to the first child node.
         */
        public void setChild(FibonacciHeapNode<E> child) {
            this.child = child;
        }

        /**
         * Returns the number of children in the child list of node {@code x} is stored in {@code degree[x]}.
         *
         * @return the number of children in the child list of node {@code x} is stored in {@code degree[x]}.
         */
        public int getDegree() {
            return degree;
        }

        /**
         * Increases the degree of current node.
         *
         * @see #getDegree()
         */
        public void incraeseDegree() {
            degree++;
        }

        /**
         * Decreases the degree of current node.
         *
         * @see #getDegree()
         */
        public void decraeseDegree() {
            degree--;
        }

        /**
         * Returns the current node mark status.
         *
         * @return true, if the node is marked, false otherwise.
         */
        public boolean isMarked() {
            return marked;
        }

        /**
         * Flags the current node as marked.
         *
         * @param marked the current node mark status.
         */
        public void setMarked(boolean marked) {
            this.marked = marked;
        }

        /**
         * Returns the adapted element by this node.
         *
         * @return the adapted element by this node.
         */
        public E getElement() {
            return element;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public String toString() {
            return element.toString();
        }

    }

}