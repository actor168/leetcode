import java.util.ArrayList;

class HasSubTree {

	public static void main(String[] args) {
		TreeNode root1 = new TreeNode(8);
		root1.right = new TreeNode(8);
		root1.right.right = new TreeNode(9);
		root1.right.right.right = new TreeNode(2);
		root1.right.right.right.right = new TreeNode(5);

		TreeNode root2 = new TreeNode(8);
		root2.right = new TreeNode(9);
		root2.right.left= new TreeNode(3);
		root2.right.right = new TreeNode(2);
		
		System.out.println(new HasSubTree().hasSubtree(root2, root1));
	}


	public boolean hasSubtree(TreeNode root1,TreeNode root2) {
        ArrayList<TreeNode> l1 = new ArrayList<>();
        ArrayList<TreeNode> l2 = new ArrayList<>();
        
        traverse(l1, root1);
        traverse(l2, root2);
        
        if (l1.size() == 0 || l2.size() == 0) return false;
        if (l1.size() == l2.size()) return equals(root1, root2) || equals(root2, root1);
        
        if (l1.size() < l2.size()) {// 判断 root1 是 root2的子树
            for(TreeNode t : l2) {
                if (t.val == l1.get(0).val){ // 开始迭代遍历
                    boolean res = equals(t, l1.get(0));
                    if (res) return true; 
                }
            }
            return false;
        } else { // 判断 root2 是 root1 的子树
            for(TreeNode t : l1) {
                if (t.val == l2.get(0).val){ // 开始迭代遍历
                    boolean res = equals(l2.get(0), t);
                    if (res) return true; 
                }
            }
            return false;
        }
    }
    
    void traverse(ArrayList<TreeNode> list, TreeNode root) {
        if (root == null) return;
        list.add(root);
        traverse(list, root.left);
        traverse(list, root.right);
    }
    
    boolean equals(TreeNode a, TreeNode b) {
        if (a == null && null == b) return true;
        if (a == null) return false;
        if (b == null) return true;
        if (a.val == b.val) {
            return equals(a.left, b.left) && equals(a.right, b.right);
        }
        return false;
    }
}