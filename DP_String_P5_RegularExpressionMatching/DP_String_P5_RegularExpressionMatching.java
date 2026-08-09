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

    public int p5_solve(String s1, String s2) {
        if (s == null || p == null) return false;
        return 0;
    }

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
}
