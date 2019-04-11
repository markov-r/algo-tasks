import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {

    public int[][] kClosest(int[][] points, int k) {
        if (points.length == 0 || points[0].length == 0)
            return points;
        int[][] closestPoints = new int[k][2];
        Queue<CoordinatesAndDistance> heap = new PriorityQueue<>(new MinHeapComparator());
        for (int[] point : points) {
            heap.offer(new CoordinatesAndDistance(point[0], point[1]));
        }
        for (int i = 0; i < k; i++) {
            CoordinatesAndDistance coordinate = heap.poll();
            closestPoints[i][0] = coordinate.getX();
            closestPoints[i][1] = coordinate.getY();
        }
        return closestPoints;
    }

    public class CoordinatesAndDistance {
        int x;
        int y;
        long distance; //real distance is Math.sqrt(distance)

        CoordinatesAndDistance(int x, int y) {
            this.x = x;
            this.y = y;
            distance = (long) x*x + y*y;
        }

        int getX() {
            return x;
        }

        void setX(int x) {
            this.x = x;
        }

        int getY() {
            return y;
        }

        void setY(int y) {
            this.y = y;
        }

        long getDistance() {
            return distance;
        }

        void setDistance(long distance) {
            this.distance = distance;
        }
    }

    public class MinHeapComparator implements Comparator<CoordinatesAndDistance> {
        @Override
        public int compare(CoordinatesAndDistance c1, CoordinatesAndDistance c2) {
            return Long.compare(c1.getDistance(), c2.getDistance());         // => min heap
        }
    }
}