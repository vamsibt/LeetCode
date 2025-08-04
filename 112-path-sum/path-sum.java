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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        boolean[] flag = new boolean[1];
        dfs(root, 0, flag, targetSum);

        return flag[0];
    }

    public void dfs(TreeNode root, int sum, boolean[] flag, int targetSum){
        
        if(root == null || flag[0]) return;
        int localSum = sum+root.val;

        if(root.left == null && root.right== null && localSum == targetSum){
            flag[0] = true;
            return;
        }
        dfs(root.left, localSum, flag, targetSum);
        dfs(root.right, localSum, flag, targetSum);
    }
}