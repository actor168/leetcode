class Problem617 {
	public static void main(String[] args) {
		
	}

	public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) return t2;
        if (t2 == null) return t1;
		mergeTrees1(t1, t2);
		return t1;
    }

	public void mergeTrees1(TreeNode t1, TreeNode t2) {
		if (t1 == null || t2 == null) return;
		if (t1.left == null) {
            t1.left = t2.left;
            t2.left = null;
        }
		mergeTrees1(t1.left, t2.left);
    	if (t1 != null && t2 != null) t1.val += t2.val;
    	if (t1.right == null) {
            t1.right = t2.right;
            t2.right = null;
        }
    	mergeTrees1(t1.right, t2.right);
    }
}