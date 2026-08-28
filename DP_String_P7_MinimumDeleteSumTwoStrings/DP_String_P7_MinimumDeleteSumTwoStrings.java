package DP_String_P7_MinimumDeleteSumTwoStrings;

import java.util.Arrays;

/**
 * LeetCode 712: Minimum ASCII Delete Sum for Two Strings
 * 
 * Given two strings s1 and s2, return the lowest ASCII sum of deleted characters to make them equal.
 * 
 * Time Complexity: O(M * N)
 * Space Complexity: O(M * N) -> O(N) space optimized
 */
public class DP_String_P7_MinimumDeleteSumTwoStrings {

    public int p7_solve(String s1, String s2) {
        if (s1 == null || s2 == null) return 0;
        return 0;
    }

    public int solveMemo(String s1, String s2, int i, int j, int[][] memo) {
        if (i == s1.length()) {
            int sum = 0;
            for (int k = j; k < s2.length(); k++) sum += s2.charAt(k);
            return sum;
        }
        if (j == s2.length()) {
            int sum = 0;
            for (int k = i; k < s1.length(); k++) sum += s1.charAt(k);
            return sum;
        }
        if (memo[i][j] != -1) return memo[i][j];
        if (s1.charAt(i) == s2.charAt(j)) {
            return memo[i][j] = solveMemo(s1, s2, i + 1, j + 1, memo);
        } else {
            int del1 = s1.charAt(i) + solveMemo(s1, s2, i + 1, j, memo);
            int del2 = s2.charAt(j) + solveMemo(s1, s2, i, j + 1, memo);
            return memo[i][j] = Math.min(del1, del2);
        }
    }

    public int minimumDeleteSumTab(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) dp[i][0] = dp[i - 1][0] + s1.charAt(i - 1);
        for (int j = 1; j <= n; j++) dp[0][j] = dp[0][j - 1] + s2.charAt(j - 1);
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j] + s1.charAt(i - 1), dp[i][j - 1] + s2.charAt(j - 1));
                }
            }
        }
        return dp[m][n];
    }
}
