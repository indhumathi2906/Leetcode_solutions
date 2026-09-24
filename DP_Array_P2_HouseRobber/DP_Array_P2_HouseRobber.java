package DP_Array_P2_HouseRobber;

import java.util.Arrays;

public class DP_Array_P2_HouseRobber {

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
        System.out.println("House Robber: " + solver.robSpaceOptimized(nums));
    }
}
