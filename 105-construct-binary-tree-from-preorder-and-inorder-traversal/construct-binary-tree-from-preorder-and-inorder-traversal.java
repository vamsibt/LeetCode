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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //In preOrder first element is the root
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i], i);
        }

        return recursive(0, preorder.length-1, 0, inorder.length-1, preorder, inorder, map);


        
    }

    public TreeNode recursive(int preStart, int preEnd, int inStart, int inEnd , int[] preorder, int[] inorder, Map<Integer, Integer> inorderMap){
        if(preStart > preEnd || inStart > inEnd) return null;
        TreeNode root = new TreeNode(preorder[preStart]);

        int rootIdx = inorderMap.get(root.val);
        int leftSize = rootIdx - inStart;

        root.left = recursive(preStart+1, preStart+leftSize, inStart, rootIdx-1, preorder, inorder, inorderMap);
        root.right = recursive(preStart+leftSize+1, preEnd, rootIdx+1,inEnd,preorder, inorder, inorderMap);

        return root;
    }
}