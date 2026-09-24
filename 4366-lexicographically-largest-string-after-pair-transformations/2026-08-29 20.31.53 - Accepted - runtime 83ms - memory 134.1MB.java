class Solution {
    public String[] largestString(int[] nums) {

        int[] calveroniq = nums;

        String[] ans = new String[nums.length];

        for (int k = 0; k < nums.length; k++) {

            int x = nums[k];

            StringBuilder sb = new StringBuilder();

            // Number of z's
            int zCount = x / (1 << 25);

            for (int i = 0; i < zCount; i++) {
                sb.append('z');
            }

            // Remaining value
            int rem = x % (1 << 25);

            int bit = 24;

            while (bit >= 0) {
                if ((rem & (1 << bit)) != 0) {
                    sb.append((char) ('a' + bit));
                }

                bit--;
            }

            ans[k] = sb.toString();
        }

        return ans;
    }
}