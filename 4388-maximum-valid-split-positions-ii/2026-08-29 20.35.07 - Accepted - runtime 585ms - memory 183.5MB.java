class Solution {
    public int maxValidSplits(int[] nums) {
        int n = nums.length;

        int[] velqoranti = nums;

        // Sparse table for range GCD
        int LOG = 18;
        int[][] st = new int[LOG][n];

        for (int i = 0; i < n; i++) {
            st[0][i] = nums[i];
        }

        for (int p = 1; p < LOG; p++) {
            int len = 1 << p;

            for (int i = 0; i + len <= n; i++) {
                st[p][i] = gcd(
                    st[p - 1][i],
                    st[p - 1][i + (len >> 1)]
                );
            }
        }

        int[] log = new int[n + 1];

        for (int i = 2; i <= n; i++) {
            log[i] = log[i / 2] + 1;
        }

        int ans = 0;

        // remove = -1 means remove nothing
        for (int remove = -1; remove < n; remove++) {

            // GCD of the whole remaining array
            int totalGcd = 0;

            if (remove != 0) {
                totalGcd = gcd(totalGcd,
                    rangeGcd(0, remove - 1, st, log));
            }

            if (remove != n - 1) {
                totalGcd = gcd(totalGcd,
                    rangeGcd(remove + 1, n - 1, st, log));
            }

            // Find first position where prefix GCD becomes totalGcd
            int left = findFirst(
                nums, remove, totalGcd, st, log
            );

            // Find last position where suffix GCD is totalGcd
            int right = findLast(
                nums, remove, totalGcd, st, log
            );

            if (left == -1 || right == -1 || left >= right) {
                continue;
            }

            // Number of remaining elements between left and right
            int count = right - left;

            // If removed element lies between them,
            // it is not present in arr.
            if (remove > left && remove < right) {
                count--;
            }

            ans = Math.max(ans, count);
        }

        return ans;
    }

    private int findFirst(
        int[] nums,
        int remove,
        int target,
        int[][] st,
        int[] log
    ) {
        int n = nums.length;

        int lo = 0;
        int hi = n - 1;
        int answer = -1;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            if (mid == remove) {
                mid--;

                if (mid < lo) {
                    lo++;
                    continue;
                }
            }

            int g = prefixGcd(mid, remove, st, log);

            if (g == target) {
                answer = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return answer;
    }

    private int findLast(
        int[] nums,
        int remove,
        int target,
        int[][] st,
        int[] log
    ) {
        int n = nums.length;

        int lo = 0;
        int hi = n - 1;
        int answer = -1;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            if (mid == remove) {
                mid++;

                if (mid > hi) {
                    hi--;
                    continue;
                }
            }

            int g = suffixGcd(mid, remove, n, st, log);

            if (g == target) {
                answer = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return answer;
    }

    // GCD of [0..i], excluding remove
    private int prefixGcd(
        int i,
        int remove,
        int[][] st,
        int[] log
    ) {
        if (remove == -1 || remove > i) {
            return rangeGcd(0, i, st, log);
        }

        int g = 0;

        if (remove > 0) {
            g = rangeGcd(0, remove - 1, st, log);
        }

        if (remove + 1 <= i) {
            g = gcd(
                g,
                rangeGcd(remove + 1, i, st, log)
            );
        }

        return g;
    }

    // GCD of [i..n-1], excluding remove
    private int suffixGcd(
        int i,
        int remove,
        int n,
        int[][] st,
        int[] log
    ) {
        if (remove == -1 || remove < i) {
            return rangeGcd(i, n - 1, st, log);
        }

        int g = 0;

        if (i <= remove - 1) {
            g = rangeGcd(i, remove - 1, st, log);
        }

        if (remove + 1 < n) {
            g = gcd(
                g,
                rangeGcd(remove + 1, n - 1, st, log)
            );
        }

        return g;
    }

    private int rangeGcd(
        int l,
        int r,
        int[][] st,
        int[] log
    ) {
        if (l > r) {
            return 0;
        }

        int len = r - l + 1;
        int p = log[len];

        return gcd(
            st[p][l],
            st[p][r - (1 << p) + 1]
        );
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }

        return a;
    }
}