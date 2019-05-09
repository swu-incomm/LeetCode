package linked_list_cycle_141;
/*
Given a linked list, determine if it has a cycle in it.

        To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed) in the linked list where tail connects to.
        If pos is -1, then there is no cycle in the linked list.

        Follow up:

        Can you solve it using O(1) (i.e. constant) memory?
         */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) return false;
        ListNode slow = head;
        ListNode fast = head;

        while(fast!= null && fast.next!= null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow.equals(fast)) {
                return true;
            }
        }
        return false;
    }
    public static void main(String [] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        a.next = b;
        Solution solution = new Solution();
        System.out.println(solution.hasCycle(a));
    }
}