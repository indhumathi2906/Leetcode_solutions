package DP_Array_P2_HouseRobber;

import java.util.Arrays;

/**
 * DP Array Problem 2: 198. House Robber (LeetCode #198)
 * Link: https://leetcode.com/problems/house-robber/
 *
 * Description:
 * You are a professional robber planning to rob houses along a street. Each house has a certain
 * amount of money stashed. Adjacent houses have security systems connected — it will automatically
 * contact the police if two adjacent houses were broken into on the same night.
 * Determine maximum amount of money you can rob without alerting the police.
 *
 * Time Complexity: O(N)
 * Space Complexity: Top-Down O(N), Bottom-Up O(N), Space-Optimized O(1)
 */
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

    // Approach 2: Bottom-Up DP (Tabulation)
    public int robTabulation(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
        }
        return dp[nums.length - 1];
    }

    // Approach 3: Space-Optimized DP (O(1) Space)
    public int robSpaceOptimized(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int prev2 = nums[0];
        int prev1 = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            int current = Math.max(prev1, nums[i] + prev2);
            prev2 = prev1;
            prev1 = current;
        }
        return prev1;
    }

    public static void main(String[] args) {
        DP_Array_P2_HouseRobber solver = new DP_Array_P2_HouseRobber();
        int[] nums = {2, 7, 9, 3, 1};
        System.out.println("House Robber " + Arrays.toString(nums) + ":");
        System.out.println("Memoization: " + solver.robMemo(nums));
        System.out.println("Tabulation:  " + solver.robTabulation(nums));
        System.out.println("Optimized:   " + solver.robSpaceOptimized(nums));
        assert solver.robSpaceOptimized(nums) == 12;
    }
}
