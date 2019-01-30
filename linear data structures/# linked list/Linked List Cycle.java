public class Main {

    public static void main(String[] args) {
        ListNode asd = new ListNode(5);
//        asd.next = new ListNode(4);
//        asd.next.next = new ListNode(3);
//        asd.next.next.next = new ListNode(2);
//        asd.next.next.next.next = new ListNode(1);
//        asd.next.next.next.next = asd.next;
        System.out.println(hasCycle(asd));

        }

    /** Maintain two pointers with speed 1 and 2.
     *  If the slower pointer reaches the fast there is a cycle. */

    private static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }

    public static class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
    }
}