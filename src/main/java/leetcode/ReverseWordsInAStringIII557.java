package leetcode;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ReverseWordsInAStringIII557 {
    public String reverseWords(String s) {
        return Arrays.stream(s.split(" ")).map(StringBuilder::new).map(StringBuilder::reverse).collect(Collectors.joining(" ")).trim();
    }

    public String reverseWordsOwnReverse(String s) {
        return Arrays.stream(s.split(" ")).map(this::reverse).collect(Collectors.joining(" "));
    }

    private String reverse(String s) {
        final int length = s.length();
        final StringBuilder sb = new StringBuilder();
        final char[] chars = s.toCharArray();
        for (int i = length - 1; i >= 0; --i) {
            sb.append(chars[i]);
        }

        return sb.toString();
    }
}
