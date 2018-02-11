package leetcode

import leetcode.util.ListNode
import spock.lang.Specification
import spock.lang.Unroll

class ReorderList143Test extends Specification {
    @Unroll
    def "should reorderList()"() {
        given:
        def sut = new ReorderList143()
        def head = ListNode.from(list)

        when:
        sut.reorderList(head)

        then:
        head == ListNode.from(expected)

        where:
        list               | expected
        [0]                | [0]
        [1, 2]             | [1, 2]
        [1, 2, 3]          | [1, 3, 2]
        [1, 2, 3, 4]       | [1, 4, 2, 3]
        [1, 2, 3, 4, 5]    | [1, 5, 2, 4, 3]
        [1, 2, 3, 4, 5, 6] | [1, 6, 2, 5, 3, 4]
    }
}