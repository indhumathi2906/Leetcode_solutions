import java.util.*;

/**
 * 20. Valid Parentheses
 *
 * Time Complexity: O(N) where N is the length of string s.
 * Space Complexity: O(N) in worst-case for stack memory.
 */
class Solution {
    public boolean isValid(String s) {
        // Quick fail if null or odd length
        if (s == null || s.length() % 2 != 0) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') stack.push(')');
            else if (c == '{') stack.push('}');
            else if (c == '[') stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c) return false;
        }
        return stack.isEmpty();
    }
}
