package leetcode

import leetcode.util.TreeNode
import spock.lang.Specification
import spock.lang.Unroll

class FindLargestValueInEachTreeRow515Test extends Specification {
    @Unroll
    def "should findLargestValues()"() {
        given:
        def sut = new FindLargestValueInEachTreeRow515()

        when:
        def values = sut.largestValues(root)

        then:
        values == expected

        where:
        root            | expected
        new TreeNode(1) | [1]
        null            | []
    }
}