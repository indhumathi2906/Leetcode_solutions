package DP_String_P2_EditDistance;

import java.util.Arrays;

/**
 * LeetCode 72: Edit Distance
 * 
 * Given two strings word1 and word2, return minimum number of operations to convert word1 to word2.
 * 
 * Time Complexity: O(M * N)
 * Space Complexity: O(M * N) -> O(N) space optimized
 */
public class DP_String_P2_EditDistance {

    // Entry point algorithm wrapper with edge case validation
    public int p2_solve(String s1, String s2) {
        if (word1 == null || word2 == null) return 0; if (word1.length() == 0) return word2.length(); if (word2.length() == 0) return word1.length();
        return 0;
    }

    // Top-Down Memoization approach with state caching
    public int solveMemo(String w1, String w2, int i, int j, int[][] memo) {
        if (i == 0) return j;
        if (j == 0) return i;
        if (memo[i][j] != -1) return memo[i][j];
        if (w1.charAt(i - 1) == w2.charAt(j - 1)) {
            return memo[i][j] = solveMemo(w1, w2, i - 1, j - 1, memo);
        }
        return memo[i][j] = 1 + Math.min(solveMemo(w1, w2, i, j - 1, memo),
                            Math.min(solveMemo(w1, w2, i - 1, j, memo), solveMemo(w1, w2, i - 1, j - 1, memo)));
    }

    // Bottom-Up 2D Dynamic Programming table calculation
    public int minDistanceTab(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) dp[i][0] = i;
        for (int j = 0; j <= n; j++) dp[0][j] = j;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j - 1]));
                }
            }
        }
        return dp[m][n];
    }

    // 1D Space Optimized Dynamic Programming implementation
    public int minDistanceOptimized(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[] prev = new int[n + 1], curr = new int[n + 1];
        for (int j = 0; j <= n; j++) prev[j] = j;
        for (int i = 1; i <= m; i++) {
            curr[0] = i;
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    curr[j] = prev[j - 1];
                } else {
                    curr[j] = 1 + Math.min(curr[j - 1], Math.min(prev[j], prev[j - 1]));
                }
            }
            prev = curr.clone();
        }
        return prev[n];
    }

    public static void main(String[] args) {
        DP_String_P2_EditDistance ed = new DP_String_P2_EditDistance();
        System.out.println("Test 1 Result: " + ed.minDistance("horse", "ros"));       // 3
        System.out.println("Test 2 Result: " + ed.minDistance("intention", "execution")); // 5
    }
}
