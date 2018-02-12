package leetcode

import leetcode.util.ListNode
import spock.lang.Specification
import spock.lang.Unroll

class RemoveDuplicatesFromSortedList83Test extends Specification {
    @Unroll
    def "should deleteDuplicates(#list)"() {
        given:
        def sut = new RemoveDuplicatesFromSortedList83()
        def head = ListNode.from(list)

        when:
        def node = sut.deleteDuplicates(head)

        then:
        node == ListNode.from(expected)

        where:
        list               | expected
        []                 | []
        [0]                | [0]
        [1, 1, 2]          | [1, 2]
        [1, 1, 2, 3, 3]    | [1, 2, 3]
        [1, 1, 1, 2, 3, 3] | [1, 2, 3]
        [1, 2, 3, 3]       | [1, 2, 3]
        [1, 2, 3, 3, 3]    | [1, 2, 3]
        [1, 2, 3, 3, 4]    | [1, 2, 3, 4]
    }
}