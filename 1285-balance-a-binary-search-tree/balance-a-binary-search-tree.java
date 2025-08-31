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
    public TreeNode balanceBST(TreeNode root) {
        ArrayList<TreeNode> arr = new ArrayList<>();
        inorder(root, arr);
        Collections.sort(arr, (a,b)-> a.val-b.val);
        return build_bst(arr, 0, arr.size()-1);
    }

    public void inorder(TreeNode root, ArrayList<TreeNode> arr){
        if(root == null){
            return;
        }
        inorder(root.left, arr);
        arr.add(root);
        inorder(root.right, arr);
    }

    public TreeNode build_bst(ArrayList<TreeNode> arr, int start, int end){
        if(start > end){
            return null;
        }
        int mid = start+ (end-start)/2;
        TreeNode root = arr.get(mid);
        root.left = build_bst(arr, start, mid-1);
        root.right = build_bst(arr, mid+1, end);

        return root;
    }
}