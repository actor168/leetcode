import java.util.ArrayList;
import java.util.List;

class Problem107 {

    public static void main(String[] args) {
        Problem107 p = new Problem107();
        
        TreeNode root = new TreeNode(1);/*
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.left.left = new TreeNode(8);
        root.left.left.right = new TreeNode(9);
        root.right.left.left = new TreeNode(10);
        root.right.left.right = new TreeNode(11);
        root.right.right.right = new TreeNode(12);*/
        System.out.println(p.levelOrderBottom(root));
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) {
            return new ArrayList<List<Integer>>();
        }
        List<TreeNode> nodes = new ArrayList<>();
        nodes.add(root);
        List<List<Integer>> integers = new ArrayList<>();
        List<Integer> res1 = traverse(nodes, integers);

        if (res1.size() > 0) {
            integers.add(res1);
        }
        
        //add root
        List<Integer> res2 = new ArrayList<>();
        res2.add(root.val);

        integers.add(res2);
        return integers;
    }

    List<Integer> traverse(List<TreeNode> nodes, List<List<Integer>> res) {
        List<TreeNode> subNodes = new ArrayList<>();
        List<Integer> integers = new ArrayList<>();
        if (nodes.size() <= 0 || nodes == null) {
            return integers;
        }
        for (TreeNode var : nodes) {
            if (var.left != null) {
                subNodes.add(var.left);
                integers.add(var.left.val);
            }

            if (var.right != null) {
                subNodes.add(var.right);
                integers.add(var.right.val);
            }
        }
        List<Integer> vals = traverse(subNodes, res);
        if (vals.size() > 0) res.add(vals);
        return integers;
    }

}