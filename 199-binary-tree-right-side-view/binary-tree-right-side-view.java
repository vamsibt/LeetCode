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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        LinkedList<TreeNode> levels = new LinkedList<>();
        levels.add(root);
        while(!levels.isEmpty()){
            int n= levels.size();
            int value = levels.get(n-1).val;
            result.add(value);
            for(int i=0; i<n; i++){
                TreeNode cur = levels.remove(0);
                if(cur.left!= null) levels.add(cur.left);
                if(cur.right!=null) levels.add(cur.right);
            }
        }

        return result;
    }
}