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
    TreeNode cur = new TreeNode(-1);
    TreeNode temp = cur;
    public TreeNode increasingBST(TreeNode root) {
        inorder(root);

        return cur.right;
    }
    public void inorder(TreeNode root){
        if(root == null) return;
        inorder(root.left);

        temp.right = root;
        root.left = null;
        temp = temp.right;

        inorder(root.right);
    }
}