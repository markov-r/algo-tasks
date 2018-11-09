public class Main {
    public static void main(String[] args) {
//        System.out.println(canCompleteCircuit(new int[] {1, 2, 3, 4, 5},           // 3
//                                              new int[] {3, 4, 5, 1, 2}));
//        System.out.println(canCompleteCircuit(new int[] {6, 2, 7, 1, 2, 2},        // 4
//                                              new int[] {1, 3, 5, 8, 0, 3}));
//        System.out.println(canCompleteCircuit(new int[] {2, 2, 6, 2, 7, 1},        // 0
//                                              new int[] {0, 3, 1, 3, 5, 8}));
//        System.out.println(canCompleteCircuit(new int[] {1, 1, 1, 1, 1, 1},
//                                              new int[] {2, 0, 2, 0, 2, 1}));
        System.out.println(canCompleteCircuit(new int[] {6, 1, 4, 3, 5},           // 2
                                              new int[] {3, 8, 2, 4, 2}));
    }
    /** Find the minimum of total fuel
    		the start should be the next index */
    private static int canCompleteCircuit(int[] gas, int[] cost) {
        int currGas = 0, ind = 0, lowestPoint = Integer.MAX_VALUE;
        for (int i = 0; i < gas.length; i++) {
            int dif = gas[i] - cost[i];
            currGas += dif;
            if (currGas < lowestPoint) {
                lowestPoint = currGas;
                ind = (i + 1) % gas.length;
            }
        }
        if (currGas < 0) return -1;   // return (total < 0) ? -1 : ind;
        else return ind;
    }
}