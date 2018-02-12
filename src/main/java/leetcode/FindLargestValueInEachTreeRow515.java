package leetcode;

import leetcode.util.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class FindLargestValueInEachTreeRow515 {
    public List<Integer> largestValues(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        Deque<TreeNode> queue;
        Deque<TreeNode> nextRow = new ArrayDeque<>();
        nextRow.add(root);
        List<Integer> values = new ArrayList<>();
        do {
            queue = nextRow;
            nextRow = new ArrayDeque<>();
            int rowMax = queue.peek().val;
            while (!queue.isEmpty()) {
                final TreeNode node = queue.pop();
                rowMax = Math.max(rowMax, node.val);
                if (node.left != null) {
                    nextRow.add(node.left);
                }
                if (node.right != null) {
                    nextRow.add(node.right);
                }
            }
            values.add(rowMax);
        } while (!nextRow.isEmpty());

        return values;
    }
}
