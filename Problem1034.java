class Problem1034 {
    public static void main(String[] args) {
        
    }

    int sum = 0;

    public TreeNode bstToGst(TreeNode root) {
        // 逆 先序遍历

        if (root.right != null) {
            bstToGst(root.right); 
        }
        
        root.val += sum;
        sum = root.val;

        if (root.left != null) {
            bstToGst(root.left);
        }  

        return root;
    }

}