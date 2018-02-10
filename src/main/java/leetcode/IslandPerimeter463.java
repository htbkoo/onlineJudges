package leetcode;

public class IslandPerimeter463 {
    public int islandPerimeter(int[][] grid) {
        if (grid == null) {
            return 0;
        }

        final int height = grid.length;

        if (height == 0) {
            return 0;
        }

//        The grid is rectangular
        final int width = grid[0].length;

        int p = 0;
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (grid[y][x] == 1) {
                    p += countCell(grid, x, y, width, height);
                }
            }
        }
        return p;
    }

    private int countCell(int[][] grid, int x, int y, int width, int height) {
        int count = 0;
        if (x == 0) {
            count++;
        } else if (grid[y][x - 1] == 0) {
            count++;
        }

        if (x == width - 1) {
            count++;
        } else if (grid[y][x + 1] == 0) {
            count++;
        }

        if (y == 0) {
            count++;
        } else if (grid[y - 1][x] == 0) {
            count++;
        }

        if (y == height - 1) {
            count++;
        } else if (grid[y + 1][x] == 0) {
            count++;
        }

        return count;
    }
}
