import java.io.*;
import java.util.*;

public class Main {

    static void fakeInput() {
        String test = "6 7 3\n" +
                      "0 0\n" +
                      "2 2\n" +
                      "-2 2\n" +
                      "3 -1\n";
        System.setIn(new ByteArrayInputStream(test.getBytes()));
    }

    public static void main(String[] args) throws IOException {
        fakeInput();
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String firstLine[] = in.readLine().split(" ");
        int rows = Integer.parseInt(firstLine[0]);
        int cols = Integer.parseInt(firstLine[1]);
        int numOfJumps = Integer.parseInt(firstLine[2]);
        String startPosition[] = in.readLine().split(" ");
        int startRow = Integer.parseInt(startPosition[0]);
        int startCol = Integer.parseInt(startPosition[1]);
        int[][]jumpSequence = new int[numOfJumps][2];
        for (int i = 0; i < numOfJumps; i++) {
            String currentJump[] = in.readLine().split(" ");
            jumpSequence[i][0] = Integer.parseInt(currentJump[0]);
            jumpSequence[i][1] = Integer.parseInt(currentJump[1]);
        }

        int jumpsMade = 0;
        int sum = calcField(startRow, startCol, cols);
        boolean[][] visited = new boolean[rows][cols];
        visited[startRow][startCol] = true;

        boolean wentOut = false;
        boolean steppedOnVisited = false;
        int row = startRow;
        int col = startCol;

        do {
            for (int i = 0; i < numOfJumps; i++) {
                int rowChange = jumpSequence[i][0];
                int colChange = jumpSequence[i][1];
                row += rowChange;
                col += colChange;
                if (!isWithinMatrix(row, col, rows, cols)) {
                    wentOut = true;
                    break;
                }
                if (visited[row][col]) {
                    steppedOnVisited = true;
                    break;
                }
                sum += calcField(row, col, cols);
                jumpsMade++;
                if (i == numOfJumps - 1) {
                    i = -1;
                }
            }
        } while (!wentOut && !steppedOnVisited);

        if (wentOut) {
            System.out.println("escaped " + sum);
        }
        if (steppedOnVisited) {
            System.out.println("caught " + jumpsMade);
        }
    }

    public static int calcField(int row, int col, int cols) {
        return row*cols + col + 1;
    }

    public static boolean isWithinMatrix(int row, int col, int rows, int cols) {
        if (row > -1 && row < rows && col > -1 && col < cols) {
            return true;
        }
        return false;
    }
}