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
    public int[] findMode(TreeNode root) {
        ArrayList<Integer> arr = new ArrayList<>();
        inorder(root, arr);
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for(int num: arr){
             map.put(num, map.getOrDefault(num, 0) + 1);
            if(map.get(num) > count){
                count = map.get(num);
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue() == count){
                result.add(entry.getKey());
            }
        }

        int[] res = new int[result.size()];
        for(int i=0; i<res.length; i++){
            res[i] = result.get(i);
        }

        return res;

    }

    public void inorder(TreeNode root, ArrayList<Integer> arr){
        if(root == null){
            return;
        }
        inorder(root.left, arr);
        arr.add(root.val);
        inorder(root.right, arr);
    }
}