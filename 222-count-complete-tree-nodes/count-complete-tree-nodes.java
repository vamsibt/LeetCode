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
    public int countNodes(TreeNode root) {
        // Queue<TreeNode> level = new LinkedList<>();
        // if(root == null){
        //     return 0;
        // }
        // level.add(root);
        // int count =1;
        // while(!level.isEmpty()){
        //     TreeNode temp = level.poll();

        //     if(temp.left!=null){
        //         level.add(temp.left);
        //         count++;
        //     } 
        //     if(temp.right!=null) {
        //         level.add(temp.right);
        //         count++;
        //     }
        // }

        // return count;

        if(root == null){
            return 0;
        }

        int leftH = leftHeight(root);
        int rightH = rightHeight(root);

        if(leftH == rightH){
            return (1 << leftH) - 1;
        }

        return 1+countNodes(root.left)+countNodes(root.right);

    }

    public int leftHeight(TreeNode root){
        int h = 0;
        while(root!= null){
            root = root.left;
            h++;
        }
        return h;
    }

    public int rightHeight(TreeNode root){
        int h =0;
        while(root!=null){
            root = root.right;
            h++;
        }
        return h;
    }

}