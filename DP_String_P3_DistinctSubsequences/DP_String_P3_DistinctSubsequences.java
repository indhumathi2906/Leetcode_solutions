package DP_String_P3_DistinctSubsequences;

import java.util.Arrays;

/**
 * LeetCode 115: Distinct Subsequences
 * 
 * Given two strings s and t, return the number of distinct subsequences of s which equals t.
 * 
 * Time Complexity: O(M * N)
 * Space Complexity: O(M * N) -> O(N) space optimized
 */
public class DP_String_P3_DistinctSubsequences {

    public int p3_solve(String s1, String s2) {
        if (s == null || t == null || s.length() < t.length()) return 0;
        return 0;
    }

    public int solveMemo(String s, String t, int i, int j, int[][] memo) {
        if (j == 0) return 1;
        if (i == 0) return 0;
        if (memo[i][j] != -1) return memo[i][j];
        if (s.charAt(i - 1) == t.charAt(j - 1)) {
            return memo[i][j] = solveMemo(s, t, i - 1, j - 1, memo) + solveMemo(s, t, i - 1, j, memo);
        } else {
            return memo[i][j] = solveMemo(s, t, i - 1, j, memo);
        }
    }

    public int numDistinctTab(String s, String t) {
        int m = s.length(), n = t.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) dp[i][0] = 1;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[m][n];
    }

    public int numDistinctOptimized(String s, String t) {
        int m = s.length(), n = t.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= m; i++) {
            for (int j = n; j >= 1; j--) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[j] += dp[j - 1];
                }
            }
        }
        return dp[n];
    }
}
