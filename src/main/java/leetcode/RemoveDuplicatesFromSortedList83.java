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
    public ListNode deleteDuplicatesLessCleanCode(ListNode head) {
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

    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.next.val == current.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }

        return head;
    }
}