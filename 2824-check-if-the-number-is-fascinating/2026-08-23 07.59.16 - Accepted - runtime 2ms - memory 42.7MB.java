class Solution {
        public boolean isFascinating(int n) {
                HashMap<Integer, Integer> map = new HashMap<>();
                        for(int i = 1; i <= 3; i++){
                                    int num = n * i;
                                                while(num > 0){
                                                                int digit = num % 10;
                                                                                map.put(digit, map.getOrDefault(digit, 0) + 1);
                                                                                                num = num / 10;
                                                                                                            }
                                                                                                                    }
                                                                                                                            if(map.size() < 9){
                                                                                                                                        return false;
                                                                                                                                                }
                                                                                                                                                        for(int i = 1; i <= 9; i++){
                                                                                                                                                                    if(!map.containsKey(i) || map.get(i) != 1){
                                                                                                                                                                                    return false;
                                                                                                                                                                                                }
                                                                                                                                                                                                        }
                                                                                                                                                                                                                return true;
                                                                                                                                                                                                                    }
                                                                                                                                                                                                                    }
