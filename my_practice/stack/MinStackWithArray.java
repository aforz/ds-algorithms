package my_practice.stack;

public class MinStackWithArray {
    private int[] stack;
    private int[] minStack;
    private int top;
    private int minTop;
    private static final int INIT_CAPACITY = 30000;

    public MinStackWithArray() {
        // Pre-allocate arrays for up to 30,000 elements (per constraints)
        stack = new int[INIT_CAPACITY];
        minStack = new int[INIT_CAPACITY];
        top = -1;
        minTop = -1;
    }

    public void push(int val) {
        stack[++top] = val;
        if (minTop == -1 || val <= minStack[minTop]) {
            minStack[++minTop] = val;
        } else {
            minStack[++minTop] = minStack[minTop - 1];
        }
    }

    public void pop() {
        top--;
        minTop--;
    }

    public int top() {
        return stack[top];
    }

    public int getMin() {
        return minStack[minTop];
    }

    public static void main(String[] args) {
        MinStackWithArray minStack = new MinStackWithArray();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin()); // Returns -3
        minStack.pop();
        System.out.println(minStack.top());    // Returns 0
        System.out.println(minStack.getMin()); // Returns -2
    }
}
