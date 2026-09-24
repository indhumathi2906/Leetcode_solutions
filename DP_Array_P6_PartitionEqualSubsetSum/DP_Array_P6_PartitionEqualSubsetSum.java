package DP_Array_P6_PartitionEqualSubsetSum;

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
}
