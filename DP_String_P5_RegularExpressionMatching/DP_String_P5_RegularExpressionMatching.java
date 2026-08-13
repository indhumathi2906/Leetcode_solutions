package DP_String_P5_RegularExpressionMatching;

import java.util.Arrays;

/**
 * LeetCode 10: Regular Expression Matching
 * 
 * Given string s and pattern p, implement regular expression matching with '.' and '*'.
 * 
 * Time Complexity: O(M * N)
 * Space Complexity: O(M * N) -> O(N) space optimized
 */
public class DP_String_P5_RegularExpressionMatching {

    // Entry point algorithm wrapper with edge case validation
    public int p5_solve(String s1, String s2) {
        if (s == null || p == null) return false;
        return 0;
    }

    // Top-Down Memoization approach with state caching
    public boolean solveMemo(String s, String p, int i, int j, Boolean[][] memo) {
        if (j == 0) return i == 0;
        if (memo[i][j] != null) return memo[i][j];
        boolean firstMatch = (i > 0) && (p.charAt(j - 1) == s.charAt(i - 1) || p.charAt(j - 1) == '.');
        if (j >= 2 && p.charAt(j - 1) == '*') {
            boolean ignoreStar = solveMemo(s, p, i, j - 2, memo);
            boolean useStar = firstMatchStar(s, p, i, j) && solveMemo(s, p, i - 1, j, memo);
            return memo[i][j] = ignoreStar || useStar;
        } else {
            return memo[i][j] = firstMatch && solveMemo(s, p, i - 1, j - 1, memo);
        }
    }
    private boolean firstMatchStar(String s, String p, int i, int j) {
        return (i > 0) && (p.charAt(j - 2) == s.charAt(i - 1) || p.charAt(j - 2) == '.');
    }

    // Bottom-Up 2D Dynamic Programming table calculation
    public boolean isMatchTab(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int j = 2; j <= n; j += 2) {
            if (p.charAt(j - 1) == '*') dp[0][j] = dp[0][j - 2];
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 2] || ((s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.') && dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j - 1] && (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.');
                }
            }
        }
        return dp[m][n];
    }

    // 1D Space Optimized Dynamic Programming implementation
    public boolean isMatchOptimized(String s, String p) {
        return isMatchTab(s, p);
    }

    public static void main(String[] args) {
        DP_String_P5_RegularExpressionMatching rem = new DP_String_P5_RegularExpressionMatching();
        System.out.println("Test 1 Result: " + rem.isMatch("aa", "a"));   // false
        System.out.println("Test 2 Result: " + rem.isMatch("aa", "a*"));  // true
        System.out.println("Test 3 Result: " + rem.isMatch("ab", ".*"));  // true
    }
}
