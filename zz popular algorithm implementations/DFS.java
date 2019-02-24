import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        final int numOfNodes = 6;
        boolean[][] adjMatrix = new boolean[numOfNodes][numOfNodes];

        adjMatrix[0][1] = true;
        adjMatrix[0][2] = true;
        adjMatrix[1][2] = true;
        adjMatrix[1][4] = true;
        adjMatrix[2][3] = true;
        adjMatrix[3][4] = true;
        adjMatrix[4][2] = true;
        adjMatrix[4][5] = true;

        int startElem = 4;
        boolean[] visited = new boolean[numOfNodes];
        dfsRecursive(startElem, visited, numOfNodes, adjMatrix);

//        Stack<Integer> stack = new Stack<>();
//        stack.push(startElem);
//        visited[startElem] = true;
//        dfsStack(visited, adjMatrix, stack);
    }
//TODO -> Stack algorithm not working properly
    private static void dfsStack(boolean[] visited, boolean[][] adjMatrix, Stack<Integer> stack) {
        while (!stack.isEmpty()) {
            int nextElem = stack.pop();
            System.out.println(nextElem);
            visited[nextElem] = true;
            for (int i = 0; i < adjMatrix.length; i++) {
                if (adjMatrix[nextElem][i] && !visited[i]) {
                    stack.push(i);
                }
            }
        }
    }

    private static void dfsRecursive(int current, boolean[] visited, int numOfNodes, boolean[][] adjMatrix) {
        System.out.println(current);
        visited[current] = true;
        for (int i = 0; i < numOfNodes; i++) {
            if (!visited[i] && adjMatrix[current][i]) {
                dfsRecursive(i, visited, numOfNodes, adjMatrix);
            }
        }

    }
}
