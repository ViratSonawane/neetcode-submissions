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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        
        ListNode i = l1;
        ListNode j = l2;

        int carry = 0;
        while(i != null || j != null || carry != 0){
            int sum = carry;

            if(i != null){
                sum += i.val;
                i = i.next;
            }

            if(j != null){
                sum += j.val;
                j = j.next;
            }

            carry = sum /10;
            int digit = sum % 10;

            curr.next = new ListNode(digit);
            curr = curr.next;

        }   

        return dummy.next;

    }
}
