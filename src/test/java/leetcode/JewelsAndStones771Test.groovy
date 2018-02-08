package leetcode

import spock.lang.Specification
import spock.lang.Unroll

class JewelsAndStones771Test extends Specification {
    @Unroll
    def "should_count_number_of_jewels"() {
        given:
        def sut = new JewelsAndStones771()

        when:
        def count = sut.numJewelsInStones(J, S)

        then:
        count == expectedCount

        where:
        J    | S         | expectedCount
        "aA" | "aAAbbbb" | 3
        "z"  | "ZZ"      | 0
        ""   | ""        | 0
        "a"  | "a"       | 1
    }
}
