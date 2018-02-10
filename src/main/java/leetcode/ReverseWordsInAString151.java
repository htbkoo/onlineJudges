package leetcode;

public class ReverseWordsInAString151 {
    public String reverseWords(String s) {
        if (s == null) {
            return null;
        }

        return String.join(" ", reverse(s.trim().split("\\s+")));
    }

    private String[] reverse(String[] split) {
        final int length = split.length;
        final String[] reversed = new String[length];
        for (int i = 0; i < length; ++i) {
            reversed[i] = split[length - 1 - i];
        }
        return reversed;
    }
}
