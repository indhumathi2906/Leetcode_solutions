package DP_String_P8_ShortestCommonSupersequence;

import java.util.Arrays;

/**
 * LeetCode 1092: Shortest Common Supersequence
 * 
 * Given two strings str1 and str2, return the shortest string that has both str1 and str2 as subsequences.
 * 
 * Time Complexity: O(M * N)
 * Space Complexity: O(M * N) -> O(N) space optimized
 */
public class DP_String_P8_ShortestCommonSupersequence {

    public int p8_solve(String s1, String s2) {
        if (str1 == null) return str2; if (str2 == null) return str1;
        return 0;
    }

    public String shortestCommonSupersequence(String str1, String str2) {
        int m = str1.length(), n = str2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return buildSCS(str1, str2, dp);
    }

    private String buildSCS(String str1, String str2, int[][] dp) {
        StringBuilder sb = new StringBuilder();
        int i = str1.length(), j = str2.length();
        while (i > 0 && j > 0) {
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                sb.append(str1.charAt(i - 1));
                i--; j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                sb.append(str1.charAt(i - 1));
                i--;
            } else {
                sb.append(str2.charAt(j - 1));
                j--;
            }
        }
        while (i > 0) { sb.append(str1.charAt(i - 1)); i--; }
        while (j > 0) { sb.append(str2.charAt(j - 1)); j--; }
        return sb.reverse().toString();
    }
}
