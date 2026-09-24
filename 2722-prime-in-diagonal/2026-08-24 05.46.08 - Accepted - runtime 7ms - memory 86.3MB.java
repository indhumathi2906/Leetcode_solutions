class Solution {
        public boolean isPrime(int n){
               if(n<=1) return false;
                      for(int i = 2;i*i<=n;i++){
                                 if(n % i == 0) return false;
                                        }
                                               return true;
                                                   }
                                                       public int diagonalPrime(int[][] nums) {
                                                               int [] diags = new int[2*nums.length];
                                                                       int idxI = 0;
                                                                               
                                                                                       for(int i=0;i<nums.length;i++){
                                                                                                   for(int j=0;j<nums.length;j++){
                                                                                                                   if((i==j) || (i+j)==nums.length-1){
                                                                                                                                      diags[idxI] = nums[i][j];
                                                                                                                                                         idxI++;
                                                                                                                                                                         }
                                                                                                                                                                                         
                                                                                                                                                                                                     }
                                                                                                                                                                                                                 
                                                                                                                                                                                                                         }
                                                                                                                                                                                                                                 int maxPrime = 0;
                                                                                                                                                                                                                                         for(int i=0;i<idxI;i++){
                                                                                                                                                                                                                                                     if(isPrime(diags[i])) {maxPrime = Math.max(diags[i],maxPrime);}
                                                                                                                                                                                                                                                             }
                                                                                                                                                                                                                                                                     return maxPrime;
                                                                                                                                                                                                                                                                         }
                                                                                                                                                                                                                                                                         
}