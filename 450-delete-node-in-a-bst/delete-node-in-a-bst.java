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
    public TreeNode deleteNode(TreeNode root, int key){
        if(root == null){
            return null;
        }
        if(key < root.val){
            root.left = deleteNode(root.left, key);
        } else if(key > root.val){
            root.right = deleteNode(root.right, key);
        } else{
            //Case 1 leaf:
            if(root.left == null && root.right == null){
                return null;
            }
            //One Child
            if(root.left == null){
                return root.right;
            } else if(root.right == null){
                return root.left;
            }
            //Two Child
            else {
                TreeNode maxLeft = findMax(root.left);  
                root.val = maxLeft.val;
                root.left = deleteNode(root.left, maxLeft.val); 
            }
        }
        return root;
    }  
    public TreeNode findMax(TreeNode node) {
        while (node.right != null) {
            node = node.right;
        }
        return node;
    } 
}