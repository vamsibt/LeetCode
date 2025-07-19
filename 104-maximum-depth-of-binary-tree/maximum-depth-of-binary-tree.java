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
    public int maxDepth(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<>();
        if(root == null){return 0;}

        que.add(root);
        int depth =0;

        while(!que.isEmpty()){
            int levelSize = que.size();
            for(int i=0; i<levelSize; i++){
                TreeNode cur = que.remove();
                if(cur.left!= null){ que.add(cur.left);}
                if(cur.right!=null){ que.add(cur.right); }
            }
            depth++;
        }

        return depth;
    }
}