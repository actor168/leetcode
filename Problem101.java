class Problem101 {
    public static void main(String[] args) {
        Problem101 p = new Problem101();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        System.out.println(p.isSymmetric(root));
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isSame(root.left, root.right);
    }
    
    boolean isSame(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val == q.val) {
            return isSame(p.left, q.right) && isSame(p.right, q.left);
        }
        return false;
    }
}