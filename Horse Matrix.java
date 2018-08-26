import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;


public class Main {
    static int n;
    static String[][] staMat;
    static boolean [][] visited;
    static int startRow = 0;
    static int startCol = 0;
    static int endRow = 0;
    static int endCol = 0;

    public static void main(String[] args) throws IOException {

        ReadInput();
        FindShortestPath();
    }

    static void FindShortestPath () {

        int[] dRow = new int[]{-2, -2, -1, -1, 1, 1, 2, 2};
        int[] dCol = new int[]{-1, 1, -2, 2, -2, 2, -1, 1};
        IndicesPlusCount startIndicesCount = new IndicesPlusCount(startRow, startCol, 1);
        Queue<IndicesPlusCount> queue = new ArrayDeque<>();
        queue.offer(startIndicesCount);
        boolean skipLoop = false;

        while (!queue.isEmpty() && !skipLoop) {
            IndicesPlusCount next = queue.poll();
            for (int i = 0; i < 8; i++) {
                int nextRow = next.getRow() + dRow[i];
                int nextCol = next.getCol() + dCol[i];
                if (IsInMatrix(nextRow, nextCol) && IsPassable(nextRow, nextCol) && !visited[nextRow][nextCol]) {
                    if (nextRow == endRow && nextCol == endCol) {
                        System.out.println(next.getCount());
                        skipLoop = true;
                        break;
                    } else {
                        visited[nextRow][nextCol] = true;
                        queue.offer(new IndicesPlusCount(nextRow, nextCol, next.getCount() + 1));
                    }
                }
            }
        }
        if (!skipLoop) {
            System.out.println("No");
        }
    }

    static boolean IsPassable (int row, int col) {
        if (!"x".equals(staMat[row][col])) {
            return true;
        } else {
            return false;
        }
    }

    static boolean IsInMatrix (int row, int col) {
        if (row >= 0 && col >= 0 && row < n && col < n) {
            return true;
        }
        else {
            return false;
        }
    }

    static void ReadInput () throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(in.readLine());
        staMat = new String[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            String rows[] = in.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                staMat[i][j] = rows[j];
                if (staMat[i][j].equals("s")) {
                    startRow = i;
                    startCol = j;
                }
                if (staMat[i][j].equals("e")) {
                    endRow = i;
                    endCol = j;
                }
            }
        }

    }

    static class IndicesPlusCount {
        private int r;
        private int c;
        private int count;

        IndicesPlusCount(int r, int c, int count) {
            this.r = r;
            this.c = c;
            this.count = count;
        }
        int getRow() {
            return r;
        }
        int getCol() {
            return  c;
        }
        int getCount() {
            return count;
        }
    }
	 
}				