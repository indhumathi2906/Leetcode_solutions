# 🧠 Dynamic Programming on Arrays — 7 Problem Master Collection

A comprehensive collection of 7 classic **Dynamic Programming (DP) on Arrays** problems solved in **Java**. Each problem contains multiple approaches:
1. **Top-Down Recursion + Memoization**
2. **Bottom-Up Tabulation**
3. **Space-Optimized DP / Advanced Binary Search**

---

## 📊 Summary Table

| # | Problem Name | LeetCode Link | Solution Folder | Time Complexity | Space Complexity |
|---|---|---|---|---|---|
| **P1** | [70. Climbing Stairs](https://leetcode.com/problems/climbing-stairs/) | [`DP_Array_P1_ClimbingStairs`](./DP_Array_P1_ClimbingStairs) | $O(N)$ | $O(1)$ |
| **P2** | [198. House Robber](https://leetcode.com/problems/house-robber/) | [`DP_Array_P2_HouseRobber`](./DP_Array_P2_HouseRobber) | $O(N)$ | $O(1)$ |
| **P3** | [152. Maximum Product Subarray](https://leetcode.com/problems/maximum-product-subarray/) | [`DP_Array_P3_MaximumProductSubarray`](./DP_Array_P3_MaximumProductSubarray) | $O(N)$ | $O(1)$ |
| **P4** | [322. Coin Change](https://leetcode.com/problems/coin-change/) | [`DP_Array_P4_CoinChange`](./DP_Array_P4_CoinChange) | $O(N \cdot \text{Amount})$ | $O(\text{Amount})$ |
| **P5** | [300. Longest Increasing Subsequence](https://leetcode.com/problems/longest-increasing-subsequence/) | [`DP_Array_P5_LongestIncreasingSubsequence`](./DP_Array_P5_LongestIncreasingSubsequence) | $O(N \log N)$ | $O(N)$ |
| **P6** | [416. Partition Equal Subset Sum](https://leetcode.com/problems/partition-equal-subset-sum/) | [`DP_Array_P6_PartitionEqualSubsetSum`](./DP_Array_P6_PartitionEqualSubsetSum) | $O(N \cdot \text{Target})$ | $O(\text{Target})$ |
| **P7** | [91. Decode Ways](https://leetcode.com/problems/decode-ways/) | [`DP_Array_P7_DecodeWays`](./DP_Array_P7_DecodeWays) | $O(N)$ | $O(1)$ |

---

## 🛠 Combined Master Java Source File

All solutions are aggregated into a single runnable Java master suite:
👉 [`DP_On_Arrays_Solutions.java`](./DP_On_Arrays_Solutions.java)

---

## 📝 Problems Breakdown

### Problem 1: 70. Climbing Stairs
- **Concept:** 1D State Transition (Fibonacci Pattern)
- **Recurrence:** $f(n) = f(n-1) + f(n-2)$
- **Key Insight:** To reach step $n$, you must step from either $n-1$ or $n-2$.

### Problem 2: 198. House Robber
- **Concept:** Non-Adjacent Array Selection
- **Recurrence:** $dp[i] = \max(dp[i-1], \text{nums}[i] + dp[i-2])$
- **Key Insight:** Decide at each house whether to pick it (and add loot from $i-2$) or skip it (taking max loot up to $i-1$).

### Problem 3: 152. Maximum Product Subarray
- **Concept:** Contiguous Subarray DP with Dual Product Tracking
- **Key Insight:** Multiplying by a negative number swaps maximum and minimum products. Maintain both `maxSoFar` and `minSoFar` at each step.

### Problem 4: 322. Coin Change
- **Concept:** Unbounded Knapsack
- **Recurrence:** $dp[i] = \min_{c \in \text{coins}}(dp[i - c] + 1)$
- **Key Insight:** Initialize DP table with $\infty$ (or $\text{amount}+1$). Target 0 requires 0 coins.

### Problem 5: 300. Longest Increasing Subsequence (LIS)
- **Concept:** Subsequence Array DP & Patience Sorting
- **Key Approaches:**
  - $O(N^2)$ Tabulation DP
  - $O(N \log N)$ Binary Search using `tails` array (Patience Sorting)

### Problem 6: 416. Partition Equal Subset Sum
- **Concept:** 0/1 Knapsack / Subset Sum
- **Key Insight:** Total sum must be even. Target sum is $\text{totalSum} / 2$. Traversal in reverse order for 1D DP array prevents reusing the same item.

### Problem 7: 91. Decode Ways
- **Concept:** String Index Decoding State Machine
- **Recurrence:** $dp[i] = (s[i-1] \text{ valid 1-digit} ? dp[i-1] : 0) + (s[i-2..i-1] \text{ valid 2-digit} ? dp[i-2] : 0)$
- **Key Insight:** Leading zero invalidates single digit decodings. 2-digit decoding is valid only between 10 and 26.
