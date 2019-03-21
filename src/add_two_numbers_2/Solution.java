package add_two_numbers_2;
/*
You are given two non-empty linked lists representing two non-negative integers.
The digits are stored in reverse order and each of their nodes contain a single digit.
Add the two numbers and return it as a linked list.

        You may assume the two numbers do not contain any leading zero, except the number 0 itself.

        Example:

        Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
        Output: 7 -> 0 -> 8
        Explanation: 342 + 465 = 807.
*/
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode head = res;
        if(l1 == null && l2 == null) return null;
        int check = 0;
        while(l1 != null || l2 != null) {
            int val1 = (l1 == null) ? 0 : l1.val;
            int val2 = (l2 == null) ? 0 : l2.val;
            int temp = val1 + val2 + check;
            check = (temp >= 10) ? temp/10 : 0;
            temp = (temp >= 10) ? (temp%10) : temp;
            res.next = new ListNode(temp);
            res = res.next;
            l1 = (l1 == null) ? null : l1.next;
            l2 = (l2 == null) ? null : l2.next;
        }
        if(check != 0) res.next = new ListNode(check);
        return head.next;
    }
}
