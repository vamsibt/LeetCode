/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class BSTIterator {
    Queue<TreeNode> inorderQueue;
    public BSTIterator(TreeNode root) {
        this.inorderQueue = new LinkedList<>();
        inorder(root);
    }

    public void inorder(TreeNode root){
        if(root == null) return;
        inorder(root.left);
        inorderQueue.add(root);
        inorder(root.right);
    }
    
    public int next() {
        TreeNode temp = inorderQueue.poll();
        return temp.val;
    }
    
    public boolean hasNext() {
        if(!inorderQueue.isEmpty()) return true;
        return false;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */