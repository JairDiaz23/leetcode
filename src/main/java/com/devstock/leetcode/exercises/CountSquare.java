package com.devstock.leetcode.exercises;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CountSquare {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 0, 1},
                {1, 1, 0},
                {1, 1, 0}
        };
        countSquares(matrix);
    }

    public static int countSquares(int[][] matrix) {
        System.out.println("Count squares");
        int rows = matrix.length;
        int columns = matrix[0].length;
        int total = 0;

        int[][] dp = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            System.out.println("Matrix: " + matrix[i][0]);
            dp[i][0] = matrix[i][0];
            total += matrix[i][0];
        }

        for (int j = 1; j < columns; j++) {
            System.out.println("Matrix: " + matrix[0][j]);
            dp[0][j] = matrix[0][j];
            total += matrix[0][j];
        }


        // Fill the DP table for remaining cells
        for(int i = 1; i < rows; i++) {
            for(int j = 1; j < columns; j++) {
                if(matrix[i][j] == 1) {
                    dp[i][j] = 1 + Math.min(Math.min(dp[i][j-1], dp[i-1][j]), dp[i-1][j-1]);
                }
                total += dp[i][j];
            }
        }
        System.out.println(total);

        return total;
    }

}
