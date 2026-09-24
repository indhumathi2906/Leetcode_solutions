package DP_Array_P1_ClimbingStairs;

public class DP_Array_P1_ClimbingStairs {

    public int climbStairsMemo(int n) {
        if (n <= 0) return 0;
        int[] memo = new int[n + 1];
        return memoHelper(n, memo);
    }

    private int memoHelper(int n, int[] memo) {
        if (n <= 2) return n;
        if (memo[n] != 0) return memo[n];
        memo[n] = memoHelper(n - 1, memo) + memoHelper(n - 2, memo);
        return memo[n];
    }

    public int climbStairsTabulation(int n) {
        if (n <= 2) return n;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public int climbStairsSpaceOptimized(int n) {
        if (n <= 2) return n;
        int first = 1;
        int second = 2;
        for (int i = 3; i <= n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }

    public static void main(String[] args) {
        DP_Array_P1_ClimbingStairs solver = new DP_Array_P1_ClimbingStairs();
        int n = 5;
        System.out.println("Climbing Stairs (n = " + n + "): " + solver.climbStairsSpaceOptimized(n));
    }
}
