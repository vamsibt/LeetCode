/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preorder(root, sb);
        if(sb.length()>0){
            sb.setLength(sb.length() - 1);
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.isEmpty()){
            return null;
        }
        String[] values = data.split(",");
        int[] idx = new int[1];
        //idx[0] = 0;
        return buildBst(values,idx, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public TreeNode buildBst(String[] values,int[] idx, int min, int max){
        if(idx[0] == values.length){
            return null;
        }

        int val = Integer.parseInt(values[idx[0]]);
        if(val < min || val > max){
           return null;
        }
        TreeNode root = new TreeNode(val);
        idx[0]++;
        root.left = buildBst(values, idx, min, val);
        root.right = buildBst(values, idx, val, max);

        return root;
    }

    public void preorder(TreeNode root, StringBuilder sb){
        if(root == null){
            return;
        }
        sb.append(""+root.val);
        sb.append(",");
        preorder(root.left, sb);
        preorder(root.right, sb);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;