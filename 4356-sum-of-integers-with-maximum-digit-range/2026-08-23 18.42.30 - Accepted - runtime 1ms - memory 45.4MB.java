class Solution {
        public int maxDigitRange(int[] nums) {
                int n=nums.length;
                        int maxrange=-1;
                                int sum=0;
                                      for(int i=0;i<n;i++){
                                                int temp=nums[i];
                                                            int largest=0;
                                                                        int smallest=9; // (0-9)
                                                                                    while(temp>0){
                                                                                                int  val=temp%10;
                                                                                                                largest=Math.max(val,largest);
                                                                                                                                smallest=Math.min(val,smallest);
                                                                                                                                                temp=temp/10;
                                                                                                                                                            }
                                                                                                                                                                      int range=largest-smallest;
                                                                                                                                                                                if(range>maxrange) {
                                                                                                                                                                                              maxrange=range;
                                                                                                                                                                                                            sum=nums[i];
                                                                                                                                                                                                                          
                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                               else  if(maxrange==range){
                                                                                                                                                                                                                                                             sum=sum+nums[i];
                                                                                                                                                                                                                                                                       }
                                                                                                                                                                                                                                                                                 
                                                                                                                                                                                                                                                                                             
                                                                                                                                                                                                                                                                                                     }
                                                                                                                                                                                                                                                                                                             return sum;
                                                                                                                                                                                                                                                                                                                     
                                                                                                                                                                                                                                                                                                                             
                                                                                                                                                                                                                                                                                                                                     
                                                                                                                                                                                                                                                                                                                                         }
                                                                                                                                                                                                                                                                                                                                         
}