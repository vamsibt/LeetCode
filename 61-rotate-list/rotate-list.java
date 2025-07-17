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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || k==0 || head.next == null){
            return head;
        }
        int size = 0;
        ListNode cur = head;
        ListNode tail = null;
        while(cur!=null){
            if(cur.next== null){
                tail = cur;
            }
            cur = cur.next;
            
            size++;
        }



        k = k%size;

        if(k == 0){
            return head;
        }

        int cutInd = size-k;
        cur = head;
        for(int i=1; i<cutInd; i++){
            cur = cur.next;
        }
        ListNode newHead = cur.next;
        cur.next = null;
        tail.next = head;
        head = newHead;

        return head;
    }
}