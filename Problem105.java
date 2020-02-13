import java.util.*;

class Problem105 {
	public static void main(String[] args) {
		
	}

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if (preorder.length <= 0) {return null;}
		TreeNode root = new TreeNode(preorder[0]);
		int i = 1;
		Map<Integer, Integer> pos = new HashMap<>();
        for(int j=0; j<inorder.length; j++) {
            pos.put(inorder[j], j);
        }
		Stack<TreeNode> s = new Stack<>();
		s.push(root);
       	while (i < preorder.length) {
        	
        	if (pos.get(preorder[i]) < pos.get(s.peek().val)) { // 节点在左子树
        		s.peek().left = new TreeNode(preorder[i]);
        		s.push(s.peek().left);
        	} else { // 节点在右子树，因为不存在相等值
        		TreeNode pre = null;
        		while(s.size()>0 && pos.get(s.peek().val) < pos.get(preorder[i])) {
        			pre = s.pop();
        		}
        		pre.right = new TreeNode(preorder[i]);
        		s.push(pre.right);
        	}
        	i++;
        }
        return root;
    }
}