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
    int sum =0;
    public TreeNode convertBST(TreeNode root) {
        HashMap<Integer, Integer> map = new HashMap<>();
        inorder(root, map);
        build(root, map);
        return root;
    }

    public void inorder(TreeNode root, HashMap<Integer, Integer> map){
        if(root == null){
            return;
        }
        inorder(root.left,map);
        sum += root.val;
        map.put(root.val, sum);
        inorder(root.right,map);
    }

    public void build(TreeNode root, HashMap<Integer, Integer> map){
        if(root == null){
            return;
        }

        root.val = sum-map.get(root.val)+root.val;
        build(root.left, map);
        build(root.right, map);
    }

    
}