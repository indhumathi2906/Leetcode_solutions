class Solution {
        public boolean checkGoodInteger(int n) {
                long sum=0;
                        long sqsum=0;
                                while(n!=0){
                                            int rem=n%10;
                                                        sum+=rem;
                                                                    sqsum+=(rem*rem);
                                                                                n/=10;
                                                                                        }
                                                                                                return sqsum-sum>=50;
                                                                                                    }
                                                                                                    
}