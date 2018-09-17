import java.util.*;

public class Main {

    private static int NODES;
    private static Map<Integer, Deque<Integer>> graph;
    private static Stack<Integer> sorted = new Stack<>();
    private static Deque<Integer> validStartNodes = new ArrayDeque<>();
    private static Set<Integer> visited;

    public static void main(String[] args) {
        NODES = 6;
        visited = new HashSet<>();
        graph = new HashMap<>();

        fillGraph();

        for (int i = 0; i < NODES; i++) {
            if (isValidStartingNode(i)) {
                validStartNodes.add(i);
            }
        }

        for (Integer node : validStartNodes) {
            topoSort(node);
        }

        Collections.reverse(sorted);
        System.out.println(Arrays.toString(sorted.toArray()));
    }

    private static void topoSort(int data) {
        visited.add(data);
        for (int i : graph.get(data)) {
            if (!visited.contains(i)) {
                topoSort(i);
            }
        }
        sorted.push(data);
    }

    private static boolean isValidStartingNode(int x) {
        for (int j : graph.keySet()) {
            if (graph.get(j).contains(x)) {
                return false;
            }
        }
        return true;
    }

    private static void fillGraph() {
        for (int i = 0; i < NODES; i++) {
            graph.put(i, new ArrayDeque<>());
        }

        Deque<Integer> verticesFrom5 = new ArrayDeque<>();
        verticesFrom5.add(0);
        verticesFrom5.add(2);
        graph.put(5, verticesFrom5);

        Deque<Integer> verticesFrom4 = new ArrayDeque<>();
        verticesFrom4.add(0);
        verticesFrom4.add(1);
        graph.put(4, verticesFrom4);

        Deque<Integer> verticesFrom2 = new ArrayDeque<>();
        verticesFrom2.add(3);
        graph.put(2, verticesFrom2);

        Deque<Integer> verticesFrom3 = new ArrayDeque<>();
        verticesFrom3.add(1);
        graph.put(3, verticesFrom3);
    }

    private static boolean hasMoreIncEdges(int x, Map<Integer,Set<Integer>> graph) {
        for (Integer i : graph.keySet()) {
            for (Integer j : graph.get(i)) {
                if (j ==x) {
                    return true;
                }
            }
        }
        return false;
    }

    private static int findStartingNode() {
        for (int i = 0; i < NODES; i++) {
            boolean breakOuter = false;
            for (int j : graph.keySet()) {
                if (graph.get(j).contains(i)) {
                    breakOuter = true;
                    break;
                }
            }
            if (breakOuter) {
                continue;
            }
            return i;
        }
        return Integer.MIN_VALUE;
    }



}
