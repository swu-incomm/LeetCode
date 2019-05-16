package palindrome_linked_list_234;
/*
Given a singly linked list, determine if it is a palindrome.

Example 1:

Input: 1->2
Output: false
Example 2:

Input: 1->2->2->1
Output: true
Follow up:
Could you do it in O(n) time and O(1) space?
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        slow = reverseIterative(slow);
        fast = head;
        while(slow != null) {
            if(slow.val != fast.val) return false;
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }
    public ListNode reverseIterative(ListNode head) {
        ListNode prev = null;
        while(head.next!= null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return head;
    }

    public ListNode reverseRecursive(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode p = reverseRecursive(head.next);

        head.next.next  = head;
        head.next = null;

        return p;
    }
    public static void main(String [] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(1);
        ListNode c = new ListNode(2);
        ListNode d = new ListNode(1);
        a.next = b;
        b.next = c;
        c.next = d;
        Solution solution = new Solution();
        System.out.println(solution.isPalindrome(a));
    }
}