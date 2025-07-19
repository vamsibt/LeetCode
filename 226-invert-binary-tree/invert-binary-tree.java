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
    public TreeNode invertTree(TreeNode root) {
        TreeNode left = root;
        TreeNode right = root;
        if(root == null){return null;}
        Queue<TreeNode> que = new LinkedList<>();

        que.add(root);
        while(!que.isEmpty()){
            TreeNode cur = que.remove();
            if(cur== null){
                continue;
            }
            que.add(cur.left);
            que.add(cur.right);

            left = cur.left;
            right = cur.right;

            cur.left = right;
            cur.right = left;

        }

        return root;
    }
}