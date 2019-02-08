public class Main {

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
//        node.next.next = new ListNode(1);
//        node.next.next.next = new ListNode(2);
//        node.next.next.next.next = new ListNode(1);

        System.out.println(isPalindrome(node));
    }

    /** - Find the middle
     *  - Mark the second half
     *  - Reverse the first half
     *  - Compare first with second
     *  Instead of calculating the size we can use two pointers -
     *  fast - jumping 2 nodes, and slow - going through each node,
     *  so when fast reaches end, the slow should be at the middle.
     *  This might be slightly faster than calculating the length.*/

    private static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode first = head;
        int n = calcSize(head);
        int count = n / 2 - 1;
        while (count-- > 0)
            head = head.next;
        ListNode second =  (n % 2 == 0) ? head.next : head.next.next;
        head.next = null;
        ListNode reversed = reverseList(first);
        while (reversed != null) {
            if (reversed.val != second.val)
                return false;
            reversed = reversed.next;
            second = second.next;
        }
        return true;
    }

    private static int calcSize(ListNode node) {
        int count = 0;
        while (node != null) {
            count++;
            node = node.next;
        }
        return count;
    }

    private static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        if (head.next.next == null) {
            ListNode second = head.next;
            head.next.next = head;
            head.next = null;
            return second;
        }  //reverse links
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

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}