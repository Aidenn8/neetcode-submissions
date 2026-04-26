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
        
        ListNode head = new ListNode();
        ListNode n = head;
       
        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                n.next = list1;
                list1 = list1.next;
            }
            else{
                n.next = list2;
                list2 = list2.next;
            }
            n = n.next;
        }
        if(list1 != null){
            n.next = list1;
        }else{
            n.next = list2;
        }
        return head.next;
    }
}





    
      /*  ListNode mainNode = new ListNode();
       if (list1.val < list2.val)
            {
                mainNode.val = list1.val;
                mainNode.next = list1;
                list1 = list1.next;
            }
            else
            {
                mainNode = list2;
                list2 = list2.next;
            }
        
        
        while(list1.next != null)
        {


            if (list1.val < list2.val)
            {
                mainNode = list1;
                list1 = list1.next;
            }
            else
            {
                mainNode = list2;
                list2 = list2.next;
            }

        }
        

*/

