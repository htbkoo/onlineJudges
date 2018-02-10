package leetcode

import spock.lang.Specification
import spock.lang.Unroll

class IslandPerimeter463Test extends Specification {
    @Unroll
    def "should countIslandPerimeter()"() {
        given:
        def sut = new IslandPerimeter463()

        when:
        def count = sut.islandPerimeter(grid)

        then:
        count == expected

        where:
        grid                      | expected
        [[0, 1, 0, 0],
         [1, 1, 1, 0],
         [0, 1, 0, 0],
         [1, 1, 0, 0]] as int[][] | 16
        [[1]] as int[][]          | 4
        [[1, 1]] as int[][]       | 6
        [[1, 1, 1]] as int[][]    | 8
        [[1, 1, 1],
         [1, 1, 1]] as int[][]    | 10
        [[1, 0, 1],
         [1, 1, 1]] as int[][]    | 12
    }
}
