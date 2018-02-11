package leetcode.util;

import java.util.List;
import java.util.Objects;

public class ListNode {
    public final int val;
    public ListNode next;

    private ListNode(int x) {
        val = x;
    }

    public static ListNode from(List<Integer> integers) {
        final ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;

        for (int i : integers) {
            current.next = new ListNode(i);
            current = current.next;
        }

        return dummyHead.next;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListNode listNode = (ListNode) o;
        return val == listNode.val &&
                Objects.equals(next, listNode.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, next);
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}