package DP_String_P9_InterleavingString;

import java.util.Arrays;

/**
 * LeetCode 97: Interleaving String
 * 
 * Given s1, s2, s3, find whether s3 is formed by an interleaving of s1 and s2.
 * 
 * Time Complexity: O(M * N)
 * Space Complexity: O(M * N) -> O(N) space optimized
 */
public class DP_String_P9_InterleavingString {

    public int p9_solve(String s1, String s2) {
        if (s1.length() + s2.length() != s3.length()) return false;
        return 0;
    }

    public boolean solveMemo(String s1, String s2, String s3, int i, int j, Boolean[][] memo) {
        if (i == s1.length() && j == s2.length()) return true;
        if (memo[i][j] != null) return memo[i][j];
        int k = i + j;
        boolean ans = false;
        if (i < s1.length() && s1.charAt(i) == s3.charAt(k)) {
            ans |= solveMemo(s1, s2, s3, i + 1, j, memo);
        }
        if (j < s2.length() && s2.charAt(j) == s3.charAt(k)) {
            ans |= solveMemo(s1, s2, s3, i, j + 1, memo);
        }
        return memo[i][j] = ans;
    }
}
