public class Main {

    public static void main(String[] args) {
//        char[][] board = new char[][]{
//                {'X', '.', '.', '.'},
//                {'X', '.', '.', 'X'},
//                {'.', '.', '.', 'X'},
//                {'X', 'X', '.', '.'}};
        char[][] board = new char[][]{
                {'X', '.', 'X', '.'},
                {'.', 'X', '.', 'X'},
                {'X', '.', 'X', '.'},
                {'.', 'X', '.', 'X'}};
        System.out.println(countBattleships(board));
    }

    /** Count only the "first" occurrence of every ship.
     *  An occurrence is first if there is no 'X' to the left or above it.
     *  Having in mind that we traverse the grid in the standard way*/

    private static int countBattleships(char[][] board) {
        if (board.length == 0 || board[0].length == 0) return 0;
        int count = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'X' && isFirstXChar(board, i, j))
                    count++;
            }
        }
        return count;
    }

    private static boolean isFirstXChar(char[][] board, int i, int j) {
        if (i >= 1 && board[i-1][j] == 'X')  //if up is X -> not first
            return false;
        if (j >= 1 && board[i][j-1] == 'X')  //if left is X -> not first
            return false;
        return true;
    }
}
