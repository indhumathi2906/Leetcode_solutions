/**
 * 53. Maximum Subarray
 *
 * Time Complexity: O(N) - single pass over array.
 * Space Complexity: O(1) - constant additional space.
 */
class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int maxSoFar = nums[0];
        int currentSum = nums[0];
        // Dynamic programming / Kadane's logic
        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSoFar = Math.max(maxSoFar, currentSum);
        }
        return maxSoFar;
    }
}
