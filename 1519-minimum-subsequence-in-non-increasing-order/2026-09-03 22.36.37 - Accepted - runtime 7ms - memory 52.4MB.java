class Solution {
    public List<Integer> minSubsequence(int[] nums) {
        List<Integer> minSubSequence = new ArrayList<>();
        
        Arrays.sort(nums);
        
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        
        
        int current_sum = 0;
        
        
        for (int j = nums.length - 1; j >= 0; j--) {
            sum -= nums[j];  
            current_sum += nums[j];  
            minSubSequence.add(nums[j]);  
            
        
            if (current_sum > sum) {
                return minSubSequence;  
            }
        }
        
        return minSubSequence;  
    }
}