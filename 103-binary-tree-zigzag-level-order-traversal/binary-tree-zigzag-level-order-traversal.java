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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        Queue<TreeNode> level = new LinkedList<>();

        if(root == null){
            return result;
        }

        level.add(root);
        boolean flag = true;
        while(!level.isEmpty()){
            int n = level.size();

            List<Integer> current = new ArrayList<>();
            for(int i=0; i<n;i++){
                TreeNode cur = level.poll();
                current.add(cur.val);
                if(cur.left!=null) level.add(cur.left);
                if(cur.right!=null) level.add(cur.right);

            }

            if(flag){
                flag = false;
                result.add(current);
                
            } else{
                flag = true;
                int i=0;
                int j=current.size()-1;

                while(i< j){
                    int temp = current.get(i);
                    current.set(i, current.get(j));
                    current.set(j, temp);
                    i++;
                    j--;
                }

                result.add(current);
            }

        }

        return result;
    }
}