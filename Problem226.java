class Problem226 {
	public static void main(String[] args) {
		new Problem226.invertTree(null);
	}

	public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;
        TreeNode t = root.right;
        root.right = root.left;
        root.left = t;

		invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}