class Solution {
    public int maxRotateFunction(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        long sum = 0;
        long f0 = 0;

        for (int i = 0; i < n; i++) {
            sum += nums[i];
            f0 += (long) i * nums[i];
        }

        long maxF = f0;
        long currentF = f0;

        for (int k = 1; k < n; k++) {
            // F(k) = F(k-1) + sum - n * nums[n - k]
            currentF = currentF + sum - (long) n * nums[n - k];
            maxF = Math.max(maxF, currentF);
        }

        return (int) maxF;
    }
}