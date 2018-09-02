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
        if (head == null || head.next == null) {
            return head;
        }
        Stack<ListNode> stack = new Stack<>();
//        Stack<Integer> stack = new Stack<>();
//        stack.push(head.val);
        stack.push(head);
        while (head.next != null) {                           // rotate pointer to last element
//            stack.push(new ListNode(head.val));
            head = head.next;
//            stack.push(head.val);
            stack.push(head);
        }
        ListNode resultFilling = new ListNode(-1234567);
        ListNode result = resultFilling;
        while (!stack.isEmpty()) {
//            resultFilling.next = new ListNode(stack.pop());
            resultFilling.next = new ListNode(stack.pop().val);
            resultFilling = resultFilling.next;
        }
        return result.next;
    }

//    NOT WORKING RECURSIVE SOLUTION
//
//    private static ListNode reverseList(ListNode head) {
//        if (head == null || head.next == null) {
//            return head;
//        }
//        ListNode initial = head;
//        ListNode result = new ListNode(-123);
//        return reverseExtended(head, initial, result);
//    }
//
//    private static ListNode reverseExtended(ListNode head, ListNode initial, ListNode result) {
//        boolean listIsEmpty = true;
//        ListNode prev = new ListNode(-354);
//        while (head.next != null) {                           // rotate pointer to last element
//            prev = head;
//            head = head.next;
//            listIsEmpty = false;
//        }
//        if (listIsEmpty) {
//            return result.next;
//        }
//        result.next = new ListNode(head.val);
//        prev.next = null;
//        return reverseExtended(initial, initial, result);
//    }

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
