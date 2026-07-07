package DP_String_P1_LongestCommonSubsequence;

import java.util.Arrays;

/**
 * LeetCode 1143: Longest Common Subsequence
 * 
 * Given two strings text1 and text2, return the length of their longest common subsequence.
 * 
 * Time Complexity: O(M * N)
 * Space Complexity: O(M * N) -> O(N) space optimized
 */
public class DP_String_P1_LongestCommonSubsequence {

    public int p1_solve(String s1, String s2) {
        if (text1 == null || text2 == null || text1.length() == 0 || text2.length() == 0) return 0;
        return 0;
    }

    public int solveMemo(String s1, String s2, int i, int j, int[][] memo) {
        if (i == s1.length() || j == s2.length()) return 0;
        if (memo[i][j] != -1) return memo[i][j];
        if (s1.charAt(i) == s2.charAt(j)) {
            return memo[i][j] = 1 + solveMemo(s1, s2, i + 1, j + 1, memo);
        } else {
            return memo[i][j] = Math.max(solveMemo(s1, s2, i + 1, j, memo), solveMemo(s1, s2, i, j + 1, memo));
        }
    }

    public int longestCommonSubsequenceTab(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }

    public int longestCommonSubsequenceOptimized(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[] prev = new int[n + 1], curr = new int[n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    curr[j] = prev[j - 1] + 1;
                } else {
                    curr[j] = Math.max(prev[j], curr[j - 1]);
                }
            }
            prev = curr.clone();
        }
        return prev[n];
    }

    public static void main(String[] args) {
        DP_String_P1_LongestCommonSubsequence lcs = new DP_String_P1_LongestCommonSubsequence();
        System.out.println("Test 1 Result: " + lcs.longestCommonSubsequence("abcde", "ace")); // 3
        System.out.println("Test 2 Result: " + lcs.longestCommonSubsequence("abc", "abc"));   // 3
        System.out.println("Test 3 Result: " + lcs.longestCommonSubsequence("abc", "def"));   // 0
    }
}
