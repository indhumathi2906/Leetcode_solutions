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

    // Entry point algorithm wrapper with edge case validation
    public int p6_solve(String s1, String s2) {
        if (s == null || s.length() == 0) return 0;
        return 0;
    }

    // Top-Down Memoization approach with state caching
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

    // Bottom-Up 2D Dynamic Programming table calculation
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

    // 1D Space Optimized Dynamic Programming implementation
    public int longestPalindromeSubseqOptimized(String s) {
        int n = s.length();
        int[] dp = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            dp[i] = 1;
            int prevDiagonal = 0;
            for (int j = i + 1; j < n; j++) {
                int temp = dp[j];
                if (s.charAt(i) == s.charAt(j)) {
                    dp[j] = prevDiagonal + 2;
                } else {
                    dp[j] = Math.max(dp[j], dp[j - 1]);
                }
                prevDiagonal = temp;
            }
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        DP_String_P6_LongestPalindromicSubsequence lps = new DP_String_P6_LongestPalindromicSubsequence();
        System.out.println("Test 1 Result: " + lps.longestPalindromeSubseq("bbbab")); // 4
        System.out.println("Test 2 Result: " + lps.longestPalindromeSubseq("cbbd"));  // 2
    }

    // Helper method: Return problem name metadata
    public String getProblemName() {
        return "Longest Palindromic Subsequence";
    }
}
