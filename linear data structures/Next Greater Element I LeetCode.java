import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
        int nums1[] = {2,4};
        int nums2[] = {1,2,3,4};
        int[] result = nextGreaterElement(nums1, nums2);
        System.out.println(Arrays.toString(result));
    }

    private static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            int current = nums1[i];
            Queue<Integer> queue = new LinkedList<>();
            for (int num2 : nums2) {
                queue.offer(num2);
            }
            boolean valueSet = false;
            while (!queue.isEmpty()) {
                if (current == queue.poll()) {
                    while (!queue.isEmpty()) {
                        int next = queue.poll();
                        if (next > current) {
                            result[i] = next;
                            valueSet = true;
                            break;
                        }
                    }
                    break;
                }
            }
            if (!valueSet) {
                result[i] = -1;
            }
        }
        return result;
    }
}