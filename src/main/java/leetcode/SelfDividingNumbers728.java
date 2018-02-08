package leetcode;

import java.util.ArrayList;
import java.util.List;

public class SelfDividingNumbers728 {
    public List<Integer> selfDividingNumbers(int left, int right) {
        final List<Integer> results = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (isSelfDividingNumber(i)) {
                results.add(i);
            }
        }
        return results;
    }

    private boolean isSelfDividingNumber(final int i) {
        int remain = i;
        while (remain > 0) {
            final int digit = remain % 10;
            if (digit == 0) {
                return false;
            }
            if (i % digit != 0) {
                return false;
            }
            remain /= 10;
        }
        return true;
    }
}
