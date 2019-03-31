class Problem110 {

    public static void main(String[] args) {
        Problem110 p = new Problem110();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(4);
        root.left.left.left.left = new TreeNode(5);
        System.out.println(p.isBalanced(root));
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;

        int rightHeight = height(root.right);
        int leftHeight = height(root.left);

        if (rightHeight <0 || leftHeight <0) {
            return false;
        }

        if (Math.abs(leftHeight - rightHeight) <= 1) {
            return true;
        }
        
        return false;
    }

    int height(TreeNode root) {
        if (root == null) return 0;
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        int err = Math.abs(leftHeight - rightHeight);
        if ( err > 1 || err < 0) {
            return Integer.MIN_VALUE;
        }
        int val = Math.max(leftHeight, rightHeight) + 1;
        return val;
    }
}