class Solution {
    public boolean isGood(int[] nums) {
        
        Arrays.sort(nums);
        int len = nums.length;

        for (int i = 0; i < len - 1; i++) {
            if (nums[i] != i + 1) {
                return false;
            }
        }

        return nums[len - 1] == len - 1;
    }
}