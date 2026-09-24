package DP_Array_P3_MaximumProductSubarray;

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
}
