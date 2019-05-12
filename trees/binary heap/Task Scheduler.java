import java.util.*;

public class Solution {

    public Solution() {
    }

    public static void main(String[] args) {
        System.out.println(new Solution().leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2));
//        System.out.println(new Solution().leastInterval(new char[]{'A', 'B', 'C', 'D'}, 2));
//        System.out.println(new Solution().leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B', 'Z', 'X', 'B', 'C', 'M', 'O'}, 2));
//        System.out.println(new Solution().leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'C'}, 2));
    }

    /** Maintain a max-heap that keeps the number of occurrences per letter.
     *  When a letter is used, put it in a buffer queue, which is emptied back
     *  to the heap, once the cooling interval is reached.
     *  When an empty interval is needed (the heap is empty), 
     *  put a dummy pair in the queue and also count the number of dummies,
     *  so if we're left with dummies only, we break the loop and return result. */
    
    public int leastInterval(char[] tasks, int cooling) {
        if (tasks.length == 0) return 0;
        int[] occurrences = new int[26];
        for (char task : tasks) {
            occurrences[task - 'A']++;
        }
        Queue<Pair> heap = new PriorityQueue<>(new MaxHeapComparator());
        for (int i = 0; i < occurrences.length; i++) {
            if (occurrences[i] > 0) {
                heap.add(new Pair(i + 'A', occurrences[i]));
            }
        }
        Queue<Pair> queue = new LinkedList<>();    
        int count = 0;
        int dummies = 0;
        StringBuilder sb = new StringBuilder();
        while (heap.size() > 0 || queue.size() > dummies) {
            if (heap.size() > 0){
                Pair pair = heap.poll();
                int num = pair.getKey();
                sb.append((char) num);
                if (pair.getValue() > 1) {
                    queue.add(new Pair(pair.getKey(), pair.getValue() - 1));
                } else {
                    queue.add(new Pair(-1,-1));
                    dummies++;
                }
            } else {
                queue.add(new Pair(-1,-1));
                dummies++;
                sb.append("_");
            }
            if (queue.size() > cooling) {
                Pair nextPair = queue.poll();
                if (nextPair.getValue() > -1) {
                    heap.add(nextPair);
                } else {
                    dummies--;
                }
            }
            count++;
        }
        System.out.println(sb);
        return count;
    }

    public class MaxHeapComparator implements Comparator<Pair> {
        @Override
        public int compare(Pair p1, Pair p2) {
            return Integer.compare(p2.getValue(), p1.getValue());         // => max heap
        }
    }

    public class Pair {
        Integer key;
        Integer value;

        public Pair(Integer key, Integer value) {
            this.key = key;
            this.value = value;
        }

        public Integer getKey() {
            return key;
        }

        public void setKey(Integer key) {
            this.key = key;
        }

        public Integer getValue() {
            return value;
        }

        public void setValue(Integer value) {
            this.value = value;
        }
    }
}