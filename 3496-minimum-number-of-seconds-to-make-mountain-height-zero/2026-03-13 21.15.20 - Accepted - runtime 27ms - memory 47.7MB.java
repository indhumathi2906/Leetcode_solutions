class Solution {

    public long maxHeight(long T, int[] workerTimes){
        long total = 0;

        for(int t : workerTimes){
            long val = (long)(2 * T / t);

            long x = (long)((Math.sqrt(1 + 4 * val) - 1) / 2);

            total += x;
        }

        return total;
    }

    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {

        long left = 0;
        long right = (long)1e18;
        long ans = right;

        while(left <= right){
            long mid = left + (right - left) / 2;

            if(maxHeight(mid, workerTimes) >= mountainHeight){
                ans = mid;
                right = mid - 1;
            } else{
                left = mid + 1;
            }
        }

        return ans;
    }
}