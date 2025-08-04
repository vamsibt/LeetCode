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
    public void flatten(TreeNode root) {
        ArrayList<TreeNode> pre = new ArrayList<>();
        preOrder(pre, root);

        TreeNode current = root;
        for(int i=1; i<pre.size(); i++){
            TreeNode temp = pre.get(i);
            current.left = null;
            current.right = temp;
            current = current.right;
        }
    }

    public void preOrder(ArrayList<TreeNode> pre, TreeNode root){
        if(root == null){
            return;
        }

        pre.add(root);
        preOrder( pre, root.left);
        preOrder( pre, root.right);

    }



    
}