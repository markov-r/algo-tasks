import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    static class Graph {

        private Map<Integer, ArrayList<Node>> adjList;

        Graph() {
            adjList = new HashMap<>();
        }

        static class Node {
            private int vertex;
            private int weight;

            Node(int vertex, int weight) {
                this.vertex = vertex;
                this.weight = weight;
            }
        }

        void addNode(int vertex) {
            adjList.put(vertex, new ArrayList<>());
        }


        void addEdge(int x, int y, int weight) {
            if (!adjList.containsKey(x)) {
                addNode(x);
            }
            if (!adjList.containsKey(y)) {
                addNode(y);
            }

            addDirectedEdge(x, y, weight);
            addDirectedEdge(y, x, weight);
        }

        void addDirectedEdge(int from, int to, int weight) {
            ArrayList<Node> neighbours = adjList.get(from);
            neighbours.add(new Node(to, weight));
        }

        int getBestPaths(int from, int to, int m1, int m2) {
            List<Integer> fromDist = getShortestPaths(from,adjList.keySet().size() + 1);
            List<Integer> toDist = getShortestPaths(to,adjList.keySet().size() + 1);
            List<Integer> m1Dist = getShortestPaths(m1,adjList.keySet().size() + 1);
            List<Integer> m2Dist = getShortestPaths(m2,adjList.keySet().size() + 1);
            return Math.min(fromDist.get(m1) + m1Dist.get(m2) + toDist.get(m2),
                    fromDist.get(m2) + toDist.get(m1) + m2Dist.get(m1));
        }


        List<Integer> getShortestPaths(int from, int n) {
            Queue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(node -> node.weight));
            List<Integer> distances = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                distances.add(Integer.MAX_VALUE);
            }
            distances.set(from, 0);
            queue.offer(new Node(from, 0));

            while (!queue.isEmpty()) {
                Node top = queue.poll();
                for (Node node : adjList.get(top.vertex)) {
                    int newDist = distances.get(top.vertex) + node.weight;
                    if (distances.get(node.vertex) > newDist) {
                        distances.set(node.vertex, newDist);
                        queue.offer(node);
                    }
                }
            }
            return distances;
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph();
        OutputWriter writer = new OutputWriter();
        InputReader reader = new InputReader();
        int numOfCities = reader.readInt();
        int numOfConnections = reader.readInt();
        int startCity = reader.readInt();
        int endCity = reader.readInt();
        int middle1 = reader.readInt();
        int middle2 = reader.readInt();

        for (int i = 0; i < numOfConnections; i++) {
            int from = reader.readInt();
            int to = reader.readInt();
            int weight = reader.readInt();
            graph.addEdge(from, to, weight);
        }

        int result = graph.getBestPaths(startCity, endCity, middle1, middle2);
        writer.printLine(result);
        writer.close();
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

        boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
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


// OLD NOT CORRECT
//import java.io.*;
//import java.util.*;
//
//public class Main {
//
//   private static int[][] graph;
//   private static int cities;
//   private static int startC;
//   private static int endC;
//   private static int medOne;
//   private static int medTwo;
//   private static List<Edge> startSet;
//   private static List<Edge> endSet;
//   private static List<Edge> medOneSet;
//   private static List<Edge> medTwoSet;
//   private static int INF = 99999999;
//
//   public static void main(String[] args) throws IOException {
//       BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//       String[] firstRow = in.readLine().split(" ");
//       cities = Integer.parseInt(firstRow[0]);
//       int connections = Integer.parseInt(firstRow[1]);
//       graph = new int[cities + 1][cities + 1];
//       String[] secRow = in.readLine().split(" ");
//       startC = Integer.parseInt(secRow[0]);
//       endC = Integer.parseInt(secRow[1]);
//       String[] thirdRow = in.readLine().split(" ");
//       medOne = Integer.parseInt(thirdRow[0]);
//       medTwo = Integer.parseInt(thirdRow[1]);
//
//       startSet = new LinkedList<>();
//       endSet = new LinkedList<>();
//       medOneSet = new LinkedList<>();
//       medTwoSet = new LinkedList<>();
//
//       for (int i = 1; i < cities + 1; i++) {
//           for (int j = 1; j < cities + 1; j++) {
//               if (i == j) {
//                   graph[i][j] = 0;
//               } else {
//                   graph[i][j] = INF;
//               }
//           }
//       }
//
//       for (int i = 0; i < connections; i++) {
//           String[] nextRow = in.readLine().split(" ");
//           int source = Integer.parseInt(nextRow[0]);
//           int target = Integer.parseInt(nextRow[1]);
//           int weight = Integer.parseInt(nextRow[2]);
//           graph[source][target] = weight;
//           graph[target][source] = weight;
//
//           Edge edge1 = new Edge(source, target, weight);
//
//           if (source == startC || target == startC) {
////                Edge edge2 = new Edge(target, source, weight);
//                startSet.add(edge1);
//                startSet.add(edge2);
//            }
//            if (source == endC || target == endC) {
////                Edge edge2 = new Edge(target, source, weight);
//                endSet.add(edge1);
////                endSet.add(edge2);
//            }
//            if (source == medOne || target == medOne) {
////                Edge edge2 = new Edge(target, source, weight);
//                medOneSet.add(edge1);
////                medOneSet.add(edge2);
//            }
//            if (source == medTwo || target == medTwo) {
////                Edge edge2 = new Edge(target, source, weight);
//                medTwoSet.add(edge1);
////                medTwoSet.add(edge2);
//            }
//        }
//
////        System.out.println("start contains: ");
////        printSet(startSet);
////        System.out.println("med1 contains: ");
////        printSet(medOneSet);
////        System.out.println("med2 contains: ");
////        printSet(medTwoSet);
////        System.out.println("end contains: ");
////        printSet(endSet);
//        int startToMedOne = findStartToMedOne();
//        int startToMedTwo = findStartToMedTwo();
//        int medToMed = findMedToMed();
//        int medOneToEnd = findMedOneToEnd();
//        int medTwoToEnd = findMedTwoToEnd();
////        StringBuilder sb = new StringBuilder();
////        sb.append(startToMedOne).append("! ");
////        sb.append(startToMedTwo).append(" ");
////        sb.append(medToMed).append(" ");
////        sb.append(medOneToEnd).append(" ");
////        sb.append(medTwoToEnd).append("! ");
////        System.out.println(sb);
//        int pathOne = startToMedOne + medToMed + medTwoToEnd;
//        int pathTwo = startToMedTwo + medToMed + medOneToEnd;
////        System.out.println(pathOne + " " + pathTwo);
//        System.out.println(Math.min(pathOne, pathTwo));
//    }
//
//  private static void printSet(List<Edge> set) {
//      for (Edge edge : set) {
//          System.out.println(edge.source + " " + edge.target + " " + edge.weight + "!");
//      }
//  }
//
//  private static int findMedToMed() {
//      removeStartEdges();
//      removeEndEdges();
//      int result = dijkstraFindMinPath(medOne, medTwo);
//      recoverStartEdges();
//      recoverEndEdges();
//      return result;
//  }
//
//  private static int findMedOneToEnd() {
//      removeStartEdges();
//      removeMedTwoEdges();
//      int result = dijkstraFindMinPath(medOne, endC);
//      recoverStartEdges();
//      recoverMedTwoEdges();
//      return result;
//  }
//
//  private static int findMedTwoToEnd() {
//      removeStartEdges();
//      removeMedOneEdges();
//      int result = dijkstraFindMinPath(medTwo, endC);
//      recoverStartEdges();
//      recoverMedOneEdges();
//      return result;
//  }
//
//  private static int findStartToMedOne() {
//      removeMedTwoEdges();
//      removeEndEdges();
//      int result = dijkstraFindMinPath(startC, medOne);
//      recoverMedTwoEdges();
//      recoverEndEdges();
//      return result;
//  }
//
//  private static int findStartToMedTwo() {
//      removeMedOneEdges();
//      removeEndEdges();
//      int result = dijkstraFindMinPath(startC, medTwo);
//      recoverMedOneEdges();
//      recoverEndEdges();
//      return result;
//  }
//
//  private static void removeStartEdges() {
//      for (Edge edge : startSet) {
//          int x = edge.source;
//          int y = edge.target;
//          graph[x][y] = INF;
//          graph[y][x] = INF;
//      }
//  }
//
//  private static void recoverStartEdges() {
//      for (Edge edge : startSet) {
//          int x = edge.source;
//          int y = edge.target;
//          graph[x][y] = edge.weight;
//          graph[y][x] = edge.weight;
//      }
//  }
//
//  private static void removeEndEdges() {
//      for (Edge edge : endSet) {
//          int x = edge.source;
//          int y = edge.target;
//          graph[x][y] = INF;
//          graph[y][x] = INF;
//      }
//  }
//
//  private static void recoverEndEdges() {
//      for (Edge edge : endSet) {
//          int x = edge.source;
//          int y = edge.target;
//          graph[x][y] = edge.weight;
//          graph[y][x] = edge.weight;
//      }
//  }
//
//  private static void removeMedOneEdges() {
//      for (Edge edge : medOneSet) {
//          int x = edge.source;
//          int y = edge.target;
//          graph[x][y] = INF;
//          graph[y][x] = INF;
//      }
//  }
//
//  private static void recoverMedOneEdges() {
//      for (Edge edge : medOneSet) {
//          int x = edge.source;
//          int y = edge.target;
//          graph[x][y] = edge.weight;
//          graph[y][x] = edge.weight;
//      }
//  }
//
//  private static void removeMedTwoEdges() {
//      for (Edge edge : medTwoSet) {
//          int x = edge.source;
//          int y = edge.target;
//          graph[x][y] = INF;
//          graph[y][x] = INF;
//      }
//  }
//
//  private static void recoverMedTwoEdges() {
//      for (Edge edge : medTwoSet) {
//          int x = edge.source;
//          int y = edge.target;
//          graph[x][y] = edge.weight;
//          graph[y][x] = edge.weight;
//      }
//  }
//
//  private static int dijkstraFindMinPath(int source, int target) {
//      int[] distances = new int[cities + 1];
//      boolean[] used = new boolean[cities + 1];
//      for (int i = 1; i < cities + 1; i++) {
//          distances[i] = INF;
//          used[i] = false;
//      }
//      distances[source] = 0;
//      for (int i = 1; i < cities + 1; i++) {
//          int cur = chooseNode(distances, used);
//          used[cur] = true;
//          for (int j = 1; j < cities + 1; j++) {
//              if (!used[j]
//                      && graph[cur][j] != INF
//                      && distances[j] > distances[cur] + graph[cur][j]) {
//                  distances[j] = distances[cur] + graph[cur][j];
////                    if (j == target) {               //
////                        break;                       //
////                    }                                //
//                }
//            }
//        }
//        return distances[target];
//    }

//    private static int chooseNode(int[] distances, boolean[] used) {
//        int min = Integer.MAX_VALUE;
//        int minInd = -1;
//        for (int i = 1; i < cities + 1; i++)
//            if (!used[i] && distances[i] < min) {
//                min = distances[i];
//                minInd = i;
//            }
//        return minInd;
//    }

//    private static class Edge {
//        int source;
//        int target;
//        int weight;
//
//        Edge(int source, int target, int weight) {
//            this.source = source;
//            this.target = target;
//            this.weight = weight;
//        }
//    }
//}