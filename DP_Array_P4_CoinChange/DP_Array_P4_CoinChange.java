package DP_Array_P4_CoinChange;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * DP Array Problem 4: 322. Coin Change (LeetCode #322)
 * Link: https://leetcode.com/problems/coin-change/
 *
 * Description:
 * You are given an integer array coins representing coins of different denominations and an integer
 * amount representing a total amount of money.
 * Return the fewest number of coins that you need to make up that amount. If that amount of money
 * cannot be made up by any combination of the coins, return -1.
 *
 * Unbounded Knapsack Pattern.
 *
 * Time Complexity: O(Amount * N)
 * Space Complexity: O(Amount)
 */
public class DP_Array_P4_CoinChange {

    // Approach 1: Top-Down DP (Memoization)
    public int coinChangeMemo(int[] coins, int amount) {
        if (amount < 1) return 0;
        int[] memo = new int[amount + 1];
        return memoHelper(coins, amount, memo);
    }

    private int memoHelper(int[] coins, int rem, int[] memo) {
        if (rem < 0) return -1;
        if (rem == 0) return 0;
        if (memo[rem] != 0) return memo[rem];

        int minCoins = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = memoHelper(coins, rem - coin, memo);
            if (res >= 0 && res < minCoins) {
                minCoins = 1 + res;
            }
        }
        memo[rem] = (minCoins == Integer.MAX_VALUE) ? -1 : minCoins;
        return memo[rem];
    }

    // Approach 2: Bottom-Up DP (1D Tabulation)
    public int coinChangeTabulation(int[] coins, int amount) {
        if (amount < 0) return -1;
        if (amount == 0) return 0;

        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    // Approach 3: BFS Shortest Path Traversal
    public int coinChangeBFS(int[] coins, int amount) {
        if (amount == 0) return 0;
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[amount + 1];
        queue.offer(0);
        visited[0] = true;
        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            steps++;
            for (int i = 0; i < size; i++) {
                int curr = queue.poll();
                for (int coin : coins) {
                    int next = curr + coin;
                    if (next == amount) return steps;
                    if (next < amount && !visited[next]) {
                        visited[next] = true;
                        queue.offer(next);
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        DP_Array_P4_CoinChange solver = new DP_Array_P4_CoinChange();
        int[] coins = {1, 2, 5};
        int amount = 11;
        System.out.println("Coin Change " + Arrays.toString(coins) + " target " + amount + ":");
        System.out.println("Memoization: " + solver.coinChangeMemo(coins, amount));
        System.out.println("Tabulation:  " + solver.coinChangeTabulation(coins, amount));
        System.out.println("BFS:         " + solver.coinChangeBFS(coins, amount));
        assert solver.coinChangeTabulation(coins, amount) == 3;
    }
}
