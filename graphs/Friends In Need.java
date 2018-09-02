import java.io.*;
import java.util.*;

public class Main {

    static void fakeInput() {
        String test = "3 2 1\n" +
                "1\n" +
                "1 2 1\n" +
                "3 2 2";
//        String test = "5 8 2\n" +
//                "1 2\n" +
//                "1 2 5\n" +
//                "4 1 2\n" +
//                "1 3 1\n" +
//                "3 4 4\n" +
//                "4 5 1\n" +
//                "2 4 3\n" +
//                "5 2 1\n" +
//                "2 3 20";
        System.setIn(new ByteArrayInputStream(test.getBytes()));
    }

    private static int NODES;
    private static final int INF = 99;

    public static void main(String[] args) throws IOException {
        fakeInput();
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String nmh[] = in.readLine().split(" ");
        NODES = Integer.parseInt(nmh[0]);
//        int edges = Integer.parseInt(nmh[1]);
//        int numOfHospitals = Integer.parseInt(nmh[2]);
//        int homes = NODES - numOfHospitals;
        String strHospitals[] = in.readLine().split(" ");
        int[] hospitals = new int[strHospitals.length];
        Set<Integer> hospiSet = new HashSet<>();
        for (int i = 0; i < strHospitals.length; i++) {
            hospitals[i] = Integer.parseInt(strHospitals[i]);
            hospiSet.add(Integer.parseInt(strHospitals[i]));
        }
        int[][] graph = new int[NODES + 1][NODES + 1];

        for (int i = 1; i < NODES + 1; i++) {
            for (int j = 1; j < NODES + 1; j++) {
                if (i == j) {
                    graph[i][j] = 0;
                } else {
                    graph[i][j] = INF;
                }
            }
        }

        while (true) {
            String line = in.readLine();
            if (line == null) {
                break;
            }
            String[] nextRow = line.split(" ");
            int x = Integer.parseInt(nextRow[0]);
            int y = Integer.parseInt(nextRow[1]);
            int val = Integer.parseInt(nextRow[2]);
            graph[x][y] = val;
            graph[y][x] = val;
        }

//        System.out.println(Arrays.deepToString(graph).replace("], ", "]\n"));

        int[] hospitalSums = new int[hospitals.length];
        for (int i = 0; i < hospitals.length; i++) {
            int curHosp = hospitals[i];
            int[] distances = findDistances(curHosp, graph);
//            System.out.println(Arrays.toString(distances));
            for (int j = 0; j < distances.length; j++) {
                if (hospiSet.contains(j)) {
                    distances[j] = 0;
                }
                hospitalSums[i] += distances[j];
            }
        }

        int min = Integer.MAX_VALUE;
        for (int hospitalSum : hospitalSums) {
            if (hospitalSum < min) {
                min = hospitalSum;
            }
        }
        System.out.println(min);
    }

    private static int[] findDistances(int x, int[][] graph) {
        int[] distances = new int[NODES+1];
        boolean[] used = new boolean[NODES+1];
        for (int i = 1; i < NODES+1; i++) {
            distances[i] = INF;
            used[i] = false;
        }
        distances[x] = 0;

        for (int i = 1; i < NODES+1; i++) {
            int cur = chooseNode(distances, used);
            used[cur] = true;
            for (int j = 1; j < NODES+1; j++) {
                if (!used[j]
                        && graph[cur][j] != INF
                        && distances[j] > distances[cur] + graph[cur][j]) {
                    distances[j] = distances[cur] + graph[cur][j];
                }
            }
        }
        return distances;
    }

    private static int chooseNode(int[] distances, boolean[] used) {
        int min = Integer.MAX_VALUE;
        int minInd = -1;
        for (int i = 1; i < NODES + 1; i++)
            if (!used[i] && distances[i] < min) {
                min = distances[i];
                minInd = i;
            }
        return minInd;
    }
}