
class Problem108 {

    public static void main(String[] args) {
        Problem108 p = new Problem108();
        int[] nums = {};
        System.out.println(p.sortedArrayToBST(nums));
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length <= 0) return null;
        int root = nums.length / 2;
        TreeNode rootNode = new TreeNode(nums[root]);

        rootNode.left = assign(nums, 0, root-1);
        rootNode.right = assign(nums, root+1, nums.length-1);

        return rootNode;
    }

    TreeNode assign(int[] nums, int left, int right) {
        TreeNode rootNode = null;
        if (right >= left) {
            int root = (right+left) / 2;
            rootNode = new TreeNode(nums[root]);
    
            rootNode.left = assign(nums, left, root-1);
            rootNode.right = assign(nums, root+1, right);
        }
        return rootNode;
    }
}