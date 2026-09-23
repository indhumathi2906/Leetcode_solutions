/**
 * Day 5: 53. Maximum Subarray (LeetCode #53)
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
