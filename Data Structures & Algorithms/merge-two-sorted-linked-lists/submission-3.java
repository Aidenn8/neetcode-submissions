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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null && list2 == null){
            return null;
        }else if(list1 != null && list2 == null){
            return list1;
        }else if(list2 != null && list1 == null){
            return list2;
        }
        if(list1.val > list2.val){
            ListNode n = mergeTwoLists(list1, list2.next);
            list2.next = n;
            return list2;
        }else{
            ListNode n = mergeTwoLists(list1.next, list2);
            list1.next = n;
            return list1;
        }
    }
}