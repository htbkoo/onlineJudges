package leetcode;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ReverseWordsInAStringIII557 {
    public String reverseWordsStream(String s) {
        return Arrays.stream(s.split(" ")).map(StringBuilder::new).map(StringBuilder::reverse).collect(Collectors.joining(" ")).trim();
    }

    public String reverseWords(String s) {
        final String[] words = s.split(" ");
        final StringBuilder sb = new StringBuilder();
        final int length = words.length;
        for (int i = 0; i < length; i++) {
            final String word = words[i];
            if (i > 0) {
                sb.append(" ");
            }
            sb.append(reverse(word));
        }
        return sb.toString().trim();

    }

    private String reverse(String s) {
        final int length = s.length();
        final char[] old = s.toCharArray();
        final char[] reversed = new char[length];
        for (int i = length - 1; i >= 0; --i) {
            reversed[i] = old[length - i - 1];
        }
        return new String(reversed);
    }

    public String reverseWordsOwnReverse(String s) {
        return Arrays.stream(s.split(" ")).map(this::reverse).collect(Collectors.joining(" "));
    }

    private String reverseSlow(String s) {
        final int length = s.length();
        final StringBuilder sb = new StringBuilder();
        final char[] chars = s.toCharArray();
        for (int i = length - 1; i >= 0; --i) {
            sb.append(chars[i]);
        }

        return sb.toString();
    }
}
