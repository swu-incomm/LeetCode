package reverse_linked_list_206;
/*
Reverse a singly linked list.

Example:

Input: 1->2->3->4->5->NULL
Output: 5->4->3->2->1->NULL
Follow up:

A linked list can be reversed either iteratively or recursively. Could you implement both? Sure
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Solution {
    //Recursive
    public ListNode reverseList(ListNode head) {
        //pre check and also return the last node as the new head in the lowest bottom of the recursive process
        if(head == null || head.next == null) {
            return head;
        }
        ListNode newHead= reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
    //Iterative
    public ListNode reverseListIterative(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode temp;
        while (curr != null) {
            //save the next node for the next iteration use
            temp = curr.next;
            //reference the current node to connect to previous node
            curr.next = prev;
            //update prev node for next iteration
            prev = curr;
            //move to next node
            curr = temp;
        }
        return prev;
    }
}
