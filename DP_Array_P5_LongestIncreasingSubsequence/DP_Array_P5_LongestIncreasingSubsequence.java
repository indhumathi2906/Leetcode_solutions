package DP_Array_P5_LongestIncreasingSubsequence;

import java.util.Arrays;

/**
 * DP Array Problem 5: 300. Longest Increasing Subsequence (LeetCode #300)
 * Link: https://leetcode.com/problems/longest-increasing-subsequence/
 *
 * Description:
 * Given an integer array nums, return the length of the longest strictly increasing subsequence.
 *
 * Time Complexity:
 * - Memoization: O(N^2)
 * - Tabulation: O(N^2)
 * - Binary Search (Patience Sorting): O(N log N)
 *
 * Space Complexity: O(N)
 */
public class DP_Array_P5_LongestIncreasingSubsequence {

    // Approach 1: Top-Down DP (Memoization)
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

    // Approach 3: Binary Search Patience Sorting O(N log N)
    public int lengthOfLISBinarySearch(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] tails = new int[nums.length];
        int size = 0;

        for (int x : nums) {
            int i = 0, j = size;
            while (i < j) {
                int mid = (i + j) / 2;
                if (tails[mid] < x) {
                    i = mid + 1;
                } else {
                    j = mid;
                }
            }
            tails[i] = x;
            if (i == size) size++;
        }
        return size;
    }

    public static void main(String[] args) {
        DP_Array_P5_LongestIncreasingSubsequence solver = new DP_Array_P5_LongestIncreasingSubsequence();
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println("LIS for " + Arrays.toString(nums) + ":");
        System.out.println("Memoization:   " + solver.lengthOfLISMemo(nums));
        System.out.println("Tabulation:    " + solver.lengthOfLISTabulation(nums));
        System.out.println("Binary Search: " + solver.lengthOfLISBinarySearch(nums));
        assert solver.lengthOfLISBinarySearch(nums) == 4;
    }
}
