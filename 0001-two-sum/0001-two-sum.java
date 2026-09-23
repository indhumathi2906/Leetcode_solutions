import java.util.*;

/**
 * 1. Two Sum
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 *
 * Time Complexity: O(N) where N is the number of elements in the array.
 * Space Complexity: O(N) for storing elements in the HashMap.
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Validate input array
        if (nums == null || nums.length < 2) {
            return new int[0];
        }
        // Map value -> index
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            // If complement exists in map, return indices
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }
}
