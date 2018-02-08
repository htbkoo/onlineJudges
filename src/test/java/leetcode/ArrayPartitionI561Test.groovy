package leetcode

import spock.lang.Specification
import spock.lang.Unroll

class ArrayPartitionI561Test extends Specification {
    @Unroll
    def "should findMinArrayPairSum(#nums)"() {
        given:
        def sut = new ArrayPartitionI561()

        when:
        def count = sut.arrayPairSum(nums)

        then:
        count == expectedSum

        where:
        nums                  | expectedSum
        [1, 4, 3, 2] as int[] | 4
        [1, -1] as int[]      | -1
        [] as int[]           | 0
    }
}
