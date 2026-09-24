package DP_Array_P3_MaximumProductSubarray;

public class DP_Array_P3_MaximumProductSubarray {

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
}
