import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Deque<Integer> deque = new ArrayDeque<>();
        Set<Integer> set = new HashSet<>();
        int n = sc.nextInt();
        int m = sc.nextInt();
        int max = 0;
        boolean allUnique = false;

        for (int i = 0; i < n; i++) {
            int tmp = sc.nextInt();
            deque.add(tmp);
            set.add(tmp);

            if (deque.size() == m) {
                max = Math.max(set.size(), max);
                if (max == m) {
                    allUnique = true;
                    break;
                }
                int first = deque.removeFirst();
                if (!deque.contains(first)) {
                    set.remove(first);
                }
            }
        }
        if (allUnique) {
            System.out.println(m);
        } else {
            System.out.println(max);
        }
    }
}