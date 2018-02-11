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
public class RemoveDuplicatesFromSortedListII82 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }

        if (head.next == null) {
            return head;
        }

        ListNode newHead = head;
        while (newHead != null && newHead.next != null && newHead.next.val == newHead.val) {
            while (newHead.next != null && newHead.next.val == newHead.val) {
                newHead = newHead.next;
            }
            newHead = newHead.next;
        }

        ListNode current = newHead;
        while (current != null && current.next != null && current.next.next != null) {
            if (current.next.val == current.next.next.val) {
                ListNode next = current.next.next.next;
                while (next != null && next.val == current.next.val) {
                    next = next.next;
                }
                current.next = next;
            } else {
                current = current.next;
            }
            while (current.next != null && current.next.val == current.val) {
                current = current.next;
            }
        }

        return newHead;
    }
}