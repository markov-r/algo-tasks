public class Main {

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
//        node.next.next.next = new ListNode(4);
//        node.next.next.next.next = new ListNode(5);

//        removeNthFromEnd(node, 0);
        removeNthFromEnd(node, 1);
//        removeNthFromEnd(node, 2);
//        removeNthFromEnd(node, 3);
//        removeNthFromEnd(node, 4);
//        removeNthFromEnd(node, 5);
    }

    /** Use two pointers, with distance between them - n,
     *  so when the second pointer reaches end of list, 
     *  the first should be just before the node that has to be skipped.*/

    private static ListNode removeNthFromEnd(ListNode head, int n) {
        if (n == 0 || head == null) {
            printLList(head);
            return head;
        }
        ListNode first = head, offset = head;
        while (n > 0) {                 //offset -> shifted n times to the right
            offset = offset.next;
            n--;
        }

        if (offset == null) {       // if n == len (of list)
            printLList(first.next);
            return first.next;
        }
        if (offset.next == null) {  // if (n == len - 1)
            first.next = first.next.next;
            printLList(first);
            return first;
        }

        while (offset.next != null) {   //shift both offset and head until offset reaches end
            offset = offset.next;
            head = head.next;
        }

        head.next = head.next.next;     //now skip the needed n-th node
        printLList(first);
        return first;
    }

    private static void printLList(ListNode first) {
        while (first != null) {
            System.out.print(first.val + " ");
            first = first.next;
        }
        System.out.println();
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
