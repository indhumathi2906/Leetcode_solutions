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

    // Entry point algorithm wrapper with edge case validation
    public int p9_solve(String s1, String s2) {
        if (s1.length() + s2.length() != s3.length()) return false;
        return 0;
    }

    // Top-Down Memoization approach with state caching
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

    // Bottom-Up 2D Dynamic Programming table calculation
    public boolean isInterleaveTab(String s1, String s2, String s3) {
        int m = s1.length(), n = s2.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 1; i <= m; i++) dp[i][0] = dp[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1);
        for (int j = 1; j <= n; j++) dp[0][j] = dp[0][j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int k = i + j - 1;
                dp[i][j] = (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(k)) ||
                           (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(k));
            }
        }
        return dp[m][n];
    }

    // 1D Space Optimized Dynamic Programming implementation
    public boolean isInterleaveOptimized(String s1, String s2, String s3) {
        int m = s1.length(), n = s2.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int j = 1; j <= n; j++) dp[j] = dp[j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
        for (int i = 1; i <= m; i++) {
            dp[0] = dp[0] && s1.charAt(i - 1) == s3.charAt(i - 1);
            for (int j = 1; j <= n; j++) {
                int k = i + j - 1;
                dp[j] = (dp[j] && s1.charAt(i - 1) == s3.charAt(k)) ||
                        (dp[j - 1] && s2.charAt(j - 1) == s3.charAt(k));
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        DP_String_P9_InterleavingString il = new DP_String_P9_InterleavingString();
        System.out.println("Test 1 Result: " + il.isInterleave("aabcc", "dbbca", "aadbbcbcac")); // true
        System.out.println("Test 2 Result: " + il.isInterleave("aabcc", "dbbca", "aadbbbaccc")); // false
    }

    // Helper method: Return problem name metadata
    public String getProblemName() {
        return "Interleaving String";
    }
}
