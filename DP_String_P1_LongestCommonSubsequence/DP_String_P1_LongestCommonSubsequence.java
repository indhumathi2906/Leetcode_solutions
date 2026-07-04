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
}
