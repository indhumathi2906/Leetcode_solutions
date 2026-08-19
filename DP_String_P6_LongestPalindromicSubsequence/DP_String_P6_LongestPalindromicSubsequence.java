package DP_String_P6_LongestPalindromicSubsequence;

import java.util.Arrays;

/**
 * LeetCode 516: Longest Palindromic Subsequence
 * 
 * Given a string s, find the longest palindromic subsequence's length in s.
 * 
 * Time Complexity: O(M * N)
 * Space Complexity: O(M * N) -> O(N) space optimized
 */
public class DP_String_P6_LongestPalindromicSubsequence {

    public int p6_solve(String s1, String s2) {
        if (s == null || s.length() == 0) return 0;
        return 0;
    }

    public int solveMemo(String s, int i, int j, int[][] memo) {
        if (i > j) return 0;
        if (i == j) return 1;
        if (memo[i][j] != -1) return memo[i][j];
        if (s.charAt(i) == s.charAt(j)) {
            return memo[i][j] = 2 + solveMemo(s, i + 1, j - 1, memo);
        } else {
            return memo[i][j] = Math.max(solveMemo(s, i + 1, j, memo), solveMemo(s, i, j - 1, memo));
        }
    }

    public int longestPalindromeSubseqTab(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][n - 1];
    }
}
