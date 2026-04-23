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
    public ListNode reverseList(ListNode head) {
        if(head == null){
            return null;
        }

        ListNode n = head;
        if(head.next != null){
            n = reverseList(head.next);
            head.next.next = head;
        }
        head.next = null;
        return n;
    }
}

// 1 2 3 4 5
// 


// 