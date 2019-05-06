package merge_two_sorted_list_21;

/*
Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of
the first two lists.

Example:

Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4
 */
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
}
public class Solution {
    //Iterative Solution, no good
    public ListNode mergeTwoListsIterative(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode headCopy = head;
        if(l1 == null && l2 == null) return null;
        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                head.next = l1;
                l1 = l1.next;
            } else {
                head.next = l2;
                l2 = l2.next;
            }
            head = head.next;
        }
        if(l1 == null) head.next = l2;
        if(l2 ==null) head.next = l1;
        return headCopy.next;
    }

    //Recursive Solution good
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        if(l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}
