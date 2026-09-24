package DP_Array_P7_DecodeWays;

import java.util.Arrays;

/**
 * DP Array Problem 7: 91. Decode Ways (LeetCode #91)
 * Link: https://leetcode.com/problems/decode-ways/
 *
 * Description:
 * A message containing letters from A-Z can be encoded into numbers using 'A' -> "1", 'B' -> "2", ..., 'Z' -> "26".
 * To decode an encoded message, all digits must be grouped then mapped back into letters.
 * Given a string s containing only digits, return the number of ways to decode it.
 *
 * Time Complexity: O(N)
 * Space Complexity: Top-Down O(N), Bottom-Up O(N), Space-Optimized O(1)
 */
public class DP_Array_P7_DecodeWays {

    // Approach 1: Top-Down DP (Memoization)
    public int numDecodingsMemo(String s) {
        if (s == null || s.length() == 0) return 0;
        int[] memo = new int[s.length()];
        Arrays.fill(memo, -1);
        return memoHelper(s, 0, memo);
    }

    private int memoHelper(String s, int index, int[] memo) {
        if (index == s.length()) return 1;
        if (s.charAt(index) == '0') return 0;
        if (memo[index] != -1) return memo[index];

        int ways = memoHelper(s, index + 1, memo);

        if (index + 1 < s.length()) {
            int twoDigit = Integer.parseInt(s.substring(index, index + 2));
            if (twoDigit >= 10 && twoDigit <= 26) {
                ways += memoHelper(s, index + 2, memo);
            }
        }
        return memo[index] = ways;
    }

    // Approach 2: Bottom-Up 1D Tabulation
    public int numDecodingsTabulation(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') return 0;
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            int oneDigit = Integer.parseInt(s.substring(i - 1, i));
            int twoDigit = Integer.parseInt(s.substring(i - 2, i));

            if (oneDigit >= 1 && oneDigit <= 9) {
                dp[i] += dp[i - 1];
            }
            if (twoDigit >= 10 && twoDigit <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[n];
    }

    // Approach 3: Space-Optimized DP (O(1) Space)
    public int numDecodingsSpaceOptimized(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') return 0;
        int n = s.length();
        int prev2 = 1;
        int prev1 = 1;

        for (int i = 2; i <= n; i++) {
            int current = 0;
            int oneDigit = Integer.parseInt(s.substring(i - 1, i));
            int twoDigit = Integer.parseInt(s.substring(i - 2, i));

            if (oneDigit >= 1 && oneDigit <= 9) {
                current += prev1;
            }
            if (twoDigit >= 10 && twoDigit <= 26) {
                current += prev2;
            }
            prev2 = prev1;
            prev1 = current;
        }
        return prev1;
    }

    public static void main(String[] args) {
        DP_Array_P7_DecodeWays solver = new DP_Array_P7_DecodeWays();
        String s = "226";
        System.out.println("Decode Ways for \\\"" + s + "\\\":");
        System.out.println("Memoization: " + solver.numDecodingsMemo(s));
        System.out.println("Tabulation:  " + solver.numDecodingsTabulation(s));
        System.out.println("Optimized:   " + solver.numDecodingsSpaceOptimized(s));
        assert solver.numDecodingsSpaceOptimized(s) == 3;
    }
}
