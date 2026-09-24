class Solution {
        public int buttonWithLongestTime(int[][] events) {
                int maxi = 0;
                        int idx = 0;
                                int prevTime = 0;
                                        for(int arr[] : events)
                                                    {
                                                                    int time = arr[1]-prevTime;
                                                                                    prevTime = arr[1];
                                                                                                    int index = arr[0];
                                                                                                                    if(time > maxi)
                                                                                                                                    {
                                                                                                                                                        maxi = time;
                                                                                                                                                                            idx = index;
                                                                                                                                                                                            }
                                                                                                                                                                                                            else if(time == maxi)
                                                                                                                                                                                                                            {
                                                                                                                                                                                                                                                idx = Math.min(idx,index);
                                                                                                                                                                                                                                                                }
                                                    }        
                                                                                                                                                                                                                                                                                    return idx;
                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                        }
