public class Main {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        int k = 2;
        ListNode result = rotateRight(head, k);
        printList(result);
    }

    private static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        ListNode initial = head;                //save the list head

        int count = 0;
        while (head.next != null) {
            count++;                                // rotate pointer to last element
            head = head.next;
        }
        head.next = initial;                    // CONNECT TAIL TO HEAD
        k = k % (count + 1);                    // if k > count + 1, scale it down
        if (k == 0) {                           // if k becomes 0 return the initial list
            head.next = null;
            return initial;
        }
        for (int i = 0; i < k - 1; i++) {           // Pointer is at last elem, so need to rotate k-1 times to go to right place
            for (int j = 0; j < count; j++) {
                head = head.next;
            }
        }

        ListNode result = new ListNode(head.val);   // Now build up list from the proper starting pointer
        ListNode node = result;
        for (int i = 0; i < count; i++) {
            head = head.next;
            node.next = new ListNode(head.val);
            node = node.next;
        }
        return result;
    }

    private static void printList(ListNode x) {
        while (x != null) {
            System.out.print(x.val + " ");
            x = x.next;
        }
        System.out.println();
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}