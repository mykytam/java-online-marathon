package softserve.sprint09;

// Given a text containing brackets  '(', ')', '{', '}', '[' and ']'.
// Sequences "\\(", "\\)", "\\[", "\\]", "\\{" and "\\}" are not brackets.
// Write a boolean verifyBrackets(String text) method to check a input text.
// The brackets must close in the correct order, for example "()", "()[]{}", "{(())}" and "(\\()" are all valid but "(]", ")(" and "([)]" are not.

import java.util.Stack;

public class Sprint09Task02 {
    public boolean verifyBrackets(String text) {
        if (text.length() % 2 != 0) return false;

        Stack<Character> stack = new Stack<>();

        for (char c : text.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (c == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            } else if (c == '}' && !stack.isEmpty() && stack.peek() == '{') {
                stack.pop();
            } else if (c == ']' && !stack.isEmpty() && stack.peek() == '[') {
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
