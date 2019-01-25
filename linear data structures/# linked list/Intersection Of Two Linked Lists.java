public class Main {

    public static void main(String[] args) {
        ListNode first = new ListNode(4); first.next = new ListNode(1); first.next.next = new ListNode(8);
        ListNode second = new ListNode(5); second.next = new ListNode(0); second.next.next = new ListNode(1);
        System.out.println(getIntersectionNode(first, second));
    }

    /** Find the length of the shorter of the two lists,
     *  then align the two pointers so that they are on the
     *  same distance to the end of the respective list (equal to the shorter list's len).
     *  Then start iterating through both lists until you reach the intersection
     *  (otherwise said the the pointers become equal - point to the same object in memory).*/

    private static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = length(headA), lenB = length(headB);
        int diff = lenA - lenB;
        if (diff > 0) {
            while (diff > 0) {
                headA = headA.next;
                diff--;
            }
        } else {
            while (diff < 0) {
                headB = headB.next;
                diff++;
            }
        }
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headB;
    }

    private static int length(ListNode node) {
        int len = 0;
        while (node != null) {
            node = node.next;
            len++;
        }
        return len;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

}