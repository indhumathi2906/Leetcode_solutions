class Solution {
    public int smallestNumber(int n, int t) {
        for(int res=n;res<=n+t;res++){
                        int pro=1;
                                    int cur=res;
                                                while(cur>0){
                                                                pro=pro*(cur%10);
                                                                                cur=cur/10;
                                                                                            }
                                                                                                        if(pro%t==0){
                                                                                                                        return res;
                                                                                                                                    }
                                                                                                                                            }
                                                                                                                                                    return n;
                                                                                                                                                        }
                                                                                                                                                        }
        
