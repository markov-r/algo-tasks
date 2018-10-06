import java.io.*;
import java.util.*;

public class Main {

    private static void fakeInput() {
        String test = "8\n" +
                "index.html needs main.css\n" +
                "main.css needs sub1.css\n" +
                "index.html needs main.js\n" +
                "main.css needs sub2.css\n" +
                "index.html needs logo.png\n" +
                "main.js needs player.png\n" +
                "main.js needs partial.html\n" +
                "partial.html needs partial.js";
        System.setIn(new ByteArrayInputStream(test.getBytes()));
    }

    public static void main(String[] args) throws IOException {
        fakeInput();
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Map<String, List<String>> graph = new HashMap<>();
        Map<String, Integer> incoming = new HashMap<>();
        Set<String> vertices = new HashSet<>();

        int numOfRounds = Integer.parseInt(in.readLine());
        for (int i = 0; i < numOfRounds; i++) {
            String dependency[] = in.readLine().split(" ");
            String from = dependency[0];
            String to = dependency[2];
            vertices.add(from);
            vertices.add(to);
            increaseIncEdgesCount(to, incoming);
            List<String> list;
            if (graph.containsKey(from)) {
                list = graph.get(from);
            } else {
                list = new ArrayList<>();
            }
            list.add(to);
            graph.put(from, list);
        }

        Queue<String> queue = new PriorityQueue<>();
        for (String vertex : vertices) {
            if (!incoming.containsKey(vertex)) queue.add(vertex);
        }
        while (!queue.isEmpty()) {
            String currVert = queue.poll();
            System.out.print(currVert + " ");
            if (!graph.containsKey(currVert)) {
                continue;
            }
            for (String vertex : graph.get(currVert)) {
                int oldCount = incoming.get(vertex);
                if (oldCount == 1) {
                    queue.add(vertex);
                }
                incoming.put(vertex, oldCount - 1);
            }
        }
    }

    private static void increaseIncEdgesCount(String to, Map<String, Integer> incoming) {
        if (!incoming.containsKey(to)) {
            incoming.put(to, 1);
        } else {
            int currentCount = incoming.get(to);
            incoming.put(to, currentCount + 1);
        }
    }

//    private static boolean hasNoIncEdges(String checkNode, Map<String, List<String>> graph) {
//        for (String node : graph.keySet()) {
//            if (graph.get(node).contains(checkNode)) {
//                return false;
//            }
//        }
//        return true;
//    }

}
