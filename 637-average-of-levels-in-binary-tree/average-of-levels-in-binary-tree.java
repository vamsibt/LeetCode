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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();

        Queue<TreeNode> level = new LinkedList<>();
        if(root == null){
            return result;
        }
        level.add(root);

        while(!level.isEmpty()){
            int n = level.size();
            long sum = 0;
            for(int i=0; i<n; i++){
                TreeNode cur = level.poll();
                sum += cur.val;
                if(cur.left!=null) level.add(cur.left);
                if(cur.right!= null)level.add(cur.right);
            }

            double avg = (double)sum/n;

            result.add(avg);
        }

        return result;
    }
}