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
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            Map<Integer, Integer> map = new HashMap<>();

            for(int i=0; i<inorder.length; i++){
                map.put(inorder[i] , i);
            }
            return recursion(0, postorder.length-1, 0, inorder.length-1, postorder, inorder, map);
        }

        public TreeNode recursion(int postStart, int postEnd, int inStart, int inEnd, int[] postorder, int[] inorder, Map<Integer, Integer> inorderMap){
            if(postStart > postEnd || inStart > inEnd) return null;

            TreeNode root = new TreeNode(postorder[postEnd]);
            int rootIdx = inorderMap.get(root.val);

            int leftSize = rootIdx- inStart;

            root.left = recursion(postStart, postStart+leftSize-1, inStart, rootIdx-1, postorder, inorder, inorderMap);
            root.right = recursion(postStart+leftSize, postEnd-1, rootIdx+1, inEnd, postorder, inorder, inorderMap);

            return root;
        }


    }