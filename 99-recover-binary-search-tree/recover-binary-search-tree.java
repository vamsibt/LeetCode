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
    // public void recoverTree(TreeNode root) {
    //     ArrayList<TreeNode> arr = new ArrayList<>();
    //     inorder(root,arr);
    //     TreeNode left = null;
    //     int idx= 0;
    //     TreeNode right = null;

    //     for(int i=0; i<arr.size()-1; i++){
    //         if(arr.get(i).val > arr.get(i+1).val){
    //             if(left == null){
    //                 left = arr.get(i);
    //                 idx = i;
    //             } else{
    //                 right = arr.get(i+1);
    //                 break;
    //             }
    //         }
    //     }

    //     if(right ==null){
    //         right = arr.get(idx+1);
    //     }

    //     int temp = left.val;
    //     left.val = right.val;
    //     right.val = temp;

    // }

    // public void inorder(TreeNode root, ArrayList<TreeNode> arr){
    //     if(root == null){
    //         return;
    //     }
    //     inorder(root.left, arr);
    //     arr.add(root);
    //     inorder(root.right, arr);
    // }

    TreeNode prev = null;
    TreeNode left = null;
    TreeNode right = null;
    public void recoverTree(TreeNode root) {
        inorder(root);
        if(right == null){
            right = prev;
        }
        int temp = left.val;
        left.val = right.val;
        right.val = temp;
    }

    public void inorder(TreeNode root){
        if(root == null){
            return;
        }
        inorder(root.left);
        if(prev != null && prev.val > root.val){
            if(left == null){
                left = prev;
                right = root;
            } else{
                right = root;
            }
        }
        prev = root;
        inorder(root.right);
    }
}