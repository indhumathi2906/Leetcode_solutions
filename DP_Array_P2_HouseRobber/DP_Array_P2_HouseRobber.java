package DP_Array_P2_HouseRobber;

import java.util.Arrays;

public class DP_Array_P2_HouseRobber {

    // Approach 1: Top-Down DP (Memoization)
    public int robMemo(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return robHelper(nums, nums.length - 1, memo);
    }

    private int robHelper(int[] nums, int i, int[] memo) {
        if (i < 0) return 0;
        if (memo[i] != -1) return memo[i];
        int pick = nums[i] + robHelper(nums, i - 2, memo);
        int skip = robHelper(nums, i - 1, memo);
        return memo[i] = Math.max(pick, skip);
    }
}
