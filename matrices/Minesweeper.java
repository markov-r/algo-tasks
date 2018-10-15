import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// 0 0 1 X
// 1 1 2 1
// 1 X 1 0
// 1 1 1 0

// 0 0 0 -1
// 0 0 0 0
// 0 -1 0 0
// 0 0 0 0

public class Main {
    public static void main(String args[] ) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        int numOfMines = Integer.parseInt(in.readLine());
        int[][] matrix = new int[n][n];
        for (int i = 0; i < numOfMines; i++) {
            int row = randomWithRange(0, n-1);
            int col = randomWithRange(0, n-1);
            if (matrix[row][col] == -1) {
                numOfMines++;
                continue;
            }
            matrix[row][col] = -1;
        }

//        matrix[1][1] = -1;
//        matrix[n-1][n-1] = -1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == -1) {
                    increaseMarkers(matrix, i, j);
                }
            }
        }

        System.out.println(Arrays.deepToString(matrix).replace("], ", "]\n"));
    }

    private static void increaseMarkers(int[][] matrix, int row, int col) {
        if (isInMatrix(row, col+1, matrix) && matrix[row][col+1] != -1) {
            matrix[row][col+1] += 1;
        }
        if (isInMatrix(row, col-1, matrix) && matrix[row][col-1] != -1) {
            matrix[row][col-1] += 1;
        }
        if (isInMatrix(row+1, col, matrix) && matrix[row+1][col] != -1 ) {
            matrix[row+1][col] += 1;
        }
        if (isInMatrix(row-1, col, matrix) && matrix[row-1][col] != -1) {
            matrix[row-1][col] += 1;
        }
        if (isInMatrix(row-1, col-1, matrix) && matrix[row-1][col-1] != -1) {
            matrix[row-1][col-1] += 1;
        }
        if (isInMatrix(row-1, col+1, matrix) && matrix[row-1][col+1] != -1) {
            matrix[row-1][col+1] += 1;
        }
        if (isInMatrix(row+1, col-1, matrix) && matrix[row+1][col-1] != -1) {
            matrix[row+1][col-1] += 1;
        }
        if (isInMatrix(row+1, col+1, matrix) && matrix[row+1][col+1] != -1 ) {
            matrix[row+1][col+1] += 1;
        }
    }

    private static boolean isInMatrix(int row, int col, int[][] matrix) {
        return row > -1 && row < matrix.length && col > -1 && col < matrix[0].length;
    }

    private static int randomWithRange(int min, int max) {
        int range = (max - min) + 1;
        return (int)(Math.random() * range) + min;
    }
}