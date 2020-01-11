class Problem83 {
    public static void main(String[] args) {
        Problem83 p = new Problem83();
        ListNode node = new ListNode(1);
        node.next = new ListNode(1);
        node.next.next = new ListNode(1);
        node.next.next.next = new ListNode(1);
        node.next.next.next.next = new ListNode(4);
        ListNode head = p.deleteDuplicates(node);
        ListNode cur = head;
        while(cur != null) {
            System.out.print(cur.val + ",");
            cur = cur.next;
        }
        
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        
        ListNode pre = head;
        ListNode cur = head.next;

        while (cur != null) {
            if (cur.val == pre.val) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }
}