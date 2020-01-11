class Problem141 {
    public static void main(String[] args) {
    }

    public boolean hasCycle(ListNode head) {
        // reverse list and judge if the head equals current head
        if (head == null || head.next == null) {
            return false;
        }

        ListNode pre = null, next = null;

        ListNode p = head;
        while (p != null) {
            next = p.next;
            p.next = pre; 
            pre = p;
            p = next;
        }

        return pre == head;
    }
}