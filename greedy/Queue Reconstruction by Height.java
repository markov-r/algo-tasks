import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args){
        System.out.println(
                Arrays.deepToString(reconstructQueue(new int[][]
                        {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}}
//                        {{0,0},{6,2},{5,5},{4,3},{5,2},{1,1},{6,0},{6,3},{7,0},{5,1}}
//                        {{2,3}, {3,0}, {6,0}, {1,2}, {4,1}, {5,0}}
//                        {{2, 0}, {1, 0}}
//                        {{1, 0}}
//                        {{}}
//                        {}
                )).replace("], ", "]\n")
                        .replace("[[", "[")
                        .replace("]]", "]"));
    }

    /** Sort array by height decreasing, when height is equal put smaller position first
     *  E.g. (5,0) before (5,2) cause (5,0) is in front of (5,2) in the queue.
     *  Then start scanning the sorted array from back to front (from shortest to highest)
     *  and each time put the current person in the i-th free (unoccupied) slot of result array,
     *  where i is person's position. */

    private static int[][] reconstructQueue(int[][] people) {
        if (people.length == 0 || people[0].length == 0) return people;
        int[][] result = new int[people.length][2];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < 2; j++) {
                result[i][j] = -1;                  //for the case of (0, 0) person
            }
        }
        Arrays.sort(people, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (b[0] == a[0]) return a[1] - b[1];
                return b[0] - a[0];
            }
        });

        for (int i = people.length - 1; i >= 0; i--)
            insertArr(people[i], result);
        return result;
    }

    private static void insertArr(int[] person, int[][] result) {
        int count = 0;
        for (int i = 0; i < result.length; i++) {
            if (result[i][0] == -1 && result[i][1] == -1) {
                if (person[1] == count) {
                    result[i][0] = person[0];
                    result[i][1] = person[1];
                    return;
                }
            count++;
            }
        }
    }
}

