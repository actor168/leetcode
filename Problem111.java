import java.util.LinkedList;
import java.util.Queue;

class Problem111 {

    public static void main(String[] args) {
        Problem111 p = new Problem111();
        TreeNode root = new TreeNode(1);
        //root.left = new TreeNode(2);
        //root.right = new TreeNode(3);
        //root.left.right = new TreeNode(4);
        System.out.println(p.minDepth(root));
    }

    public int minDepth(TreeNode root) {

        int depth = 0;
        if (root == null) {
            return depth;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 1;
        int count = 0;
        while(queue.size() > 0) {
            count = queue.size();
            while(count>0) {
                count--;
                TreeNode t = queue.poll();
                if (t.left == null && t.right == null) return level;
                if (t.left != null) {
                    queue.add(t.left);
                }
                if (t.right != null) {
                    queue.add(t.right);
                }
            }
            level++;
        }
        return 0;
    }
}