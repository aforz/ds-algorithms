package my_practice.stack;

import java.util.Stack;

//Problem: https://platform.bosscoderacademy.com/course/1YtfAvmdVrhPWJ9ylcc5/assignment/coding?problemId=expression_reduntant_bracket
class RedundantParenthesis {
    public boolean hasRedundantParentheses(String str) {
        char[] s = str.toCharArray();
        Stack<Character> stack = new Stack<>();

        for (char ch : s) {
            if (ch == ')') {
                boolean operatorFound = false;
                while (!stack.isEmpty() && stack.peek() != '(') {
                    char top = stack.pop();
                    if (top == '+' || top == '-' || top == '*' || top == '/') {
                        operatorFound = true;
                    }
                }
                // Pop the opening bracket
                if (!stack.isEmpty()) stack.pop();
                // If no operator found, it's redundant!
                if (!operatorFound) return true;
            } else {
                stack.push(ch);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        RedundantParenthesis solver = new RedundantParenthesis();
//        String expr1 = "(a + (b))";
//        System.out.println("Expression: " + expr1 + " has redundant parentheses? " + solver.hasRedundantParentheses(expr1)); // true

        String expr2 = "((a + b))";
        System.out.println("Expression: " + expr2 + " has redundant parentheses? " + solver.hasRedundantParentheses(expr2)); // false

//        String expr3 = "((a + b) * (c - d))";
//        System.out.println("Expression: " + expr3 + " has redundant parentheses? " + solver.hasRedundantParentheses(expr3)); // false
//
//        String expr4 = "(a)";
//        System.out.println("Expression: " + expr4 + " has redundant parentheses? " + solver.hasRedundantParentheses(expr4)); // true
    }
}
