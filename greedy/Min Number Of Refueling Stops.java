import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {

    public Solution() {
    }

    public static void main(String[] args) {
//        System.out.println(new Solution().minRefuelStopsBackTrack(100, 10, new int[][] {{10,60},{20,30},{30,30},{60,40}}));
//        System.out.println(new Solution().minRefuelStopsBackTrack(100, 1, new int[][] {{10,100}}));
//        System.out.println(new Solution().minRefuelStopsBackTrack(1, 1, new int[][] {{}}));
//        System.out.println(new Solution().minRefuelStopsBackTrack(100, 50, new int[][] {{50, 50}}));
//        System.out.println(new Solution().minRefuelStopsBackTrack(100, 25, new int[][]{{25, 25}, {50, 25}, {75, 25}}));
//        System.out.println(new Solution().minRefuelStopsBackTrack(100, 50, new int[][]{{25, 25}, {50, 50}}));
//        System.out.println(new Solution().minRefuelStopsBackTrack(100, 1, new int[][]{{10, 100}}));
//        System.out.println(new Solution().minRefuelStopsGreedy(1000, 10, new int[][]{{7, 217}, {10, 211}, {17, 146}, {21, 232}, {25, 310}, {48, 175}, {53, 23}, {63, 158}, {71, 292}, {96, 85}, {100, 302}, {102, 295}, {116, 110}, {122, 46}, {131, 20}, {132, 19}, {141, 13}, {163, 85}, {169, 263}, {179, 233}, {191, 169}, {215, 163}, {224, 231}, {228, 282}, {256, 115}, {259, 3}, {266, 245}, {283, 331}, {299, 21}, {310, 224}, {315, 188}, {328, 147}, {345, 74}, {350, 49}, {379, 79}, {387, 276}, {391, 92}, {405, 174}, {428, 307}, {446, 205}, {448, 226}, {452, 275}, {475, 325}, {492, 310}, {496, 94}, {499, 313}, {500, 315}, {511, 137}, {515, 180}, {519, 6}, {533, 206}, {536, 262}, {553, 326}, {561, 103}, {564, 115}, {582, 161}, {593, 236}, {599, 216}, {611, 141}, {625, 137}, {626, 231}, {628, 66}, {646, 197}, {665, 103}, {668, 8}, {691, 329}, {699, 246}, {703, 94}, {724, 277}, {729, 75}, {735, 23}, {740, 228}, {761, 73}, {770, 120}, {773, 82}, {774, 297}, {780, 184}, {791, 239}, {801, 85}, {805, 156}, {837, 157}, {844, 259}, {849, 2}, {860, 115}, {874, 311}, {877, 172}, {881, 109}, {888, 321}, {894, 302}, {899, 321}, {908, 76}, {916, 241}, {924, 301}, {933, 56}, {960, 29}, {979, 319}, {983, 325}, {988, 190}, {995, 299}, {996, 97}}));
//        System.out.println(new Solution().minRefuelStopsHeap(1000, 10, new int[][]{{7, 217}, {10, 211}, {17, 146}, {21, 232}, {25, 310}, {48, 175}, {53, 23}, {63, 158}, {71, 292}, {96, 85}, {100, 302}, {102, 295}, {116, 110}, {122, 46}, {131, 20}, {132, 19}, {141, 13}, {163, 85}, {169, 263}, {179, 233}, {191, 169}, {215, 163}, {224, 231}, {228, 282}, {256, 115}, {259, 3}, {266, 245}, {283, 331}, {299, 21}, {310, 224}, {315, 188}, {328, 147}, {345, 74}, {350, 49}, {379, 79}, {387, 276}, {391, 92}, {405, 174}, {428, 307}, {446, 205}, {448, 226}, {452, 275}, {475, 325}, {492, 310}, {496, 94}, {499, 313}, {500, 315}, {511, 137}, {515, 180}, {519, 6}, {533, 206}, {536, 262}, {553, 326}, {561, 103}, {564, 115}, {582, 161}, {593, 236}, {599, 216}, {611, 141}, {625, 137}, {626, 231}, {628, 66}, {646, 197}, {665, 103}, {668, 8}, {691, 329}, {699, 246}, {703, 94}, {724, 277}, {729, 75}, {735, 23}, {740, 228}, {761, 73}, {770, 120}, {773, 82}, {774, 297}, {780, 184}, {791, 239}, {801, 85}, {805, 156}, {837, 157}, {844, 259}, {849, 2}, {860, 115}, {874, 311}, {877, 172}, {881, 109}, {888, 321}, {894, 302}, {899, 321}, {908, 76}, {916, 241}, {924, 301}, {933, 56}, {960, 29}, {979, 319}, {983, 325}, {988, 190}, {995, 299}, {996, 97}}));
        System.out.println(new Solution().minRefuelStopsHeap(1000, 299, new int[][] {{13,21},{26,115},{100,47},{225,99},{299,141},{444,198},{608,190},{636,157},{647,255},{841,123}}));
//        System.out.println(new Solution().minRefuelStopsGreedy(1000, 299, new int[][] {{13,21},{26,115},{100,47},{225,99},{299,141},{444,198},{608,190},{636,157},{647,255},{841,123}}));
//        System.out.println(new Solution().minRefuelStopsBackTrack(1000, 299, new int[][] {{13,21},{26,115},{100,47},{225,99},{299,141},{444,198},{608,190},{636,157},{647,255},{841,123}}));
    }

    private static int minCount;

    /** Standard backtracking solution - gets TLE */

    public int minRefuelStopsBackTrack(int target, int startFuel, int[][] stations) {
        minCount = Integer.MAX_VALUE;
        findMinStops(target, startFuel, stations, 0, 0);
        return minCount == Integer.MAX_VALUE ? -1 : minCount;
    }

    public void findMinStops(int target, int curFuel, int[][] stations, int count, int position) {
        if (curFuel + position >= target) {
            minCount = Math.min(count, minCount);
            return;
        }

        for (int i = 0; i < stations.length; i++) {
            if (stations[i][0] <= position) {
                continue;
            }
            if (stations[i][0] > curFuel + position) {
                break;
            }
            curFuel += stations[i][1] - stations[i][0] + position;
            count++;
            findMinStops(target, curFuel, stations, count, stations[i][0]);
            curFuel -= stations[i][1] - stations[i][0] + position;
            count--;
        }
    }


    /** A greedy solution using binary heap.
     *  Add all reachable stations' fuel in a max heap (keep biggest on top)
     *  Then pop the max (top node) from heap and add to current fuel and
     *  continue adding reachable stations.
     *  In brief - always use the stations with max fuel, but unlike the other greedy solution
     *  you return -1 (no solution) only when there are no stations left (in the heap). */

    public int minRefuelStopsHeap(int target, int startFuel, int[][] stations) {
        int idx = 0, fuel = 0;
        Queue<Integer> pq = new PriorityQueue<>(new MaxHeapComparator());
        pq.offer(startFuel);
        for (int count = 0; pq.size() > 0; count++) {
            int current = pq.poll();
            fuel += current;
            if (fuel >= target) {
                return count;
            }
            while (idx < stations.length && stations[idx][0] <= fuel) {
                pq.offer(stations[idx][1]);
                idx++;
            }
        }
        return -1;
    }

    public class MaxHeapComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer i1, Integer i2) {
            return Integer.compare(i2, i1);         // => max heap
        }
    }

    /** Greedy solution that fails
     * From the list of reachable stations from current station always choose the one
     * that can take us furthest (the one with the most fuel).
     * Fails when the station with most fuel is not the right choice (when there are
     * stations with less fuel along the way which you need to visit in order to gather up
     * fuel to overcome a further obstacle. */
    public int minRefuelStopsGreedy(int target, int startFuel, int[][] stations) {
        if (startFuel >= target) {
            return 0;
        }
        int count = 0; int maxFuel = 0; int position = -1; int fuel = 0; boolean stationFound = false;
        for (int i = 0; i < stations.length; i++) {
            if (stations[i][0] > startFuel) {
                break;
            }
            if (stations[i][1] > maxFuel) {
                maxFuel = stations[i][1];
                position = i;
                stationFound = true;
            }
        }
        if (stationFound) {
            count++;
            fuel = startFuel + stations[position][1] - stations[position][0]; //fuel at this station
        } else {
            return -1;
        }


        while (position < stations.length) {
//        while (true) {
            int k = -1;
            maxFuel = 0;
            stationFound = false;
            if (stations[position][0] + fuel >= target) {
                return count;
            }
            for (int i = position + 1; i < stations.length; i++) {
                if (stations[i][0] > fuel + stations[position][0]) { //stations become unreachable
                    break;
                }
                if (stations[i][1] > maxFuel) {
                    maxFuel = stations[i][1];
                    k = i;
                    if (!stationFound) {
                        count++;            //to step up count only once
                        stationFound = true;
                    }
                }
            }
            if (k > -1) {
                fuel += stations[k][1] - stations[k][0] + stations[position][0]; //update fuel at newly chosen station
                position = k;
            } else {
                return -1;
            }

        }
        return count;
    }

}