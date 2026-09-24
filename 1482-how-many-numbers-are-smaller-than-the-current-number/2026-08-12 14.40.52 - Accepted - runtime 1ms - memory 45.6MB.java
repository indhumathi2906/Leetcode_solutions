class Solution {
        public int[] smallerNumbersThanCurrent(int[] nums) {
                // Frequency array for values in range [0, 100].
                        // allNums[v] will first store how many times value v appears in nums.
                                int[] allNums = new int[101];

                                        // Result array. res[i] = count of numbers strictly smaller than nums[i].
                                                int[] res = new int[nums.length];

                                                        // 1) Build frequency counts for each value in nums.
                                                                // After this loop: allNums[v] = number of occurrences of v in nums.
                                                                        for (int i = 0; i < nums.length; i++) {
                                                                                    allNums[nums[i]]++;
                                                                                            }

                                                                                                    // 2) Convert frequency array into a prefix sum array.
                                                                                                            // After this loop: allNums[v] = number of elements <= v.
                                                                                                                    for (int i = 1; i < 101; i++) {
                                                                                                                                allNums[i] += allNums[i - 1];
                                                                                                                                        }

                                                                                                                                                
                                                                                                                                                        // 3) Compute result
                                                                                                                                                                for (int i = 0; i < nums.length; i++) {
                                                                                                                                                                            if (nums[i] == 0) {
                                                                                                                                                                                            // If value is 0, no smaller numbers exist
                                                                                                                                                                                                            res[i] = 0;
                                                                                                                                                                                                                        } else {
                                                                                                                                                                                                                                        // Otherwise, count of numbers strictly less than nums[i]
                                                                                                                                                                                                                                                        res[i] = allNums[nums[i] - 1];
                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                    return res;
                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                        }
