/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    public TreeNode sortedListToBST(ListNode head) {
        ArrayList<Integer> arr = new ArrayList<>();
        ListNode cur = head;

        while(cur!=null){
            arr.add(cur.val);
            cur = cur.next;
        }
        return buildBST(arr, 0, arr.size()-1);
    }

    public TreeNode buildBST(ArrayList<Integer> arr, int start, int end){
        if(start > end) return null;
        int mid = start+ (end-start)/2;

        TreeNode root = new TreeNode(arr.get(mid));
        root.left = buildBST(arr, start, mid-1);
        root.right = buildBST(arr, mid+1, end);

        return root;
    }
}