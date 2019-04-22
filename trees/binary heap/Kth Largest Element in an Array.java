import java.util.*;

public class Main {

    public static void main(String[] args){
        int[] lap = new int[]{3,2,1,5,6,4}; int k = 2;
//        int[] lap = new int[]{3,2,3,1,2,4,5,5,6}; int k = 1;
        System.out.println(findKthLargestMinHeap(lap, k));
    }

    /** Use a min-heap and keep only k elements in it. When (k+1)st element comes in 
     * pop out the smallest (which is on top). 
     * There is a faster divide and conquer solution using technique similar to quick sort.*/
    
    private static int findKthLargestMinHeap(int[] nums, int k) {
//        if (k > nums.length) return -666;
        Queue<Integer> heap = new PriorityQueue<>(new MinHeapComparator());
        for (int num : nums) {
            heap.offer(num);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        return heap.peek();
    }

    /** Push all elements to a max heap, then pop k elements, 
     *  so the last one popped is the needed one. */

    private static int findKthLargestMaxHeap(int[] nums, int k) {
        Queue<Integer> heap = new PriorityQueue<>(new MaxHeapComparator());
        for (int num : nums)
            heap.offer(num);
        int element = -1;
        for (int i = 0; i < k; i++) {
            element = heap.poll();
        }
        return element;
    }

    public static class MinHeapComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer i1, Integer i2) {
            return Integer.compare(i1, i2);         // => min heap, root is smallest
        }
    }

    public static class MaxHeapComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer i1, Integer i2) {
            return Integer.compare(i2, i1);         // => max heap, root is biggest
        }
    }
}
