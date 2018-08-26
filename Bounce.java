import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String numbers[] = in.readLine().split(" ");
        int rows = Integer.parseInt(numbers[0]);
        int cols = Integer.parseInt(numbers[1]);
        int row = 0;
        int col = 0;
        long sum = (long) 1 << (row + col);
        int dRow = +1;
        int dCol = +1;
        if (rows == 1 || cols == 1) {
            System.out.println(1);
            return;
        }
        do {
            row += dRow;
            col += dCol;
            sum += (long) 1 << (row + col);
            if (row == rows - 1 || row == 0) {
                dRow *= -1;
            }
            if (col == cols - 1 || col == 0) {
                dCol *= -1;
            }
        } while ((!isAtCorner(row, col, rows, cols)));

        System.out.println(sum);
    }

    static boolean isAtCorner(int row, int col, int rows, int cols) {
        if (row == 0 && col == 0) {
            return true;
        }
        if (row == 0 && col == cols - 1) {
            return true;
        }
        if (row == rows - 1 && col == 0) {
            return true;
        }
        if (row == rows - 1 && col == cols - 1) {
            return true;
        }
    return false;
    }
}
