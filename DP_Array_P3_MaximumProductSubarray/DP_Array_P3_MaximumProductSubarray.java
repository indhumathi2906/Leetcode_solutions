package DP_Array_P3_MaximumProductSubarray;

import java.util.Arrays;

/**
 * DP Array Problem 3: 152. Maximum Product Subarray (LeetCode #152)
 * Link: https://leetcode.com/problems/maximum-product-subarray/
 *
 * Description:
 * Given an integer array nums, find a contiguous non-empty subarray that has the largest product,
 * and return the product.
 *
 * Key Insight: Multiplying two negative numbers yields a positive number.
 * We must maintain both maximum and minimum product DP states at each index.
 *
 * Time Complexity: O(N)
 * Space Complexity: Tabulation O(N), Space-Optimized O(1)
 */
public class DP_Array_P3_MaximumProductSubarray {

    // Approach 1: Brute Force Baseline
    public int maxProductBruteForce(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int maxProd = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int currentProd = 1;
            for (int j = i; j < nums.length; j++) {
                currentProd *= nums[j];
                maxProd = Math.max(maxProd, currentProd);
            }
        }
        return maxProd;
    }

    // Approach 2: Dual DP Tables (Tabulation)
    public int maxProductTabulation(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int n = nums.length;
        int[] maxDP = new int[n];
        int[] minDP = new int[n];

        maxDP[0] = nums[0];
        minDP[0] = nums[0];
        int globalMax = nums[0];

        for (int i = 1; i < n; i++) {
            if (nums[i] < 0) {
                maxDP[i] = Math.max(nums[i], minDP[i - 1] * nums[i]);
                minDP[i] = Math.min(nums[i], maxDP[i - 1] * nums[i]);
            } else {
                maxDP[i] = Math.max(nums[i], maxDP[i - 1] * nums[i]);
                minDP[i] = Math.min(nums[i], minDP[i - 1] * nums[i]);
            }
            globalMax = Math.max(globalMax, maxDP[i]);
        }
        return globalMax;
    }

    // Approach 3: Space-Optimized DP (O(1) Space)
    public int maxProductSpaceOptimized(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int maxSoFar = nums[0];
        int minSoFar = nums[0];
        int result = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];
            if (curr < 0) {
                int temp = maxSoFar;
                maxSoFar = minSoFar;
                minSoFar = temp;
            }

            maxSoFar = Math.max(curr, maxSoFar * curr);
            minSoFar = Math.min(curr, minSoFar * curr);

            result = Math.max(result, maxSoFar);
        }
        return result;
    }

    public static void main(String[] args) {
        DP_Array_P3_MaximumProductSubarray solver = new DP_Array_P3_MaximumProductSubarray();
        int[] nums = {2, 3, -2, 4};
        System.out.println("Max Product Subarray " + Arrays.toString(nums) + ":");
        System.out.println("Brute Force: " + solver.maxProductBruteForce(nums));
        System.out.println("Tabulation:  " + solver.maxProductTabulation(nums));
        System.out.println("Optimized:   " + solver.maxProductSpaceOptimized(nums));
        assert solver.maxProductSpaceOptimized(nums) == 6;
    }
}
