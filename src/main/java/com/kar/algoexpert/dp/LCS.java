package com.kar.algoexpert.dp;

import java.util.Arrays;

public class LCS {
    public static void main(String[] args) {
        String s1 = "abcd";
        String s2 = "acd";

        System.out.println("Longest Common Subsequence: " + lcs(s1, s2));
    }

    private static String lcs(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        String[][] dp = new String[m][n];

        for(String[] row: dp)
            Arrays.fill(row, "");

        return lcs(s1.toCharArray(), s2.toCharArray(), m, n, dp);
    }

    private static String lcs(char[] s1, char[] s2, int m, int n, String[][] dp) {
        if(m==0 || n==0)
            return "";

        if(dp[m-1][n-1].length() > 0)
            return dp[m-1][n-1];

        if(s1[m-1] == s2[n-1]){
            dp[m-1][n-1] += lcs(s1, s2, m-1, n-1, dp);
        } else{
            String one = lcs(s1, s2, m-1, n, dp);
            String two = lcs(s1, s2, m, n-1, dp);
            dp[m-1][n-1] += one.length() > two.length() ? one : two;
        }

        return dp[m-1][n-1];
    }
}
