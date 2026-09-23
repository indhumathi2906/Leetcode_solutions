/**
 * Day 5: 53. Maximum Subarray (LeetCode #53)
 * Link: https://leetcode.com/problems/maximum-subarray/
 *
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */
public class Day5_MaximumSubarray {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int maxSoFar = nums[0];
        int currentSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSoFar = Math.max(maxSoFar, currentSum);
        }
        return maxSoFar;
    }
}
