import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * ============================================================================
 *               DYNAMIC PROGRAMMING ON ARRAYS - 7 PROBLEM MASTER COLLECTION
 * ============================================================================
 * A complete collection of 7 Dynamic Programming on Arrays problems solved
 * in Java with Top-Down (Memoization), Bottom-Up (Tabulation), and Space-Optimized
 * approaches.
 *
 * Problems Included:
 * 1. Climbing Stairs (LeetCode #70)
 * 2. House Robber (LeetCode #198)
 * 3. Maximum Product Subarray (LeetCode #152)
 * 4. Coin Change (LeetCode #322)
 * 5. Longest Increasing Subsequence (LeetCode #300)
 * 6. Partition Equal Subset Sum (LeetCode #416)
 * 7. Decode Ways (LeetCode #91)
 * ============================================================================
 */
public class DP_On_Arrays_Solutions {

    // ============================================================================
    // PROBLEM 1: Climbing Stairs (LeetCode #70)
    // ============================================================================
    public static class Problem1_ClimbingStairs {
        // Approach 1: Top-Down DP (Memoization)
        public int climbStairsMemo(int n) {
            if (n <= 0) return 0;
            int[] memo = new int[n + 1];
            return memoHelper(n, memo);
        }

        private int memoHelper(int n, int[] memo) {
            if (n <= 2) return n;
            if (memo[n] != 0) return memo[n];
            return memo[n] = memoHelper(n - 1, memo) + memoHelper(n - 2, memo);
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

        // Approach 3: Space-Optimized DP (O(1) Space)
        public int climbStairsSpaceOptimized(int n) {
            if (n <= 2) return n;
            int prev2 = 1, prev1 = 2;
            for (int i = 3; i <= n; i++) {
                int curr = prev1 + prev2;
                prev2 = prev1;
                prev1 = curr;
            }
            return prev1;
        }
    }

    // ============================================================================
    // PROBLEM 2: House Robber (LeetCode #198)
    // ============================================================================
    public static class Problem2_HouseRobber {
        // Approach 1: Top-Down DP (Memoization)
        public int robMemo(int[] nums) {
            if (nums == null || nums.length == 0) return 0;
            int[] memo = new int[nums.length];
            Arrays.fill(memo, -1);
            return memoHelper(nums, nums.length - 1, memo);
        }

        private int memoHelper(int[] nums, int i, int[] memo) {
            if (i < 0) return 0;
            if (memo[i] != -1) return memo[i];
            int pick = nums[i] + memoHelper(nums, i - 2, memo);
            int skip = memoHelper(nums, i - 1, memo);
            return memo[i] = Math.max(pick, skip);
        }

        // Approach 2: Bottom-Up DP (Tabulation)
        public int robTabulation(int[] nums) {
            if (nums == null || nums.length == 0) return 0;
            if (nums.length == 1) return nums[0];
            int[] dp = new int[nums.length];
            dp[0] = nums[0];
            dp[1] = Math.max(nums[0], nums[1]);
            for (int i = 2; i < nums.length; i++) {
                dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
            }
            return dp[nums.length - 1];
        }

        // Approach 3: Space-Optimized DP (O(1) Space)
        public int robSpaceOptimized(int[] nums) {
            if (nums == null || nums.length == 0) return 0;
            if (nums.length == 1) return nums[0];
            int prev2 = nums[0];
            int prev1 = Math.max(nums[0], nums[1]);
            for (int i = 2; i < nums.length; i++) {
                int curr = Math.max(prev1, nums[i] + prev2);
                prev2 = prev1;
                prev1 = curr;
            }
            return prev1;
        }
    }

    // ============================================================================
    // PROBLEM 3: Maximum Product Subarray (LeetCode #152)
    // ============================================================================
    public static class Problem3_MaxProductSubarray {
        // Approach 1: Brute Force Baseline
        public int maxProductBruteForce(int[] nums) {
            if (nums == null || nums.length == 0) return 0;
            int maxProd = nums[0];
            for (int i = 0; i < nums.length; i++) {
                int currentProd = 1;
                for (int j = i; j < nums.length; j++) {
                    currentProd *= nums[j];
                    maxProd = Math.max(maxProd, currentProd);
                }
            }
            return maxProd;
        }

        // Approach 2: Dual DP Tables (Tabulation)
        public int maxProductTabulation(int[] nums) {
            if (nums == null || nums.length == 0) return 0;
            int n = nums.length;
            int[] maxDP = new int[n];
            int[] minDP = new int[n];
            maxDP[0] = minDP[0] = nums[0];
            int globalMax = nums[0];
            for (int i = 1; i < n; i++) {
                if (nums[i] < 0) {
                    maxDP[i] = Math.max(nums[i], minDP[i - 1] * nums[i]);
                    minDP[i] = Math.min(nums[i], maxDP[i - 1] * nums[i]);
                } else {
                    maxDP[i] = Math.max(nums[i], maxDP[i - 1] * nums[i]);
                    minDP[i] = Math.min(nums[i], minDP[i - 1] * nums[i]);
                }
                globalMax = Math.max(globalMax, maxDP[i]);
            }
            return globalMax;
        }

        // Approach 3: Space-Optimized DP (O(1) Space)
        public int maxProductSpaceOptimized(int[] nums) {
            if (nums == null || nums.length == 0) return 0;
            int maxSoFar = nums[0], minSoFar = nums[0], result = nums[0];
            for (int i = 1; i < nums.length; i++) {
                int curr = nums[i];
                if (curr < 0) {
                    int temp = maxSoFar;
                    maxSoFar = minSoFar;
                    minSoFar = temp;
                }
                maxSoFar = Math.max(curr, maxSoFar * curr);
                minSoFar = Math.min(curr, minSoFar * curr);
                result = Math.max(result, maxSoFar);
            }
            return result;
        }
    }

    // ============================================================================
    // PROBLEM 4: Coin Change (LeetCode #322)
    // ============================================================================
    public static class Problem4_CoinChange {
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
                if (res >= 0 && res < minCoins) minCoins = 1 + res;
            }
            return memo[rem] = (minCoins == Integer.MAX_VALUE) ? -1 : minCoins;
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
                    if (coin <= i) dp[i] = Math.min(dp[i], dp[i - coin] + 1);
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
    }

    // ============================================================================
    // PROBLEM 5: Longest Increasing Subsequence (LeetCode #300)
    // ============================================================================
    public static class Problem5_LongestIncreasingSubsequence {
        // Approach 1: Top-Down DP (Memoization)
        public int lengthOfLISMemo(int[] nums) {
            if (nums == null || nums.length == 0) return 0;
            int[][] memo = new int[nums.length][nums.length + 1];
            for (int[] row : memo) Arrays.fill(row, -1);
            return memoHelper(nums, -1, 0, memo);
        }

        private int memoHelper(int[] nums, int prevIdx, int currIdx, int[][] memo) {
            if (currIdx == nums.length) return 0;
            if (memo[currIdx][prevIdx + 1] != -1) return memo[currIdx][prevIdx + 1];

            int take = 0;
            if (prevIdx == -1 || nums[currIdx] > nums[prevIdx]) {
                take = 1 + memoHelper(nums, currIdx, currIdx + 1, memo);
            }
            int skip = memoHelper(nums, prevIdx, currIdx + 1, memo);

            return memo[currIdx][prevIdx + 1] = Math.max(take, skip);
        }

        // Approach 2: Bottom-Up DP (Tabulation O(N^2))
        public int lengthOfLISTabulation(int[] nums) {
            if (nums == null || nums.length == 0) return 0;
            int n = nums.length;
            int[] dp = new int[n];
            Arrays.fill(dp, 1);
            int maxLIS = 1;
            for (int i = 1; i < n; i++) {
                for (int j = 0; j < i; j++) {
                    if (nums[i] > nums[j]) dp[i] = Math.max(dp[i], dp[j] + 1);
                }
                maxLIS = Math.max(maxLIS, dp[i]);
            }
            return maxLIS;
        }

        // Approach 3: Binary Search Patience Sorting O(N log N)
        public int lengthOfLISBinarySearch(int[] nums) {
            if (nums == null || nums.length == 0) return 0;
            int[] tails = new int[nums.length];
            int size = 0;
            for (int x : nums) {
                int i = 0, j = size;
                while (i < j) {
                    int mid = (i + j) / 2;
                    if (tails[mid] < x) i = mid + 1; else j = mid;
                }
                tails[i] = x;
                if (i == size) size++;
            }
            return size;
        }
    }

    // ============================================================================
    // PROBLEM 6: Partition Equal Subset Sum (LeetCode #416)
    // ============================================================================
    public static class Problem6_PartitionEqualSubsetSum {
        // Approach 1: Top-Down DP (Memoization)
        public boolean canPartitionMemo(int[] nums) {
            if (nums == null || nums.length == 0) return false;
            int totalSum = 0;
            for (int num : nums) totalSum += num;
            if (totalSum % 2 != 0) return false;

            int target = totalSum / 2;
            Boolean[][] memo = new Boolean[nums.length][target + 1];
            return memoHelper(nums, 0, target, memo);
        }

        private boolean memoHelper(int[] nums, int index, int target, Boolean[][] memo) {
            if (target == 0) return true;
            if (index >= nums.length || target < 0) return false;
            if (memo[index][target] != null) return memo[index][target];

            boolean include = memoHelper(nums, index + 1, target - nums[index], memo);
            boolean exclude = memoHelper(nums, index + 1, target, memo);

            return memo[index][target] = (include || exclude);
        }

        // Approach 2: Bottom-Up 2D Tabulation
        public boolean canPartitionTabulation(int[] nums) {
            if (nums == null || nums.length == 0) return false;
            int sum = 0;
            for (int num : nums) sum += num;
            if (sum % 2 != 0) return false;
            int target = sum / 2, n = nums.length;
            boolean[][] dp = new boolean[n + 1][target + 1];
            for (int i = 0; i <= n; i++) dp[i][0] = true;
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= target; j++) {
                    if (nums[i - 1] <= j) dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                    else dp[i][j] = dp[i - 1][j];
                }
            }
            return dp[n][target];
        }

        // Approach 3: 1D Space-Optimized DP
        public boolean canPartitionSpaceOptimized(int[] nums) {
            if (nums == null || nums.length == 0) return false;
            int sum = 0;
            for (int num : nums) sum += num;
            if (sum % 2 != 0) return false;
            int target = sum / 2;
            boolean[] dp = new boolean[target + 1];
            dp[0] = true;
            for (int num : nums) {
                for (int j = target; j >= num; j--) dp[j] = dp[j] || dp[j - num];
            }
            return dp[target];
        }
    }

    // ============================================================================
    // PROBLEM 7: Decode Ways (LeetCode #91)
    // ============================================================================
    public static class Problem7_DecodeWays {
        // Approach 1: Top-Down DP (Memoization)
        public int numDecodingsMemo(String s) {
            if (s == null || s.length() == 0) return 0;
            int[] memo = new int[s.length()];
            Arrays.fill(memo, -1);
            return memoHelper(s, 0, memo);
        }

        private int memoHelper(String s, int index, int[] memo) {
            if (index == s.length()) return 1;
            if (s.charAt(index) == '0') return 0;
            if (memo[index] != -1) return memo[index];

            int ways = memoHelper(s, index + 1, memo);

            if (index + 1 < s.length()) {
                int twoDigit = Integer.parseInt(s.substring(index, index + 2));
                if (twoDigit >= 10 && twoDigit <= 26) {
                    ways += memoHelper(s, index + 2, memo);
                }
            }
            return memo[index] = ways;
        }

        // Approach 2: Bottom-Up 1D Tabulation
        public int numDecodingsTabulation(String s) {
            if (s == null || s.length() == 0 || s.charAt(0) == '0') return 0;
            int n = s.length();
            int[] dp = new int[n + 1];
            dp[0] = 1; dp[1] = 1;
            for (int i = 2; i <= n; i++) {
                int oneDigit = Integer.parseInt(s.substring(i - 1, i));
                int twoDigit = Integer.parseInt(s.substring(i - 2, i));
                if (oneDigit >= 1 && oneDigit <= 9) dp[i] += dp[i - 1];
                if (twoDigit >= 10 && twoDigit <= 26) dp[i] += dp[i - 2];
            }
            return dp[n];
        }

        // Approach 3: Space-Optimized DP (O(1) Space)
        public int numDecodingsSpaceOptimized(String s) {
            if (s == null || s.length() == 0 || s.charAt(0) == '0') return 0;
            int n = s.length(), prev2 = 1, prev1 = 1;
            for (int i = 2; i <= n; i++) {
                int current = 0;
                int oneDigit = Integer.parseInt(s.substring(i - 1, i));
                int twoDigit = Integer.parseInt(s.substring(i - 2, i));
                if (oneDigit >= 1 && oneDigit <= 9) current += prev1;
                if (twoDigit >= 10 && twoDigit <= 26) current += prev2;
                prev2 = prev1; prev1 = current;
            }
            return prev1;
        }
    }

    // ============================================================================
    // MASTER MAIN EXECUTION TEST RUNNER
    // ============================================================================
    public static void main(String[] args) {
        System.out.println("=================================================");
        System.out.println("   DYNAMIC PROGRAMMING ON ARRAYS MASTER SUITE   ");
        System.out.println("=================================================\n");

        // Problem 1 Test
        Problem1_ClimbingStairs p1 = new Problem1_ClimbingStairs();
        System.out.println("P1: Climbing Stairs (n=5): " + p1.climbStairsSpaceOptimized(5) + " ways");

        // Problem 2 Test
        Problem2_HouseRobber p2 = new Problem2_HouseRobber();
        int[] houses = {2, 7, 9, 3, 1};
        System.out.println("P2: House Robber " + Arrays.toString(houses) + ": $" + p2.robSpaceOptimized(houses));

        // Problem 3 Test
        Problem3_MaxProductSubarray p3 = new Problem3_MaxProductSubarray();
        int[] prodNums = {2, 3, -2, 4};
        System.out.println("P3: Max Product Subarray " + Arrays.toString(prodNums) + ": " + p3.maxProductSpaceOptimized(prodNums));

        // Problem 4 Test
        Problem4_CoinChange p4 = new Problem4_CoinChange();
        int[] coins = {1, 2, 5};
        System.out.println("P4: Coin Change " + Arrays.toString(coins) + " target 11: " + p4.coinChangeTabulation(coins, 11) + " coins");

        // Problem 5 Test
        Problem5_LongestIncreasingSubsequence p5 = new Problem5_LongestIncreasingSubsequence();
        int[] lisNums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println("P5: LIS " + Arrays.toString(lisNums) + ": length " + p5.lengthOfLISBinarySearch(lisNums));

        // Problem 6 Test
        Problem6_PartitionEqualSubsetSum p6 = new Problem6_PartitionEqualSubsetSum();
        int[] partitionNums = {1, 5, 11, 5};
        System.out.println("P6: Partition Subset Sum " + Arrays.toString(partitionNums) + ": " + p6.canPartitionSpaceOptimized(partitionNums));

        // Problem 7 Test
        Problem7_DecodeWays p7 = new Problem7_DecodeWays();
        String code = "226";
        System.out.println("P7: Decode Ways \"" + code + "\": " + p7.numDecodingsSpaceOptimized(code) + " ways");

        System.out.println("\n=================================================");
        System.out.println("   ALL 7 DP PROBLEMS EXECUTED SUCCESSFULLY!      ");
        System.out.println("=================================================");
    }
}
