class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> Map=new HashMap<>();
        int []arr=new int[2];
        for(int i=0;i<nums.length;i++){
            
            if(Map.containsKey(target-nums[i])){
                arr[0]=Map.get(target-nums[i]);
                arr[1]=i;
            }
            Map.put(nums[i],i);


        }
        return arr;
        
        
    }
}