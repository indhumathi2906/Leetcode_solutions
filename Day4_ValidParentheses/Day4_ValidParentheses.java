import java.util.*;

/**
 * Day 4: 20. Valid Parentheses (LeetCode #20)
 */
public class Day4_ValidParentheses {
    public boolean isValid(String s) {
        if (s == null || s.length() % 2 != 0) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        return stack.isEmpty();
    }
}
