class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        
         int landThenWater = solve(landStartTime, landDuration,
                                  waterStartTime, waterDuration);

        int waterThenLand = solve(waterStartTime, waterDuration,
                                  landStartTime, landDuration);

        return Math.min(landThenWater, waterThenLand);
    }

    private int solve(int[] start1, int[] dur1,
                      int[] start2, int[] dur2) {

        int firstRideFinish = Integer.MAX_VALUE;

        
        for (int i = 0; i < start1.length; i++) {
            firstRideFinish = Math.min(firstRideFinish,
                                       start1[i] + dur1[i]);
        }

        int ans = Integer.MAX_VALUE;

        
        for (int i = 0; i < start2.length; i++) {
            int finishTime = Math.max(firstRideFinish, start2[i]) + dur2[i];
            ans = Math.min(ans, finishTime);
        }

        return ans;
    }
}