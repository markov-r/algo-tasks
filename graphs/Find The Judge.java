import java.util.Set;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toSet;

class Solution {

    public Solution() {
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findJudge(4, new int[][] {{1,3},{1,4},{2,3},{2,4},{4,3}}));
        System.out.println(new Solution().findJudge(2, new int[][] {{1,2}}));
        System.out.println(new Solution().findJudge(3, new int[][] {{1,3}, {2,3}}));
        System.out.println(new Solution().findJudge(3, new int[][] {{1,3}, {2,3}, {3,1}}));
        System.out.println(new Solution().findJudge(3, new int[][] {{1,2}, {2,3}}));

        System.out.println(new Solution().findJudge(4, new int[][] {{}}));
        System.out.println(new Solution().findJudge(4, new int[][] {}));
    }

    /** Straightforward solution - find all nodes with incoming edges only,
        and from them filter the one (can't be more than one), that is trusted by all
        (that has incoming edges from all other nodes). */

    public int findJudgeSet(int n, int[][] trust) {
        if (trust.length == 0 || trust[0].length == 0) return 1; //if no connections, then judge is the only node

//      find all vertices with no outgoing edges
        Set<Integer> candidates = IntStream.rangeClosed(1, n).boxed().collect(toSet());
        for (int[] ints : trust) {
            candidates.remove(ints[0]);
        }

//      for each candidate check that all nodes have edges to it
        for (int candidate : candidates) {
            Set<Integer> trustingNodes = IntStream.rangeClosed(1, n).boxed().collect(toSet());
            trustingNodes.remove(candidate);
            for (int[] ints : trust) {
                if (ints[1] == candidate) {
                    trustingNodes.remove(ints[0]);
                }
            }
            if (trustingNodes.isEmpty()) {
                return candidate;
            }
        }
        return -1;
    }


    /** Count the number of incoming/outgoing edges each vertex has,
     *  then find the node that has 0 outgoing and n-1 incoming edges, it can be only one. */

    public int findJudge(int n, int[][] trust) {
        if (trust.length == 0 || trust[0].length == 0) return 1;
        int[][] vertexCount = new int[n+1][2]; //[][0] counts incoming, [][1] counts outgoing
        for (int[] edge : trust) {
            vertexCount[edge[0]][0]++; //count outgoing
            vertexCount[edge[1]][1]++; //count incoming
        }
        //find the node with n-1 incoming edges, and no outgoing edges - the judge
        for (int i = 1; i < vertexCount.length; i++) {
            if (vertexCount[i][0] == 0 && vertexCount[i][1] == n - 1)
                return i;
        }
        return -1;
     }
}