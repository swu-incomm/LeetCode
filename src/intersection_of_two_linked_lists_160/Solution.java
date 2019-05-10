package intersection_of_two_linked_lists_160;
/*
Write a program to find the node at which the intersection of two singly linked lists begins.
Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
Output: Reference of the node with value = 8
Input Explanation: The intersected node's value is 8
(note that this must not be 0 if the two lists intersect). From the head of A, it reads as [4,1,8,4,5].
From the head of B, it reads as [5,0,1,8,4,5]. There are 2 nodes before the intersected node in A;
There are 3 nodes before the intersected node in B.

Notes:

If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Your code should preferably run in O(n) time and use only O(1) memory.
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
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        int lengthA = helperLength(headA);
        int lengthB = helperLength(headB);
        ListNode longerHead = lengthA > lengthB ? headA : headB;
        ListNode shorterHead = lengthA > lengthB ? headB : headA;
        int dif = Math.abs(lengthA - lengthB);
        while(dif > 0) {
            longerHead = longerHead.next;
            dif--;
        }
        while(longerHead != null) {
            if(longerHead.equals(shorterHead)) {
                return longerHead;
            }
            longerHead = longerHead.next;
            shorterHead = shorterHead.next;
        }
        return null;
    }
    private int helperLength(ListNode node ) {
        if(node == null) return 0;
        else return helperLength(node.next) + 1;
    }
    public static void main(String [] args) {
        ListNode a = new ListNode(0);
        ListNode b = new ListNode(1);
        ListNode c = new ListNode(2);
        ListNode d = new ListNode(3);
        ListNode e = new ListNode(4);
        ListNode f = new ListNode(9);
        a.next = f;
        f.next = b;
        b.next = c;
        c.next = e;
        d.next = c;
        Solution solution  =new Solution();
        System.out.println(solution.getIntersectionNode(a, d).val);
     }
}