import java.util.*;

public class Solution {

    public static int solveSuperMarketQueue(int[] customers, int n) {
      Queue<Integer> pq = new PriorityQueue<>();
      
      for (int i = 0; i < n; i++) {
         pq.add(0);
      }
      
      for (int customer : customers) {
        int smallest = pq.poll();
        pq.add(smallest + customer);
      }
      
      int last = Integer.MIN_VALUE;
      while (!pq.isEmpty()) {
        last = pq.poll();  
      }
	  
      return last;
    }
}