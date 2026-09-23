import java.util.*;

/**
 * Day 1: 1. Two Sum (LeetCode #1)
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 *
 * Time Complexity: O(N) where N is array length.
 * Space Complexity: O(N) for HashMap storage.
 */
public class Day1_TwoSum {
    public int[] twoSum(int[] nums, int target) {
        // Validate input array
        if (nums == null || nums.length < 2) {
            return new int[0];
        }
        // Map value -> index
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }
}
