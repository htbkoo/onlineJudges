package leetcode;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class ArrayPartitionI561 {
//    private static final int RANGE_MIN = -10000, RANGE_MAX = 10000;

    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        final int length = nums.length;
        for (int i = 0; i < length; i += 2) {
            sum += nums[i];
        }
        return sum;
    }

//    TODO:
//    not finished yet
    public int arrayPairSumFast(int[] nums) {
//        radix sort
        final int RANGE_MIN = -10000, RANGE_MAX = 10000;
        int[] occurrences = new int[RANGE_MAX - RANGE_MIN + 1];

        for (int num : nums) {
            occurrences[num - RANGE_MIN]++;
        }

        int numPairs = nums.length / 2;

        int sum = 0;
        boolean lone = false;
        for (int i = RANGE_MIN; i <= RANGE_MAX; i++) {
            int occurrence = occurrences[i - RANGE_MIN];
            if (occurrence >= (numPairs * 2)) {
                sum += numPairs * i;
                break;
            } else {
                sum += occurrence * i;
                numPairs -= occurrence;
            }
        }
        return sum;
    }

    public int arrayPairSumWrong(int[] nums) {
        Map<Integer, Integer> occurrences = new TreeMap<>();
        for (int i : nums) {
            int occurrence = 1;
            if (occurrences.containsKey(i)) {
                occurrence = 1 + occurrences.get(i);
            }
            occurrences.put(i, occurrence);
        }
        int numPairs = nums.length / 2;
        int sum = 0;
        for (Map.Entry<Integer, Integer> pair : occurrences.entrySet()) {
            final int occurrence = pair.getValue();
            final int i = pair.getKey();
            if (occurrence >= numPairs) {
                sum += numPairs * i;
                break;
            } else {
                sum += occurrence * i;
                numPairs -= occurrence;
            }
        }
        return sum;
    }
}
