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
        if(head == null || head.next == null){
            return head;
        }
        ListNode n = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return n;
    }
}
/*
0 1 2 3
head = 0
n = 1
remap 1-->2 to 1-->0





go from 0 --> 1 --> 2
reverse connection after traversing to 1
or think of it as handling case by case

reverseList(head) will reverse the rest of the list except current
so all i need to do is just assign the current connection to the prev
once i get down to where the node.next is just null i reached my new head and can assign as such




*/