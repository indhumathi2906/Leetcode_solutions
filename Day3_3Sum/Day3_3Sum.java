import java.util.*;

/**
 * Day 3: 15. 3Sum (LeetCode #15)
 */
public class Day3_3Sum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return result;
        }
        Arrays.sort(nums);
        return result;
    }
}
