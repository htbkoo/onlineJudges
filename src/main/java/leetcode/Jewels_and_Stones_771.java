package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Jewels_and_Stones_771 {
    public int numJewelsInStonesFor(String J, String S) {
        Map<Character, Integer> occurrences = new HashMap<>();
        final char[] chars = S.toCharArray();
        for (char c : chars) {
            if (occurrences.containsKey(c)) {
                occurrences.put(c, occurrences.get(c) + 1);
            } else {
                occurrences.put(c, 1);
            }
        }
        int count = 0;
        final char[] charj = J.toCharArray();

        for (char c : charj) {
            if (occurrences.containsKey(c)) {
                count += occurrences.get(c);
            }
        }
        return count;
    }

    public int numJewelsInStones(String J, String S) {
        Map<Integer, Long> occurrences = S.chars().boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return (int) J.chars().boxed().filter(occurrences::containsKey).map(occurrences::get).mapToLong(Long::longValue).sum();
    }
}
