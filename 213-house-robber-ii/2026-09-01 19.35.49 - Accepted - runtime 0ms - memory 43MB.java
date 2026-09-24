class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if(n == 1) return nums[0];

        return Math.max(
            robInRange(0, n - 1, nums),
            robInRange(1, n, nums)
        );
    }

    public int robInRange(int s, int e, int[] nums) {
        int prev2 = 0;
        int prev1 = 0;

        for(int i = s; i < e; i++) {
            int curr = Math.max(prev1, prev2 + nums[i]);

            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }
}