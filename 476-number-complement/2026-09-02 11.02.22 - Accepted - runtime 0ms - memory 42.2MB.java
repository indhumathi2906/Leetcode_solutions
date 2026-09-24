class Solution {

    public int findComplement(int num) {

        int ans = 0;
        int power = 1;

        while (num > 0) {

            int bit = num % 2;

            if (bit == 0) {
                ans += power;
            }

            num = num / 2;

            power = power * 2;
        }

        return ans;
    }
}