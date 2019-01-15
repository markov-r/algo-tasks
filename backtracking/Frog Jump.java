import java.util.*;

public class Main {

    public static void main(String[] args) {
        System.out.println(canCrossBT(new int[]{0}));
        System.out.println(canCrossBT(new int[]{0, 1}));
        System.out.println(canCrossBT(new int[]{0, 2}));
        System.out.println(canCrossBT(new int[]{0, 1, 5}));
        System.out.println(canCrossBT(new int[]{0, 1, 3, 5, 6}));
        System.out.println(canCrossBT(new int[]{0, 1, 3, 5, 15}));
        System.out.println(canCrossBT(new int[]{0, 1, 3, 5, 6, 8, 12, 17}));
        System.out.println(canCrossBT(new int[]{0, 1, 3, 6, 10, 13, 15, 18}));

    }


    /** Standard backtracking solution - gets TLE
     */
    private static Map<Integer, Integer> positions = new HashMap<>();

    private static boolean canCrossBT(int[] stones) {
        positions = new HashMap<>();
        for (int i = 0; i < stones.length; i++) positions.put(stones[i], i);
        if (stones.length > 1 && stones[1] != 1) return false;
        return backTrack(stones, 0, 1);
    }

    private static boolean backTrack(int[] stones, int pos, int jump) {
        if (pos == stones.length - 1)
            return true;
        for (int dif = 1; dif >= -1; dif--) {
            if (jump + dif == 0) continue;
            int newPos = stones[pos] + jump + dif;
                if (positions.containsKey(newPos)) {
                    if (backTrack(stones, positions.get(newPos), jump + dif))
                        return true;
                }
        }
        return false;
    }

    /** Optimized solution - uses memo Map
     */
    public boolean canCross(int[] stones) {
        final int l = stones != null ? stones.length : 0;
        if (l < 1 || stones[0] != 0) return false;
        final Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int s : stones) map.put(s, new HashSet<Integer>());
        for (int s : stones) {
            Set<Integer> jSet = map.get(s);
            // Initial condition
            if (s == 0) {
                jSet.add(0);
                if (map.containsKey(1)) map.get(1).add(1);
                continue;
            }
            // For other stones
            for (int j : jSet) {
                int jj = j - 1;
                int ss = s + jj;
                // Previous jump - 1
                if (ss != s && map.containsKey(ss)) map.get(ss).add(jj);
                // Previous jump
                jj++; ss++;
                if (ss != s && map.containsKey(ss)) map.get(ss).add(jj);
                // Previous jump + 1
                jj++; ss++;
                if (ss != s && map.containsKey(ss)) map.get(ss).add(jj);
            }
        }
        return !map.get(stones[l - 1]).isEmpty();
    }
}
