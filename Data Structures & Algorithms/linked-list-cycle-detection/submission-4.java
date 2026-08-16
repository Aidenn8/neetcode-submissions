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
    public boolean hasCycle(ListNode head) {
        ListNode p1 = head;
        if(p1 == null){
            return false;
        }
        ListNode p2 = head.next;
        
        while(p1 != p2){
            if(p2 == null || p2.next == null){
                return false;
            }
            p1 = p1.next;
            p2 = p2.next.next;
        }
        return true;
    }
}


/*
fast & slow pointers?

1 --> 2 --> 3 --> 4 --> 2
s     
f
1 --> 2 --> 3 --> 4 --> 2
      s
            f
1 --> 2 --> 3 --> 4 --> 2
            s
                        f
1 --> 2 --> 3 --> 4 --> 2
      f     s


1 2 3 4
e f

the reason why if you have one pointer incrementing by one and another incrementing by 2 and they always meet is because the one that iterators by 1 will land on every single possible one while the one that iterators by 2 will always cycle through and land on the same few ones --> eventually they will land on the same one





*/

