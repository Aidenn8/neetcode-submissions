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
        //ill just assume reverselist(head.next) will reverse everything untuk head.next
        //now all i nred to do is just reverse the connection between head and head.next
        if(head == null || head.next == null){
            return head;
        }
        ListNode n = reverseList(head.next);
        //this contains the node until head.next is reversed
        head.next.next = head;
        head.next = null;
        return n;

}
}