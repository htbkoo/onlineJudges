package leetcode

import spock.lang.Specification
import spock.lang.Unroll

class ReverseWordsInAStringIII557Test extends Specification {
    @Unroll
    def "should reverseWordsInAStringIII(#s)"() {
        given:
        def sut = new ReverseWordsInAStringIII557()

        when:
        def reversed = sut.reverseWords(s)

        then:
        reversed == expected

        where:
        s                             || expected
        ""                            || ""
        "Let's take LeetCode contest" || "s'teL ekat edoCteeL tsetnoc"
        "Let's "                      || "s'teL"
        " Let's "                     || "s'teL"
        " "                           || ""
    }
}
