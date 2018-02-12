package codelity

import spock.lang.Specification
import spock.lang.Unroll

class FindSmallestPositiveIntegerTest extends Specification {
    @Unroll
    def "shouldFindSmallestPositiveIntegerTest(#left, #right)"() {
        given:
        def sut = new FindSmallestPositiveInteger.Solution()

        when:
        def number = sut.solution(A)

        then:
        number == expected

        where:
        A                                               || expected
        [1, 3, 6, 4, 1, 2] as int[]                     || 5
        [-1, -3] as int[]                               || 1
        [1, 2, 3] as int[]                              || 4

        [-1, 0, 1, 1, 2, 3] as int[]                    || 4
        [1, 2, 3, 4, 5, 6, 7, 8, 9, 0] as int[]         || 10
        [1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 11] as int[]     || 10
        [1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 11, 10] as int[] || 12
    }
}
