package leetcode;

import leetcode.util.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class FindBottomLeftTreeValue513 {
    public int findBottomLeftValue(TreeNode root) {
        if (root == null) {
            throw new IllegalArgumentException("Note: You may assume the tree (i.e., the given root node) is not NULL. ");
        }

        Deque<TreeNode> queue;
        Deque<TreeNode> nextLayer = new ArrayDeque<>();
        nextLayer.push(root);

        int leftmost;

        do {
            queue = nextLayer;
            nextLayer = new ArrayDeque<>();
            leftmost = queue.peek().val;
            while (!queue.isEmpty()) {
                final TreeNode node = queue.poll();
                if (node.left != null) {
                    nextLayer.add(node.left);
                }
                if (node.right != null) {
                    nextLayer.add(node.right);
                }
            }
        } while (!nextLayer.isEmpty());

        return leftmost;
    }
}
