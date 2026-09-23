import java.util.HashMap;
import java.util.Map;

/**
 * Day 1: 1. Two Sum (LeetCode #1)
 * Link: https://leetcode.com/problems/two-sum/
 *
 * Given an array of integers nums and an integer target, return indices of the 
 * two numbers such that they add up to target.
 *
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 */
public class Day1_TwoSum {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return new int[0];
        }
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
