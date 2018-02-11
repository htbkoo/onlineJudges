package leetcode

import leetcode.util.ListNode
import spock.lang.Specification
import spock.lang.Unroll

class RemoveDuplicatesFromSortedListII82Test extends Specification {
    @Unroll
    def "should deleteDuplicates(#list)"() {
        given:
        def sut = new RemoveDuplicatesFromSortedListII82()
        def head = ListNode.from(list)

        when:
        def node = sut.deleteDuplicates(head)

        then:
        node == ListNode.from(expected)

        where:
        list                                             | expected
        []                                               | []
        [0]                                              | [0]
        [1, 1]                                           | []
        [1, 2]                                           | [1, 2]
        [1, 1, 2]                                        | [2]
        [1, 1, 2, 2]                                     | []
        [1, 1, 2, 3, 3]                                  | [2]
        [1, 1, 2, 2, 3]                                  | [3]
        [1, 1, 1, 2, 3, 3]                               | [2]
        [1, 2, 3, 3]                                     | [1, 2]
        [1, 2, 3, 3, 3]                                  | [1, 2]
        [1, 2, 3, 3, 4]                                  | [1, 2, 4]
        [1, 1, 2, 2, 3, 4, 4, 4, 5, 5, 5, 5]             | [3]
        [1, 1, 2, 2, 3, 4, 5, 5, 5, 6, 6, 6, 6]          | [3, 4]
        [1, 1, 2, 2, 3, 4, 5, 5, 5, 6, 6, 7, 8, 8, 8, 9] | [3, 4, 7, 9]
    }
}