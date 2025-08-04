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
    public int sumNumbers(TreeNode root) {
        int[] sum = {0};
        dfs(root, 0, sum);
        return sum[0];

    }

    public void dfs(TreeNode root, int count, int[] sum){
        count = count*10 + root.val;
        if(root.left == null && root.right == null){
            sum[0] += count;
        }
        if(root.left!= null) dfs(root.left, count, sum);
        if(root.right!=null) dfs(root.right, count, sum);

    }

    
}