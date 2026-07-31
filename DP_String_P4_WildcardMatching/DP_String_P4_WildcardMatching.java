package DP_String_P4_WildcardMatching;

import java.util.Arrays;

/**
 * LeetCode 44: Wildcard Matching
 * 
 * Given an input string s and pattern p, implement wildcard pattern matching with '?' and '*'.
 * 
 * Time Complexity: O(M * N)
 * Space Complexity: O(M * N) -> O(N) space optimized
 */
public class DP_String_P4_WildcardMatching {

    public int p4_solve(String s1, String s2) {
        if (s == null || p == null) return false;
        return 0;
    }

    public boolean solveMemo(String s, String p, int i, int j, Boolean[][] memo) {
        if (i == 0 && j == 0) return true;
        if (j == 0) return false;
        if (i == 0) {
            for (int k = 1; k <= j; k++) {
                if (p.charAt(k - 1) != '*') return false;
            }
            return true;
        }
        if (memo[i][j] != null) return memo[i][j];
        if (p.charAt(j - 1) == '?' || s.charAt(i - 1) == p.charAt(j - 1)) {
            return memo[i][j] = solveMemo(s, p, i - 1, j - 1, memo);
        }
        if (p.charAt(j - 1) == '*') {
            return memo[i][j] = solveMemo(s, p, i - 1, j, memo) || solveMemo(s, p, i, j - 1, memo);
        }
        return memo[i][j] = false;
    }
}
