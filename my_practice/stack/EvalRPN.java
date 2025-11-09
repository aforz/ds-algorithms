package my_practice.stack;

class EvalRPN {
    public int evalRPN(String[] tokens) {
        int[] stack = new int[tokens.length];
        int top = -1;
        for (String token : tokens) {
            if (isOperator(token)) {
                int b = stack[top--];
                int a = stack[top--];
                stack[++top] = apply(a, b, token);
            } else {
                stack[++top] = Integer.parseInt(token);
            }
        }
        return stack[top];
    }

    private boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") ||
                token.equals("*") || token.equals("/");
    }

    private int apply(int a, int b, String op) {
        switch (op) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                return a / b; // Java division truncates toward zero
            default:
                throw new IllegalArgumentException("Unknown operator: " + op);
        }
    }

    public static void main(String[] args) {
        EvalRPN evaluator = new EvalRPN();
//        String[] tokens = {"2", "1", "+", "3", "*"};
//        int result = evaluator.evalRPN(tokens);
//        System.out.println("Result: " + result); // Output: Result: 9

        String[] tokens2 = {"4", "13", "5", "/", "+"};
        int result2 = evaluator.evalRPN(tokens2);
        System.out.println("Result: " + result2); // Output: Result: 6
    }
}
