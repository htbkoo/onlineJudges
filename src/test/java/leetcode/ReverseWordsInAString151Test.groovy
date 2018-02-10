package leetcode

import spock.lang.Specification
import spock.lang.Unroll

class ReverseWordsInAString151Test extends Specification {
    @Unroll
    def "should reverseWords(#s)"() {
        given:
        def sut = new ReverseWordsInAString151()

        when:
        def count = sut.reverseWords(s)

        then:
        count == expected

        where:
        s                       | expected
        "the sky is blue"       | "blue is sky the"
        "the       sky is blue" | "blue is sky the"
        "the "                  | "the"
        "the "                  | "the"
        null                    | null
        ""                      | ""
    }
}
