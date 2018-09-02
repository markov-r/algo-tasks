import java.io.*;

public class Main {

    private static void fakeInput() {
        String test = "10\n" +
                "6\n" +
                "pizza 3 2\n" +
                "burger 8 12\n" +
                "salad 4 5\n" +
                "candy 1 4\n" +
                "chicken 2 3\n" +
                "swine 8 13";
        System.setIn(new ByteArrayInputStream(test.getBytes()));
    }

    public static void main(String[] args) throws IOException {
//        fakeInput();
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String inputStr = in.readLine();
        String trimmedInput = inputStr.trim();
        int capacity = Integer.parseInt(trimmedInput);
        int numOfItems = Integer.parseInt(in.readLine());
        String[] names = new String[numOfItems + 1];
        int[] weights = new int[numOfItems + 1];
        int[] values = new int[numOfItems + 1];
        for (int i = 1; i < numOfItems + 1; i++) {
            String inputRow[] = in.readLine().split(" ");
            names[i] = inputRow[0];
            weights[i] = Integer.parseInt(inputRow[1]);
            values[i] = Integer.parseInt(inputRow[2]);
        }
        int[][] maxValues = new int[numOfItems + 1][capacity + 1];

//  Zeroes for first row in matrix (already by default)
//        for (int i = 0; i < capacity + 1; i++) {
//            maxValues[0][i] = 0;
//        }

        for (int i = 1; i < numOfItems + 1; i++) {
            for (int j = 0; j < capacity + 1; j++) {
                if (weights[i] > j) {
                    maxValues[i][j] = maxValues[i - 1][j];
                } else {
                    int prevMax = maxValues[i - 1][j - weights[i]] + values[i];
                    maxValues[i][j] = Math.max(maxValues[i - 1][j], prevMax);
                }
            }
        }
        System.out.println(maxValues[numOfItems][capacity]);
//        System.out.println(Arrays.deepToString(maxValues).replace("], ", "]\n"));
        backTrackFoods(maxValues, names, weights, numOfItems, capacity);
    }

    private static void backTrackFoods(int[][] maxValues, String[] names, int[] weights, int row, int col) {
        if (maxValues[row][col] == 0) {
            return;
        }
        if (row == 1) {
            System.out.println(names[row]);
            return;
        }
        if (maxValues[row-1][col] == maxValues[row][col]) {
            backTrackFoods(maxValues, names, weights, row-1, col);
        } else {
            System.out.println(names[row]);
            backTrackFoods(maxValues, names, weights,row-1, col - weights[row]);
        }
    }
}