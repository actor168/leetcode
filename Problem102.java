import java.util.*;

class Problem102 {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);

		System.out.println(new Problem102().levelOrder(root));
	}

	public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        q.add(root);
        // 先取出队列中的数，并写入左右子节点
        while(q.size() > 0) {
        	List<Integer> lev = new ArrayList<>();
        	int size = q.size();
        	for (int i = 0; i < size; i++) {
        		TreeNode node = q.remove();
        		if (node.left != null) q.add(node.left);
        		if (node.right != null)q.add(node.right);
        		lev.add(node.val);
        	}
        	res.add(lev);
        }
        return res;
    }
}