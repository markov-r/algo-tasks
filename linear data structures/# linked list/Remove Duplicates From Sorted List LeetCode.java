public class Main {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(3);

        ListNode result = deleteDuplicates(head);
        printList(result);
    }

    private static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode node = new ListNode(head.val);
        ListNode result = node;

        while (head != null) {
            if (head.val != node.val) {
                node.next = new ListNode(head.val);
                node = node.next;
            }
            head = head.next;
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