import java.io.*;
import java.util.*;

public class Main {

    private static void fakeInput() {
        String test = "6";
        System.setIn(new ByteArrayInputStream(test.getBytes()));
    }

    public static void main(String[] args) throws IOException {
        fakeInput();
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        Solution.solveNQueens(n);
    }


    static class Solution {

        static Set<List<String>> setResult = new HashSet<>();

        static List<List<String>> solveNQueens(int n) {
            char[][] stamat = new char[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    stamat[i][j] = '.';
                }
            }
            solve(n, new ArrayList<>(), stamat);
            System.out.println(setResult.size());
//            System.out.println("###");
//            for (List<String> strings : setResult) {
//                for (String string : strings) {
//                    System.out.println(string);
//                }
//                System.out.println("--------");
//            }

            return new ArrayList<>(setResult);
        }

        private static void solve(int n, List<Coordinate> queens, char[][] stamat) {
            if (queens.size() == n) {
                List<String> newResult = charMatrixToStringList(stamat);
                setResult.add(newResult);
                return;
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (stamat[i][j] == '.' &&
                            possibleToPutQueen(i, j, queens, stamat)) {
                        Coordinate newQueen = new Coordinate(i, j);
                        queens.add(newQueen);
                        stamat[i][j] = 'Q';
                        solve(n, queens, stamat);
                        stamat[i][j] = '.';
                        queens.remove(newQueen);
                    }
                }
            }
        }

        private static List<String> charMatrixToStringList(char[][] stamat) {
            List<String> result = new ArrayList<>();
            for (int i = 0; i < stamat.length; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < stamat[i].length; j++) {
                    sb.append(stamat[i][j]);
                }
                result.add(sb.toString());
            }
            return result;
        }

        static boolean possibleToPutQueen(int row, int col, List<Coordinate> queens, char[][] stamat) {
            int n = stamat.length;
            //horizontal
            for (int i = 0; i < n; i++) {
                if (stamat[i][col] == 'Q') {
                    return false;
                }
            }
            //vertical
            for (int i = 0; i < n; i++) {
                if (stamat[row][i] == 'Q') {
                    return false;
                }
            }
            //diagonal
            for (Coordinate queen : queens) {
                int dCol = Math.abs(queen.col - col);
                int dRow = Math.abs(queen.row - row);
                if (dCol == dRow) {
                    return false;
                }
            }
            return true;
        }

        private static class Coordinate {
            int row;
            int col;

            Coordinate(int row, int col) {
                this.row = row;
                this.col = col;
            }
        }
    }
}
