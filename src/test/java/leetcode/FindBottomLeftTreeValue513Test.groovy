package leetcode

import leetcode.util.TreeNode
import spock.lang.Specification
import spock.lang.Unroll

class FindBottomLeftTreeValue513Test extends Specification {
    @Unroll
    def "should countBattershipe()"() {
        given:
        def sut = new FindBottomLeftTreeValue513()

        when:
        def value = sut.findBottomLeftValue(root)

        then:
        value == expected

        where:
        root            | expected
        new TreeNode(1) | 1
    }
}
