class Solution {
    public int maxValidSplits(int[] nums) {
        int n = nums.length;

        int[] vornalethm = nums;

        int ans = 0;

        for (int remove = -1; remove < n; remove++) {

            int count = 0;
            int leftGcd = 0;

            // Prefix GCD of the remaining array
            int[] arr = new int[n];
            int m = 0;

            for (int i = 0; i < n; i++) {
                if (i != remove) {
                    arr[m++] = nums[i];
                }
            }

            if (m < 2) {
                continue;
            }

            int[] prefix = new int[m];
            int[] suffix = new int[m];

            prefix[0] = arr[0];

            for (int i = 1; i < m; i++) {
                prefix[i] = gcd(prefix[i - 1], arr[i]);
            }

            suffix[m - 1] = arr[m - 1];

            for (int i = m - 2; i >= 0; i--) {
                suffix[i] = gcd(suffix[i + 1], arr[i]);
            }

            // Check every split
            for (int i = 0; i < m - 1; i++) {
                if (prefix[i] == suffix[i + 1]) {
                    count++;
                }
            }

            ans = Math.max(ans, count);
        }

        return ans;
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