package com.kar.algoexpert.matrix;

import java.util.HashSet;
import java.util.Set;

public class WordSearchInMatrix {
    static int count = 0;
    public static void main(String[] args) {
        char[][] matrix = {
            {'a', 'b', 'c', 'd'},
            {'e', 'f', 'g', 'h'},
            {'i', 'd', 'o', 'j'},
            {'k', 'l', 'm', 'n'}
        };

        System.out.println("dog => " + searchWord(matrix, "dog"));
        System.out.println("abcgfd => " + searchWord(matrix, "abcgfd"));
        System.out.println("don => " + searchWord(matrix, "don"));
    }

    public static boolean searchWord(char[][] matrix, String word) {
        boolean result = false;

        for(int row=0; row<matrix.length; row++) {
            for(int col=0; col<matrix[0].length; col++) {
                if(searchWord(matrix, word.toCharArray(), 0, row, col)) {
                    result = true;
                    break;
                }
            }
        }

        System.out.println("No of calls: " + count);
        return result;
    }

    private static boolean searchWord(char[][] matrix, char[] letters, int searchIndex, int row, int col) {
        count++;
        if(row < 0 || row >= matrix.length-1 || col < 0 || col >= matrix[0].length-1)
            return false;

        if(matrix[row][col] == letters[searchIndex]) {
            if(searchIndex == letters.length-1)
                return true;
            return searchWord(matrix, letters, searchIndex+1, row-1, col) 
            || searchWord(matrix, letters, searchIndex+1, row+1, col)
            || searchWord(matrix, letters, searchIndex+1, row, col-1)
            || searchWord(matrix, letters, searchIndex+1, row, col+1);
        }
        return false;
    }
}
