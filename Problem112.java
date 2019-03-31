import java.util.LinkedList;
import java.util.Queue;

class Problem112 {

    public static void main(String[] args) {
        Problem112 p = new Problem112();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        System.out.println(p.hasPathSum(root, 8));
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;

        if (root.val == sum) {
            if (root.left == null && root.right == null) return true;
            return false;
        }

        return hasPathSum(root.left, sum-root.val) || hasPathSum(root.right, sum-root.val);
    }
}