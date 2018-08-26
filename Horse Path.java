import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        int [][] matrix = new int [n][n];
        boolean [] [] squareUsed = new boolean[n][n];

        int dRow[] = {-2, -2, -1, -1,  1, 1,  2, 2};
        int dCol[] = {-1,  1, -2,  2, -2, 2, -1, 1};

        int numCount = 1;
        matrix[0][0] = 1;
        squareUsed[0][0] = true;
        int nextRow, nextCol;
        int row = 0;
        int col = 0;

        for (int k = 1; k < n*n; k++) {

            int minRow = Integer.MAX_VALUE;
            int minCol = Integer.MAX_VALUE;

            for (int i = 0; i < 8; i++) {
                nextRow = row + dRow[i];
                nextCol = col + dCol[i];
                if (nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= n || squareUsed[nextRow][nextCol] == true) {
                    continue;
                }
                if (nextRow < minRow) {
                    minRow = nextRow;
                    minCol = nextCol;
                }
                if (nextRow == minRow) {
                    if (nextCol < minCol) {
                        minCol = nextCol;
                    }
                }
            }

//          find topmost left spot if no possible moves
            if (minRow == Integer.MAX_VALUE && minCol == Integer.MAX_VALUE) {
                boolean finished = false;
                for (int m = 0; m < n && finished == false; m++) {
                    for (int o = 0; o < n; o++) {
                        if (squareUsed[m][o] == false) {
                            row = m;
                            col = o;
                            finished = true;
                            break;
                        }
                    }
                }
            } else {
                row = minRow;
                col = minCol;
            }
            squareUsed[row][col] = true;
            numCount++;
            matrix[row][col] = numCount;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j < n - 1) {
                    System.out.print(matrix[i][j] + " ");
                }
                else System.out.println(matrix[i][j]);
            }
        }
    }
}