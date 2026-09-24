class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int len = 1001;

        int[] count = new int[len];

        for (int num : arr1) {
            count[num]++;
        }

        int idx = 0;

        for (int num : arr2) {

            while (count[num] > 0) {
                arr1[idx++] = num;
                count[num]--;
            }
        }

        for (int i = 0; i < len; i++) {
            if (count[i] == 0) {
                continue;
            }

             while (count[i] > 0) {
                arr1[idx++] = i;
                count[i]--;
            }
        }

        return arr1;
    }
}