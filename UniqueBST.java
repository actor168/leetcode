import java.util.ArrayList;
import java.util.List;

/**
 * 1 2 3 4 5 6
 * 1 
 *   2 3 4 5 6
 * 
 * 1
 *   2
 *     3 4 5 6
 * 
 */
class UniqueBST {
    public List<TreeNode> generateTrees(int n) {
        return gen(1, n);
    }

    public List<TreeNode> gen(int left, int right) {
        List<TreeNode> list = new ArrayList<TreeNode>();

        if (left > right) {
            list.add(null);
            return list;
        }

        if (left == right) {
            list.add(new TreeNode(left));
            return list;
        }

        List<TreeNode> leftTrees, rightTrees;
        for (int i = left; i <= right; i++) {
            leftTrees = gen(left, i-1);
            rightTrees = gen(i+1, right);

            for(TreeNode lnode: leftTrees)
            {
                for(TreeNode rnode: rightTrees)
                {
                    TreeNode root = new TreeNode(i);
                    root.left = lnode;
                    root.right = rnode;
                    list.add(root);
                }
            }
        }
        return list;
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}