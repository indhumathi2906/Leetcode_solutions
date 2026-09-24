class Solution {
    public int[] sortedSquares(int[] nums) {
        int len=nums.length;
        int left=0;
        int right=len-1;
        int index=len-1;
        int [] result=new int[len];
        while(left<=right){
            int leftsq=nums[left]*nums[left];
            int rightsq=nums[right]*nums[right];

            if(leftsq>rightsq){
                result[index]=leftsq;
                left++;
            }
            else{
                result[index]=rightsq;
                right--;
            }
            index--;
        }
        return result;
        
    }
}