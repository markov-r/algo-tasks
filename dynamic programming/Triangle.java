import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        fillTriangle(triangle);
        System.out.println(minimumTotalTopDown(triangle));
        System.out.println(minimumTotalBottomUp(triangle));
    }

    private static void fillTriangle(List<List<Integer>> triangle) {
        List<Integer> next1 = new ArrayList<>();
        next1.add(2);
        triangle.add(next1);
        List<Integer> next2 = new ArrayList<>();
        next2.add(3); next2.add(4);
        triangle.add(next2);
        List<Integer> next3 = new ArrayList<>();
        next3.add(6); next3.add(5); next3.add(7);
        triangle.add(next3);
        List<Integer> next4 = new ArrayList<>();
        next4.add(4); next4.add(1); next4.add(8); next4.add(3);
        triangle.add(next4);
        for (List<Integer> list : triangle) {
            for (Integer integer : list)
                System.out.print(integer + " ");
            System.out.println();
        }
    }

    /** Top-Down DP
     */
    private static int minimumTotalTopDown(List<List<Integer>> triangle) {
        if (triangle.size() == 1) return triangle.get(0).get(0);
        List<List<Integer>> dp = new ArrayList<>();
        dp.add(triangle.get(0));
        List<Integer> sec = new ArrayList<>();
        sec.add(triangle.get(0).get(0) + triangle.get(1).get(0));
        sec.add(triangle.get(0).get(0) + triangle.get(1).get(1));
        dp.add(sec);
        for (int i = 2; i < triangle.size(); i++) {
            List<Integer> next = new ArrayList<>();
            next.add(triangle.get(i).get(0) + dp.get(i-1).get(0));
            for (int j = 1; j <= i - 1; j++) {
                next.add(triangle.get(i).get(j) + Math.min(dp.get(i-1).get(j), dp.get(i-1).get(j-1)));
            }
            next.add(triangle.get(i).get(i) + dp.get(i-1).get(i-1));
            dp.add(next);
        }
        int min = dp.get(dp.size() - 1).get(0);
        for (int i = 1; i < dp.get(dp.size() - 1).size(); i++) {
            if (dp.get(dp.size() - 1).get(i) < min) min = dp.get(dp.size() - 1).get(i);
        }
        return min;
    }

    /** Bottom-Up DP
     */
    private static int minimumTotalBottomUp(List<List<Integer>> triangle) {
        int t = triangle.size();
        int[] A = new int[t+1];
        for(int i = t - 1; i >= 0; i--) {
            for(int j = 0; j < triangle.get(i).size(); j++) {
                A[j] = Math.min(A[j], A[j+1]) + triangle.get(i).get(j);
            }
        }
        return A[0];
    }
}
