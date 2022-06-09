package com.kar.algoexpert.matrix;

public class TwoDimensionalSearch {
    public static void main(String[] args) {
        int[][] matrix = {
            {1,  3,  5,  7},
            {10, 11, 16, 20},
            {23, 30, 34, 50}
            };

        System.out.println(search(matrix, 11));
    }

    private static boolean search(int[][] matrix, int target) {
        return traverse(matrix, 0, matrix[0].length - 1, target);
    }

    private static boolean traverse(int[][] matrix, int row, int col, int target) {
        if(row < 0 || col < 0 || row >= matrix.length || col >= matrix[0].length)
            return false;

        if(matrix[row][col] == target) {
            return true;
        }
        else if(matrix[row][col] < target)
            return traverse(matrix, row + 1, col, target);
        else
            return traverse(matrix, row, col - 1, target);
    }
}
