class Solution {
    public boolean canThreePartsEqualSum(int[] arr) {
        int n = arr.length;
        int total = 0;
        int count = 0;
        int sum = 0;
        for (int num : arr) {
            total += num;
        }

        if (total % 3 != 0) return false;

        int target = total / 3;

        for (int i = 0; i < n; i++) {
            sum += arr[i];

            if (sum == target) {
                count++;
                sum = 0;
            }
        }

        return count >= 3;
    }
}