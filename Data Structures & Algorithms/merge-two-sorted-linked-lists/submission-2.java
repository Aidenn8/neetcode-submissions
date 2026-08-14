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
        


        /*
        0 2 4
        1 3 5

        1 3 5
        0 2 4


        */


        // if(list1 == null && list2 == null){
        //     return null;
        // }else if(list1 == null && list2 != null){
        //     return list2;
        // }else if(list1 != null && list2 == null){
        //     return list1;
        // }
        // ListNode n = mergeTwoLists(list1.next, list2);
        // if(list1.val < n.val){
        //     list1.next = n;
        // }
        // if(list1.val < list2.val){
        //     list1.next = list2;
        //     list2.next = n;
        //     return list1;
        // }else{
        //     //list1.next.next = list2.next;
        //     list2.next = list1;
        //     list1.next = n;
        //     return list2;
        // }
        


        /*

        list1=[0,2,2,2]
        list2=[2,2,3]

        assume merge(2,2) will merge all of list 1 and list2

        2 2 2 2 3
        now all i need to do is check if the current is less then add

        4 5 6
        1 2 2 3 4

        merge(5,1)
        1 2 2 3 4 5 6

        what i want is to find the smallest value between the two lists

        4 5 6 
        1 2 2 3 4 

        merge(4, 2)
        2 2 3 4 4 5 6

        4 7 10
        1 2 5 9
        2 4 5 7 9 10

        1 2 4
        1 3 5

        1 2 3 4 5
        1 
        []
        1 2
        merge(2,3)
        merge(2, null) --> 2
        

        merge(2,2)
        list1=[1,2,4]
        list2=[1,3,5]
        n = mergeTwoLists(2, 3)
        mergeTwoLists(4, 5)
        mergeTwoLists(null, null) --> return null
        go back up now
        mergeTwoLists(4,5)
        if(4 < 5)
        4 --> 5
        return 4
        go back up now
        mergeTwoLists(2, 3)
        2 < 3
        2 --> 3 --> 5


        1 --> 1
        return 1

        //okay what happens with different length linkedlists then

        1 3
        2 4 5 6 
        merge(3, 4)
        merge(null, 5)
        return null
        well then i have a few base cases
        if my l1 is null but my l2 is not --> return my l2
        if my l2 is null but my l1 is not return my l1
        if both are null then return null

        2 4 5 6
        1 3

        merge(4, 3)
        merge(5, null)


        */
    }
}
/*




1 2 4
1 3 5


lets just look at l1's elements and until i see a smaller one in l2 i can add them into my new linkedlist
mergeTwoLists(list1.next, list2.next) will merge everything in front 2 4
                                                                     3 5
so that it becomes 2 3 4 5
now all i need to do is find order of curr l1 and curr l2 to add to my listnode

*/