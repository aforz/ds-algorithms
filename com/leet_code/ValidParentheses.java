package com.leet_code;

import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            // For opening brackets, push to stack
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }
            // For closing brackets, check for match
            else {
                if (stack.isEmpty()) return false;
                char top = stack.pop();
                if (c == ')' && top != '(') return false;
                if (c == '}' && top != '{') return false;
                if (c == ']' && top != '[') return false;
            }
        }
        // Stack should be empty if all brackets matched
        return stack.isEmpty();
    }

    // Example usage
    public static void main(String[] args) {
        ValidParentheses validator = new ValidParentheses();
        System.out.println(validator.isValid("()"));       // true
        System.out.println(validator.isValid("()[]{}"));   // true
        System.out.println(validator.isValid("(]"));       // false
        System.out.println(validator.isValid("([])"));     // true
        System.out.println(validator.isValid("([)]"));     // false
    }
}
