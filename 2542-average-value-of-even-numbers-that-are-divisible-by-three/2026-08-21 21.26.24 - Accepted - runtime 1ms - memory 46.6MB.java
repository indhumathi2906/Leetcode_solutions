class Solution {
        public int averageValue(int[] nums) {
                
                        int sum = 0;
                                int amount = 0;
                                        for (int c : nums) {
                                                    if (c % 2 == 0 && c % 3 == 0) {
                                                                    sum += c;
                                                                                    amount++;
                                                                                                }
                                                                                                        }
                                                                                                                if (amount == 0) return 0;
                                                                                                                        return sum / amount;
                                                                                                                            }
                                                                                                                            }
