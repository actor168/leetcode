public class Problem23 {
	public static void main(String[] args) {
		ListNode a = new ListNode(1);
		a.next = new ListNode(4);
		a.next.next = new ListNode(5);

		ListNode b = new ListNode(0);
		b.next = new ListNode(3);
		b.next.next = new ListNode(4);

		ListNode c = new ListNode(2);
		c.next = new ListNode(6);

		ListNode[] lists = new ListNode[]{a, b, c};

		ListNode res = new Problem23().mergeKLists(lists);
		ListNode p = res;
		for (; p.next != null ; p=p.next) {
			System.out.print(p.val + "->");
		}
		System.out.print(p.val);

	}

	public ListNode mergeKLists(ListNode[] lists) {
		int interval = 1;
		while (interval < lists.length) {
			for(int i = 0; i < lists.length - interval; i += interval * 2) {
				lists[i] = merge2Lists(lists[i], lists[interval + i]);
			}
			interval *= 2;
		}
		
        return lists[0];
    }

    // merge 2 lists
    ListNode merge2Lists(ListNode l1, ListNode l2) {
    	ListNode p = l1;
    	ListNode q = l2;
    	ListNode pre = null;
    	while (p!= null && q != null) {
    		if(q.val < p.val) {
    			// insert q before p
    			ListNode tmp = q.next;
    			if (pre != null) {
    				pre.next = q;
    				pre = q;
    			}
    			else {
    				pre = q;
    				l1 = pre;
    			}
    			pre.next = p;
    			q=tmp;
    		} else {
    			pre = p;
    			p = p.next;
    		}
    	}

    	if (p == null) {
    		if (pre != null) {
                pre.next = q;
            } else {
                pre = q; l1 =pre;
            }
    	}
    	return l1;
    }
}


class ListNode {
	int val;
 	ListNode next;
 	ListNode(int x) { val = x; }
}