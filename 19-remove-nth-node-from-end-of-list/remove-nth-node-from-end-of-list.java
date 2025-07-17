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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next == null){return null;}
        ListNode cur = head;
        ListNode front = head;
        for(int i=0;i<n; i++){
            front = front.next;
        }
        int count =0;

        while(cur!=null){
            count++;
            cur=cur.next;
        }
        if(n == count){
            return head.next;
        }

        cur = head;

        while(front.next!=null){
            cur = cur.next;
            front = front.next;
        }

        cur.next = cur.next.next;

        return head;

    }
}