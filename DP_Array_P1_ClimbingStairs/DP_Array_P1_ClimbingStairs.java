package DP_Array_P1_ClimbingStairs;

/**
 * DP Array Problem 1: 70. Climbing Stairs (LeetCode #70)
 * Link: https://leetcode.com/problems/climbing-stairs/
 *
 * Description:
 * You are climbing a staircase. It takes n steps to reach the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 * Time Complexity: Top-Down O(N), Bottom-Up O(N), Space-Optimized O(N)
 * Space Complexity: Top-Down O(N), Bottom-Up O(N), Space-Optimized O(1)
 */
public class DP_Array_P1_ClimbingStairs {

    // Approach 1: Top-Down DP (Recursion + Memoization)
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

    // Approach 2: Bottom-Up DP (Tabulation)
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

    // Approach 3: Space-Optimized DP (Two Variables)
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
        System.out.println("Climbing Stairs (n = " + n + "):");
        System.out.println("Memoization: " + solver.climbStairsMemo(n));
        System.out.println("Tabulation:  " + solver.climbStairsTabulation(n));
        System.out.println("Optimized:   " + solver.climbStairsSpaceOptimized(n));
        assert solver.climbStairsSpaceOptimized(n) == 8;
    }
}
