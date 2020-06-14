package leetcode.editor.cn;
//Implement an iterator over a binary search tree (BST). Your iterator will be i
//nitialized with the root node of a BST. 
//
// Calling next() will return the next smallest number in the BST. 
//
// 
//
// 
// 
//
// Example: 
//
// 
//
// 
//BSTIterator iterator = new BSTIterator(root);
//iterator.next();    // return 3
//iterator.next();    // return 7
//iterator.hasNext(); // return true
//iterator.next();    // return 9
//iterator.hasNext(); // return true
//iterator.next();    // return 15
//iterator.hasNext(); // return true
//iterator.next();    // return 20
//iterator.hasNext(); // return false
// 
//
// 
//
// Note: 
//
// 
// next() and hasNext() should run in average O(1) time and uses O(h) memory, wh
//ere h is the height of the tree. 
// You may assume that next() call will always be valid, that is, there will be 
//at least a next smallest number in the BST when next() is called. 
// 
// Related Topics 栈 树 设计

//leetcode submit region begin(Prohibit modification and deletion)

import java.util.Stack;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode(int x) { val = x; } }
 */
class BSTIterator {

    // 指针指向当前节点最小节点的父节点
    private Stack<TreeNode> xps = new Stack<>();

    public BSTIterator(TreeNode root) {
        for (TreeNode x = root; x != null; x = x.left) {
            this.xps.push(x);
        }
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        TreeNode cur = xps.pop();

        for (TreeNode x = cur.right; x != null; x = x.left) {
            this.xps.push(x);
        }

        return cur.val;
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return xps.size() > 0;
    }

    /*private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }*/
}

/**
 * Your BSTIterator object will be instantiated and called as such: BSTIterator obj = new
 * BSTIterator(root); int param_1 = obj.next(); boolean param_2 = obj.hasNext();
 */
//leetcode submit region end(Prohibit modification and deletion)


