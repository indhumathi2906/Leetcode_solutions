package DP_Array_P5_LongestIncreasingSubsequence;

import java.util.Arrays;

public class DP_Array_P5_LongestIncreasingSubsequence {

    public int lengthOfLISMemo(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[][] memo = new int[nums.length][nums.length + 1];
        for (int[] row : memo) Arrays.fill(row, -1);
        return memoHelper(nums, -1, 0, memo);
    }

    private int memoHelper(int[] nums, int prevIdx, int currIdx, int[][] memo) {
        if (currIdx == nums.length) return 0;
        if (memo[currIdx][prevIdx + 1] != -1) return memo[currIdx][prevIdx + 1];

        int take = 0;
        if (prevIdx == -1 || nums[currIdx] > nums[prevIdx]) {
            take = 1 + memoHelper(nums, currIdx, currIdx + 1, memo);
        }
        int skip = memoHelper(nums, prevIdx, currIdx + 1, memo);

        return memo[currIdx][prevIdx + 1] = Math.max(take, skip);
    }

    // Approach 2: Bottom-Up DP (Tabulation O(N^2))
    public int lengthOfLISTabulation(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int maxLIS = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLIS = Math.max(maxLIS, dp[i]);
        }
        return maxLIS;
    }
}
