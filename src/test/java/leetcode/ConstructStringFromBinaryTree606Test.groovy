package leetcode

import leetcode.util.TreeNode
import spock.lang.Specification
import spock.lang.Unroll

class ConstructStringFromBinaryTree606Test extends Specification {
    @Unroll
    def "should deleteDuplicates(#list)"() {
        given:
        def sut = new ConstructStringFromBinaryTree606()

        when:
        def str = sut.tree2str(t)

        then:
        str == expected

        where:
        t               | expected
        new TreeNode(1) | "1"
    }
}