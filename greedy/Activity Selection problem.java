import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        var numOfIntervals = Integer.parseInt(in.readLine());
        List<Interval> intervals = new ArrayList<>();
        for (int i = 0; i < numOfIntervals; i++) {
            var input = in.readLine()
                        .split(" ");
            int from = Integer.parseInt(input[0]);
            int to = Integer.parseInt(input[1]);
            intervals.add(new Interval(from, to));
        }

        Collections.sort(intervals);

        List<Integer> result = new ArrayList<>();
        result.add(0);      // The interval that ends first should always be part of the solution
        int count = 1;      // Number of intervals should always be >0
        for (int i = 1; i < intervals.size(); i++) {
            if (!intervalsConflict(intervals.get(i), result, intervals)) {
                result.add(i);
                count++;
            }
        }

        System.out.println("Max acitvities count is " + count + "!");
        for (Integer integer : result) {
            System.out.println(intervals.get(integer));
        }
    }

    private static boolean intervalsConflict(Interval interval, List<Integer> result, List<Interval> intervals) {
        int start = interval.start;
        int end = interval.end;
        for (Integer res : result) {
            Interval currResInt = intervals.get(res);
            int cStart = currResInt.start;
            int cEnd = currResInt.end;
            if (!((cStart >= end && cEnd >= end) ||
                    (cStart <= start && cEnd <= start))) {
                return true;
            }
        }
        return false;
    }

    private static class Interval implements Comparable{
        int start;
        int end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Object o) {
            Interval i2 = (Interval) o;
            return Integer.compare(this.end, i2.end);
        }

        @Override
        public String toString(){
            return this.start + " " + this.end;
        }
    }
}