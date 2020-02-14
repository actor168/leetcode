import java.util.*;

class Problem98 {
	public static void main(String[] args) {
	}

	/**
	10 

	5 15 

	  6 20
	*/
	List<Integer> list = new ArrayList<>();

	public boolean isValidBST(TreeNode root) {
        // 中序遍历，然后看是否都递增
        traverse(root);

        if (list.size <= 1) return true;
        int pre = list.get(0);
        for (int i = 1; i < list.size(); i++) {
        	int cur = list.get(i);
        	if (cur <= pre) return false;
        	pre = list.get(i);
        }
        return true;
    }

    void traverse(TreeNode root) {
    	if (root == null) return;
    	traverse(root.left);
    	list.add(root);
    	traverse(root.right);
    }
}