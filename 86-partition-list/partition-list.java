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
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode Lesser = new ListNode(-1);
        ListNode Greater = new ListNode(-1);
        ListNode curL = Lesser;
        ListNode curG = Greater;

        ListNode cur = head;

        while(cur!= null){
            if(cur.val < x){
                curL.next = cur;
                curL = curL.next;
            } else{
                curG.next = cur;
                curG = curG.next;
            } 
            cur = cur.next;
        }
        curG.next = null;
        curL.next = Greater.next;

        return Lesser.next;
    }
}