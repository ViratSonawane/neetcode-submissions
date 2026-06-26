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
        ListNode dummy = new ListNode(0);
        dummy.next = head;


        ListNode offset = dummy;
        for(int i = 0; i <= n; i++){
            offset = offset.next;
        }

        ListNode iterator = dummy;
        while(offset != null){
            offset = offset.next;
            iterator = iterator.next;
        }

        ListNode temp = iterator.next.next;
        iterator.next = temp;

        return dummy.next;
    }
}
