package leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KthLargestElementInAnArray215 {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i : nums) {
            pq.offer(i);
        }

        final int times = nums.length - k;
        for (int i = 0; i < times; i++) {
            pq.poll();
        }

        return pq.peek();
    }

    public int findKthLargestSlowPriorityQueueByComparator(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((i, j) -> Integer.compare(j, i));

        for (int i : nums) {
            pq.offer(i);
        }

        for (int i = k - 1; i > 0; --i) {
            pq.poll();
        }

        return pq.peek();
    }

    public int findKthLargestBySort(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}
