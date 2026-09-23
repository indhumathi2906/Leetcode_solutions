import java.util.Stack;

/**
 * Problem: 20. Valid Parentheses
 * Link: https://leetcode.com/problems/valid-parentheses/
 *
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 */
class Solution {
    public boolean isValid(String s) {
        if (s == null || s.length() % 2 != 0) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
