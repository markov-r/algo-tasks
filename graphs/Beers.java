import java.io.*;
import java.util.*;

public class Main {

    private static void fakeInput() {
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
//        String test = "7 8 3\n" +
//                "4 1\n" +
//                "7 3\n" +
//                "1 6";
        System.setIn(new ByteArrayInputStream(test.getBytes()));
    }

    private static int[][] graph;
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
        graph = new int[NODES][NODES];
        for (int i = 0; i < NODES; i++) {
            for (int j = 0; j < NODES; j++) {
                graph[i][j] = Integer.MAX_VALUE;
            }
        }

        Coordinate start = new Coordinate(0, 0);
        Coordinate end = new Coordinate(n - 1, m - 1);
        Map<Integer, Coordinate> numToCoordinate = new HashMap<>();
        numToCoordinate.put(0, start);
        numToCoordinate.put(b + 1, end);

        for (int i = 1; i < b + 1; i++) {
            int bRow = reader.readInt();
            int bCol = reader.readInt();
            Coordinate curBeer = new Coordinate(bRow, bCol);
            numToCoordinate.put(i, curBeer);
            graph[i][0] = graph[0][i] = Math.abs(0 - bRow) + Math.abs(0 - bCol) - 5;
            graph[NODES - 1][i] = graph[i][NODES - 1] = Math.abs(n - 1 - bRow) + Math.abs(m - 1 - bCol);
        }

        for (int i = 1; i < b + 1; i++) {
            for (int j = 1; j < b + 1; j++) {
                int weight = Math.abs(numToCoordinate.get(i).row - numToCoordinate.get(j).row) +
                        Math.abs(numToCoordinate.get(i).col - numToCoordinate.get(j).col) - 5;
                graph[i][j] = weight;
            }
        }

        writer.printLine(dijkstraSimple(0, NODES - 1));
        long elapsedTime = System.currentTimeMillis() - startTime;
        writer.printLine("Elapsed time is " + elapsedTime + "ms.");
        writer.close();
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
                        && graph[cur][j] != Integer.MAX_VALUE
                        && distances[j] > distances[cur] + graph[cur][j]) {
                    distances[j] = distances[cur] + graph[cur][j];
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
}