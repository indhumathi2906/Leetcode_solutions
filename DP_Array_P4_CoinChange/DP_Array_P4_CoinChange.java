package DP_Array_P4_CoinChange;

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
}
