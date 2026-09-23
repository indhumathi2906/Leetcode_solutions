import java.util.*;

/**
 * Day 4: 20. Valid Parentheses (LeetCode #20)
 *
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 */
public class Day4_ValidParentheses {
    public boolean isValid(String s) {
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
