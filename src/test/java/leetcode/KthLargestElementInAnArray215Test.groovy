package leetcode

import spock.lang.Specification
import spock.lang.Unroll

class KthLargestElementInAnArray215Test extends Specification {
    @Unroll
    def "should findKthLargest(#nums, #k)"() {
        given:
        def sut = new KthLargestElementInAnArray215()

        when:
        def values = sut.findKthLargest(nums, k)

        then:
        values == expected

        where:
        nums                        | k || expected
        [1] as int[]                | 1 || 1
        [3, 2, 1, 5, 6, 4] as int[] | 2 || 5
        [3, 2, 1, 5, 6, 4] as int[] | 6 || 1
        [3, 2, 1, 5, 6, 4] as int[] | 1 || 6
    }
}