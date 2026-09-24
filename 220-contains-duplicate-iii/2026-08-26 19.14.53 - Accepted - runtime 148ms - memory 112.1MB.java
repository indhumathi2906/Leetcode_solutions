class Solution {
        public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {

                TreeSet<Long> map = new TreeSet<>();
                        
                                for(int i=0; i<nums.length; i++){
                                            long current = nums[i];

                                                        // To find smallest value >= current - valueDifff
                                                                    Long value = map.ceiling(current - (long) valueDiff);
                                                                                
                                                                                            // If value is also <= current + valueDiff, then a valid value exists
                                                                                                        if (value != null && value <= current + (long) valueDiff) {
                                                                                                                        return true;
                                                                                                                                    }

                                                                                                                                                // Add current value to the sliding window
                                                                                                                                                            map.add(current);

                                                                                                                                                                        if (i >= indexDiff) {
                                                                                                                                                                                        map.remove((long) nums[i - indexDiff]);
                                                                                                                                                                                                    }   
                                                                                                                                                                                                            }

                                                                                                                                                                                                                    return false;
                                                                                                                                                                                                                        }
                                                                                                                                                                                                                        
}