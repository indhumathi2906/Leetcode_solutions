class Solution {
    public int[] maxValue(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int[] rightMin = new int[n];

        rightMin[n - 1] = nums[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            rightMin[i] = Math.min(nums[i], rightMin[i + 1]);
        }

        int start = 0;
        int max = nums[0];

        for (int i = 0; i < n; i++) {
            max = Math.max(max, nums[i]);

            if (i == n - 1 || max <= rightMin[i + 1]) {
                for (int j = start; j <= i; j++) {
                    ans[j] = max;
                }

                start = i + 1;

                if (start < n) {
                    max = nums[start];
                }
            }
        }

        return ans;
    }
}
        
    
