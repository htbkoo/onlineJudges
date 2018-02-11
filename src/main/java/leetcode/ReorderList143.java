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
public class ReorderList143 {
    public void reorderList(ListNode head) {
        // size is 0, 1 or 2
        if ((head == null) || (head.next == null) || (head.next.next == null)) {
            return;
        }

        ListNode slow = head, fast = head;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode tail = (fast.next == null) ? fast : fast.next;

        ListNode middle = slow.next;
        slow.next = null;
        reverse(middle);

        ListNode curr = head;
        while (tail != null && curr != null) {
            ListNode currNext = curr.next, tailNext = tail.next;
            curr.next = tail;
            tail.next = currNext;
            curr = currNext;
            tail = tailNext;
        }

    }

    private void reverse(ListNode curr) {
        if (curr == null) {
            return;
        }
        ListNode prev = curr;
        curr = curr.next;
        prev.next = null;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
    }
}
