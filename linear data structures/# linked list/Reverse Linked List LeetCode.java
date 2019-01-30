import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        printList(reverseList(head));
    }

    private static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        if (head.next.next == null) { ListNode second = head.next; head.next.next = head; head.next = null; return second; }  //reverse links

        ListNode left = head;
        ListNode right = head.next;
        head.next = null;               //remove first link

        while (right.next != null) {
            ListNode third = right.next;
            right.next = left;
            left = right;
            right = third;
        }
        right.next = left;
        return right;
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
