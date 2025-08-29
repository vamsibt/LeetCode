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
class Solution {
    TreeNode prev= null;
    int minDiff = Integer.MAX_VALUE;

    public int minDiffInBST(TreeNode root) {
        inorder(root);
        return minDiff;
    }

    public void inorder(TreeNode root){
        if(root == null) return;
        inorder(root.left);

        if(prev != null && Math.abs(prev.val-root.val) < minDiff){
            minDiff = Math.abs(prev.val-root.val);
        }
        prev = root;

        inorder(root.right);
    }
}