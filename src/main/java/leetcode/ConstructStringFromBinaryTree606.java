package leetcode;

import leetcode.util.TreeNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
public class ConstructStringFromBinaryTree606 {
    public String tree2str(TreeNode t) {
        if (t == null) {
            return "";
        }

        final StringBuilder sb = new StringBuilder();
        sb.append(t.val);

        if ((t.left != null) && (t.right != null)) {
            sb.append("(").append(tree2str(t.left)).append(")(").append(tree2str(t.right)).append(")");
        } else if (t.left != null) {
            sb.append("(").append(tree2str(t.left)).append(")");
        } else if (t.right != null) {
            sb.append("()(").append(tree2str(t.right)).append(")");
        }

        return sb.toString();
    }
}