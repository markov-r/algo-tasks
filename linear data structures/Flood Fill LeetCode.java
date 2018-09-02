import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int sr = 0;
        int sc = 0;
        int[][] image = {{1, 1, 0, 1},
                         {0, 1, 1, 1},
                         {1, 0, 1, 1},
                         {0, 1, 0, 1}};
        System.out.println(Arrays.deepToString(image).replace("], ", "]\n"));
        System.out.println();
        int newColor = 2;
        int[][] result = floodFill(image, sr, sc, newColor);
//        System.out.println(Arrays.deepToString(result));
        System.out.println(Arrays.deepToString(result).replace("], ", "]\n"));
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        boolean[][] visited = new boolean[image.length][image[0].length];
        int oldColor = image[sr][sc];
        fillRecursive(sr, sc, newColor, visited, dx, dy, image, oldColor);
        return image;
    }

    public static void fillRecursive(int sr, int sc, int newColor, boolean[][] visited, int[] dx, int[] dy, int[][] image, int oldColor) {
        visited[sr][sc] = true;
        image[sr][sc] = newColor;
        for (int i = 0; i < 4; i++) {
            int newRow = sr + dx[i];
            int newCol = sc + dy[i];
            if (isWithinBounds(newRow, newCol, image) && !visited[newRow][newCol] && image[newRow][newCol] == oldColor) { //TODO - newColor changed from 0
                fillRecursive(newRow, newCol, newColor, visited, dx, dy, image, oldColor);
            }
        }
    }

    public static boolean isWithinBounds(int row, int col, int[][] matrix) {
        return row > -1 && row < matrix.length && col > -1 && col < matrix[0].length;
    }

}
