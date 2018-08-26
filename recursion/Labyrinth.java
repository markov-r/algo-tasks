// is it possible to go from start(s) to end(e)
// "x" -> impassable, "-" is a passable cell
import java.io.*;
public class Main {

    private static void fakeInput() {
        String test = "5\n" +
                "9\n" +
                "sxxxxxxxx\n" +
                "-xxxxxxxe\n" +
                "------xx-\n" +
                "xxxxx----\n" +
                "xxx---xxx";
        System.setIn(new ByteArrayInputStream(test.getBytes()));
    }

    public static void main(String[] args) throws IOException {
        fakeInput();
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        int m = Integer.parseInt(in.readLine());
        String[][] labyrinth = new String[n][m];
        int startRow = -1;
        int startCol = -1;
        int endRow = -1;
        int endCol = -1;
        for (int i = 0; i < n; i++) {
            String[] rows = in.readLine().split("");
            for (int j = 0; j < m; j++) {
                labyrinth[i][j] = rows[j];
                if (labyrinth[i][j].equals("s")) {
                    startRow = i;
                    startCol = j;
                }
                if (labyrinth[i][j].equals("e")) {
                    endRow = i;
                    endCol = j;
                }
            }
        }

        boolean[][] visited = new boolean[n][m];
        visited[startRow][startCol] = true;

        System.out.println(findWay(startRow, startCol, labyrinth, visited, endRow, endCol));
    }

    private static boolean findWay(int row, int col, String[][] labyrinth,
                                           boolean[][] visited, int endRow, int endCol) {
        int[] dRow = new int[]{ 0, 0, -1, 1};
        int[] dCol = new int[]{-1, 1,  0, 0};
        for (int i = 0; i < 4; i++) {
            int nextRow = row + dRow[i];
            int nextCol = col + dCol[i];
            if (IsInMatrix(nextRow, nextCol, labyrinth) &&
                    IsPassable(nextRow, nextCol, labyrinth) &&
                    !visited[nextRow][nextCol]) {

                if (nextRow == endRow && nextCol == endCol) {
                    return true;
                }
                else {
                    visited[nextRow][nextCol] = true;
                    boolean hasPath = findWay(nextRow, nextCol, labyrinth, visited, endRow, endCol);
                    if (hasPath) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean IsInMatrix(int row, int col, String[][] labyrinth) {
        return row >= 0 && col >= 0 && row < labyrinth.length && col < labyrinth[0].length;
    }

    private static boolean IsPassable(int row, int col, String[][] labyrinth) {
        return !"x".equals(labyrinth[row][col]);
    }
}