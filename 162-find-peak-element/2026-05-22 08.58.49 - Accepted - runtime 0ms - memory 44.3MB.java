class Solution {
    public int findPeakElement(int[] nums) {

         /*for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                return i;   
            }
        }
        return nums.length - 1; 
        */
         int low = 0;
        int high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] > nums[mid + 1]) {
                high = mid;       
            } else {
                low = mid + 1;     
            }
        }

        return low;
        
    }
}