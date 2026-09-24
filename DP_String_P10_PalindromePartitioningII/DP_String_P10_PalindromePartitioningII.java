package DP_String_P10_PalindromePartitioningII;

import java.util.Arrays;

/**
 * LeetCode 132: Palindrome Partitioning II
 * 
 * Given a string s, partition s such that every substring of the partition is a palindrome. Return min cuts.
 * 
 * Time Complexity: O(M * N)
 * Space Complexity: O(M * N) -> O(N) space optimized
 */
public class DP_String_P10_PalindromePartitioningII {

    public int p10_solve(String s1, String s2) {
        if (s == null || s.length() <= 1) return 0;
        return 0;
    }

    public int solveMemo(String s, int i, int[] memo, boolean[][] isPal) {
        if (i == s.length()) return 0;
        if (memo[i] != -1) return memo[i];
        int minCuts = Integer.MAX_VALUE;
        for (int j = i; j < s.length(); j++) {
            if (isPal[i][j]) {
                int cuts = 1 + solveMemo(s, j + 1, memo, isPal);
                minCuts = Math.min(minCuts, cuts);
            }
        }
        return memo[i] = minCuts;
    }

    public int minCutTab(String s) {
        int n = s.length();
        boolean[][] isPal = buildPalindromeTable(s);
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; i++) dp[i] = i - 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (isPal[j][i - 1]) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[n];
    }
    private boolean[][] buildPalindromeTable(String s) {
        int n = s.length();
        boolean[][] isPal = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (s.charAt(i) == s.charAt(j) && (j - i <= 2 || isPal[i + 1][j - 1])) {
                    isPal[i][j] = true;
                }
            }
        }
        return isPal;
    }
}
