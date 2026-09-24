class Solution {
        public long pickGifts(int[] gifts, int k) {
                int n = gifts.length;
                        while(k-->0)
                                {
                                            int max = Integer.MIN_VALUE;
                                                        int maxIdx = -1;
                                                                    for(int i=0;i<n;i++)
                                                                                {
                                                                                                 if(gifts[i]>max)
                                                                                                                  {
                                                                                                                                      max = gifts[i];
                                                                                                                                                          maxIdx = i;
                                                                                                                                                                           }
                                                                                                                                                                                       }
                                                                                                                                                                                                   gifts[maxIdx]=(int)Math.sqrt(gifts[maxIdx]);
                                                                                                                                                                                                           }
                                                                                                                                                                                                                   long res=0;
                                                                                                                                                                                                                           for(int i=0;i<n;i++)
                                                                                                                                                                                                                                       res+=gifts[i];

                                                                                                                                                                                                                                               return res;
                                                                                                                                                                                                                                                   }
                                                                                                                                                                                                                                                   
}