package com.devstock.leetcode.exercises;

/**
 * https://leetcode.com/problems/maximum-number-of-moves-in-a-grid/description/?envType=daily-question&envId=2024-10-29
 * Input: grid = [[2,4,3,5],[5,4,9,3],[3,4,2,11],[10,9,13,15]]
 * Output: 3
 * Explanation: We can start at the cell (0, 0) and make the following moves:
 * - (0, 0) -> (0, 1).
 * - (0, 1) -> (1, 2).
 * - (1, 2) -> (2, 3).
 */
public class MaxNumberMoves {

    public static void main(String[] args) {
        int[][] grid = {
                {2,4,3,5},
                {5,4,9,3},
                {3,4,2,11},
                {10,9,13,15}
        };
        System.out.println(maxMoves(grid)); // Output: 3
    }

    public static int maxMoves(int[][] grid) {

        int maxMoves = 0;
        int row = 0;
        int column = 0;
        while (row < grid.length && column < grid[0].length) {
            while (column < grid[0].length) {
                System.out.println("row: " + row + ", column: " + column);
                int currentItem = grid[row][column];
                if (row > 0) { // (prevent indexOutOfBound).
                    getAboveRightCell(grid, row, column);
                    maxMoves++;
                    row--;
                    column++;
                    break;
                }
                int nextRightItem = getRightCell(grid, row, column);
                if (nextRightItem > currentItem) {
                    maxMoves++;
                    column++;
                    break;
                }
                int belowRightItem = getBelowRightCell(grid, row, column);
                if (belowRightItem > currentItem) {
                    maxMoves++;
                    row++;
                    column++;
                    break;
                }
                return maxMoves;
            }
        }
        return maxMoves;
    }

    private static int getAboveRightCell(int[][] grid, int row, int col) {
        final int colSize = grid[0].length - 1;
        if (col < colSize) {
            System.out.println("currentCell: " + grid[row][col] + "aboveRightCell: " + grid[row][col + 1]);
            return grid[row - 1][col + 1];
        }
        return 0;
    }

    private static int getRightCell(int[][] grid, int row, int col) {
        final int colSize = grid[0].length -1;
        if (col < colSize) {
            System.out.println("currentCell: " + grid[row][col] + "rightCell: " + grid[row][col + 1]);
            return grid[row][col + 1];
        }
        return 0;
    }

    private static int getBelowRightCell(int[][] grid, int row, int col) {
        final int colSize = grid[0].length - 1;
        final int rowsize = grid.length - 1;
        if (row < rowsize && col < colSize) {
            System.out.println("currentCell: " + grid[row][col] + "belowRightCell: " + grid[row + 1][col + 1]);
            return grid[row + 1][col + 1];
        }
        return 0;
    }
}
