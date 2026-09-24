class Solution {
        public long findTheArrayConcVal(int[] nums) {
                long ans = 0;
                        int l = 0;
                                int r = nums.length - 1;
                                        while (l < r) {
                                                    int rightVal = nums[r];
                                                                int multi;
                                                                            if(rightVal >= 10000) multi = 100000;
                                                                                        else if(rightVal >= 1000) multi = 10000;
                                                                                                    else if(rightVal >= 100) multi = 1000;
                                                                                                                else if(rightVal >= 10) multi = 100;
                                                                                                                            else multi =  10;

                                                                                                                                        ans += (long) nums[l] * multi + rightVal;
                                                                                                                                                    l++;
                                                                                                                                                                r--;
                                                                                                                                                                        }
                                                                                                                                                                                if(l == r) ans += nums[l];
                                                                                                                                                                                        return ans;
                                                                                                                                                                                            }
                                                                                                                                                                                            
}