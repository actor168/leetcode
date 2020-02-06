class Problem109 {
	public static void main(String[] args) {
		
	}

	public TreeNode sortedListToBST(ListNode head) {
        int len = 0;
        ListNode p = head;
        List<Integer> list = new ArrayList<>();
        while(p != null) {
        	p = p.next;
        	len++;
        	list.add(p.val);
        }

        int[] arr = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
        	arr[i] = list.get(i);
        }

        return build(arr, 0, arr.length-1);
    }

    TreeNode build(int[] arr, int l, int r) {
    	if (l > r) return null;
    	if (l == r) {return new TreeNode(arr[l]);}
        int mid = (l + r) / 2;
    	TreeNode root = new TreeNode(arr[mid]);
    	root.left = build(arr, l, mid-1);
    	root.right = build(arr, mid+1, r);
        return root;
    } 
}