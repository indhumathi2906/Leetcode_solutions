class Solution {
        public int countDigits(int num) {
                int n=num,r,s=0;
                        while(num!=0)
                                {
                                            r=num%10;
                                                        if (n%r==0)
                                                                    s+=1;
                                                                                num=num/10;
                                                                                        }
                                                                                                return s;
                                                                                                    }
                                                                                                    }
