class Solution {
    public int dominantIndex(int[] nums) {
        int largest=Integer.MIN_VALUE;
        int secondlargest=Integer.MIN_VALUE;
        int largeIndex=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>largest){
                secondlargest=largest;
                largest=nums[i];
                largeIndex=i;
            }
            else if(nums[i]<largest && nums[i]>secondlargest){
                secondlargest=nums[i];
            }
        }
        if((secondlargest*2)<=largest){
            return largeIndex;
        }
        return -1;
    }
}