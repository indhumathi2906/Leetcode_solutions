package DP_Array_P6_PartitionEqualSubsetSum;

import java.util.Arrays;

/**
 * DP Array Problem 6: 416. Partition Equal Subset Sum (LeetCode #416)
 * Link: https://leetcode.com/problems/partition-equal-subset-sum/
 *
 * Description:
 * Given an integer array nums, return true if you can partition the array into two subsets
 * such that the sum of the elements in both subsets is equal or false otherwise.
 *
 * Subset Sum 0/1 Knapsack Pattern.
 *
 * Time Complexity: O(N * Target)
 * Space Complexity: 2D DP O(N * Target), 1D Space-Optimized O(Target)
 */
public class DP_Array_P6_PartitionEqualSubsetSum {

    // Approach 1: Top-Down DP (Memoization)
    public boolean canPartitionMemo(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        int totalSum = 0;
        for (int num : nums) totalSum += num;
        if (totalSum % 2 != 0) return false;

        int target = totalSum / 2;
        Boolean[][] memo = new Boolean[nums.length][target + 1];
        return memoHelper(nums, 0, target, memo);
    }

    private boolean memoHelper(int[] nums, int index, int target, Boolean[][] memo) {
        if (target == 0) return true;
        if (index >= nums.length || target < 0) return false;
        if (memo[index][target] != null) return memo[index][target];

        boolean include = memoHelper(nums, index + 1, target - nums[index], memo);
        boolean exclude = memoHelper(nums, index + 1, target, memo);

        return memo[index][target] = (include || exclude);
    }

    // Approach 2: Bottom-Up 2D Tabulation
    public boolean canPartitionTabulation(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum % 2 != 0) return false;

        int target = sum / 2;
        int n = nums.length;
        boolean[][] dp = new boolean[n + 1][target + 1];

        for (int i = 0; i <= n; i++) dp[i][0] = true;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                if (nums[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][target];
    }

    // Approach 3: 1D Space-Optimized DP
    public boolean canPartitionSpaceOptimized(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum % 2 != 0) return false;

        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        for (int num : nums) {
            for (int j = target; j >= num; j--) {
                dp[j] = dp[j] || dp[j - num];
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        DP_Array_P6_PartitionEqualSubsetSum solver = new DP_Array_P6_PartitionEqualSubsetSum();
        int[] nums = {1, 5, 11, 5};
        System.out.println("Partition Equal Subset Sum " + Arrays.toString(nums) + ":");
        System.out.println("Memoization: " + solver.canPartitionMemo(nums));
        System.out.println("Tabulation:  " + solver.canPartitionTabulation(nums));
        System.out.println("Optimized:   " + solver.canPartitionSpaceOptimized(nums));
        assert solver.canPartitionSpaceOptimized(nums) == true;
    }
}
