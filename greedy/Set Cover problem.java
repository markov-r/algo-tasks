import java.io.*;
import java.util.*;

// Approximate greedy solution - not optimal!
// In each step choose the set containing the most uncovered numbers

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int universeNum = Integer.parseInt(in.readLine());
        Set<Integer> universe = new HashSet<>();
        for (int i = 1; i < universeNum + 1; i++) {
            universe.add(i);
        }
        int numOfSets = Integer.parseInt(in.readLine());
        boolean[] used = new boolean[numOfSets];
        List<Set<Integer>> sets = new ArrayList<>();
        for (int i = 0; i < numOfSets; i++) {
            Set<Integer> nextSet = new HashSet<>();
            String nextRow[] = in.readLine().split(" ");
            for (String s : nextRow) {
                nextSet.add(Integer.parseInt(s));
            }
            sets.add(nextSet);
        }
        List<Set<Integer>> initialSets = new ArrayList<>(sets);         //Can be used to print the sets taking part in solution
        int resultNum = setCoverSolve(sets, universe, used, numOfSets);
        List<Integer> resultSets = new ArrayList<>();
        for (int i = 0; i < used.length; i++) {
            if (used[i]) resultSets.add(i);
        }
        System.out.println("The minimum number of sets is " + resultNum);
        System.out.print("The used sets are ");
        for (Integer resultSet : resultSets) {
            System.out.print(resultSet + " ");
        }

    }

    private static int setCoverSolve(List<Set<Integer>> sets, Set<Integer> universe, boolean[] used, int numOfSets) {
       int resultNum = 0;
        while (!universe.isEmpty()) {
           int ind = findLongestSet(sets);
           used[ind] = true;
           resultNum++;
           Set<Integer> currSet = new HashSet<>(sets.get(ind));
           for (int i = 0; i < numOfSets; i++) {
               sets.get(i).removeAll(currSet);
           }
           universe.removeAll(currSet);
       }
       return resultNum;
    }

    private static int findLongestSet(List<Set<Integer>> sets) {
        int max = Integer.MIN_VALUE;
        int ind = -1;
        for (int i = 0; i < sets.size(); i++) {
            if (sets.get(i).size() > max) {
                max = sets.get(i).size();
                ind = i;
            }
        }
        return ind;
    }
}
