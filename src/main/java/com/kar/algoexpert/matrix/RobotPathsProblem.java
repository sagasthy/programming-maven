package com.kar.algoexpert.matrix;

import java.util.concurrent.atomic.AtomicInteger;

public class RobotPathsProblem {
    public static void main(String[] args) {
        int[][] matrix = {{0, 0, 0},
                          {0, 0, 0},
                          {0, 0, 0}};

        System.out.println(robotPaths(matrix));
    }

    public static AtomicInteger robotPaths(int[][] matrix) {
        AtomicInteger result = new AtomicInteger();
        traverse(matrix, 0, 0, result);
        return result;
    }

    private static void traverse(int[][] matrix, int row, int col, AtomicInteger result) {

        // out of bounds
        if(row < 0 || col < 0 || row >= matrix.length || col >= matrix[0].length)
            return;

        // already visited
        if(matrix[row][col] == 1)
            return;

        // reached destination
        if(row == matrix.length - 1 && col == matrix[0].length - 1) {
            result.incrementAndGet();
            return;
        }

        // toggle
        matrix[row][col] = 1;

        traverse(matrix, row-1, col, result);
        traverse(matrix, row+1, col, result);
        traverse(matrix, row, col-1, result);
        traverse(matrix, row, col+1, result);

        // backtrack
        matrix[row][col] = 0;
    }
}
