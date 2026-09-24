package DP_Array_P7_DecodeWays;

import java.util.Arrays;

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
}
