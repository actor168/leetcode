class Problem19 {
	public static void main(String[] args) {
		
	}

	public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode del = head, end = head;
        for (int i = 0; i <= n; i++) {
        	end = end.next;
        }

        while (end.next != null) {
        	end = end.next;
        	del = del.next;
        }
        del.next = del.next.next;
        return head;
    }

}