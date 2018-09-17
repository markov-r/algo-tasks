import java.util.*;

public class Main {

    private static final int SIZE = 8;
    private static final int INF = 99;

    public static void main(String[] args) {
        int[][] graph = new int[SIZE][SIZE];
        int[][] distances = new int[SIZE][SIZE];

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                graph[i][j] = INF;
            }
        }

        graph[0][1] = 3;
        graph[1][0] = 3;
        graph[0][2] = 4;
        graph[2][0] = 4;
        graph[1][3] = 2;
        graph[3][1] = 2;
        graph[1][4] = 1;
        graph[4][1] = 1;
        graph[2][5] = 2;
        graph[5][2] = 2;
        graph[4][5] = 3;
        graph[5][4] = 3;
        graph[4][6] = 2;
        graph[6][4] = 2;
        graph[5][7] = 2;
        graph[7][5] = 2;

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                distances[i][j] = graph[i][j];
            }
        }

        for (int k = 0; k < SIZE; k++) {
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    if (i == j) {
                        continue;
                    }
                    if (distances[i][k] + distances[k][j] < distances[i][j]) {
                        distances[i][j] = distances[i][k] + distances[k][j];
                    }
                }
            }
        }
        System.out.println(Arrays.deepToString(distances).replace("], ", "]\n"));

    }
}
