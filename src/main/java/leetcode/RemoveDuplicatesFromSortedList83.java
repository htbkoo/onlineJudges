package leetcode;

import leetcode.util.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
public class RemoveDuplicatesFromSortedList83 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode prev = head, curr = head;
        int num = prev.val;
        while (curr != null) {
            if (curr.val == num) {
                prev.next = curr.next;
            } else {
                prev = curr;
                num = prev.val;
            }
            curr = curr.next;
        }
        return head;
    }
}