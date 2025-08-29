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
    HashMap<Integer, Integer> map = new HashMap<>();
    public boolean findTarget(TreeNode root, int k) {
        inorder(root, k);
        for(int key: map.keySet()){
            if(map.containsKey(map.get(key)) && map.get(key) != key){
                return true;
            }
        }
        return false;
    }
    public void inorder(TreeNode root, int k){
        if(root == null){
            return;
        }
        inorder(root.left,k);
        map.put(root.val, k-root.val);
        inorder(root.right,k);
    }
}