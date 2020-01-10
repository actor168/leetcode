public class SwapNodes {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode p = new SwapNodes().swapPairs(head);
        while(p != null) {
            System.out.print(p.val);
            p = p.next;
        }
    }

    public ListNode swapPairs(ListNode head) {
        if (head != null && head.next != null) {
            int tmp = head.val;
            head.val = head.next.val;
            head.next.val = tmp;
            swapPairs(head.next.next);
        }
        return head;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}