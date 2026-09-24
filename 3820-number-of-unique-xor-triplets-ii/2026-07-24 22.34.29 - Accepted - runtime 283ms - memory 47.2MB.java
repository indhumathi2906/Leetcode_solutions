class Solution {
        public int uniqueXorTriplets(int[] nums) {
                int max = 0;
                        for (int x : nums) {
                                    max = Math.max(max, x);
                                            }

                                                    
                                                            int limit = max << 1;
                                                                            boolean[] pairXor = new boolean[limit];
                                                                                    for (int a : nums) {
                                                                                                for (int b : nums) {
                                                                                                                pairXor[a ^ b] = true;
                                                                                                                            }
                                                                                                                                    }

                                                                                                                        
                                                                                                                                                    boolean[] tripletXor = new boolean[limit];
                                                                                                                                                            for (int x = 0; x < limit; x++) {
                                                                                                                                                                        if (!pairXor[x]) continue;
                                                                                                                                                                                    for (int c : nums) {
                                                                                                                                                                                                    tripletXor[x ^ c] = true;
                                                                                                                                                                                                                }
                                                                                                                                                                                                                        }

                                                                                                                                                                                                                                int ans = 0;
                                                                                                                                                                                                                                        for (boolean exists : tripletXor) {
                                                                                                                                                                                                                                                    if (exists) ans++;
                                                                                                                                                                                                                                                            }

                                                                                                                                                                                                                                                                    return ans;
                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                        }
