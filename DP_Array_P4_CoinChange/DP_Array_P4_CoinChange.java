package DP_Array_P4_CoinChange;

import java.util.Arrays;

public class DP_Array_P4_CoinChange {

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
}
