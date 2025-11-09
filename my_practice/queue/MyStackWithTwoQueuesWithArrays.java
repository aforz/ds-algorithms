package my_practice.queue;

/**
 * Simple stack implementation using two queues backed by fixed-size arrays.
 *
 * Approach:
 * - We represent each queue with an array and a size counter (queue1 and queue2).
 * - To make push O(n) and pop/top O(1): when pushing, we enqueue the new element
 *   into queue2, then enqueue all elements from queue1 after it. Then we swap
 *   the underlying arrays so queue1 always holds the stack order with the top
 *   at index 0.
 * - pop() removes and returns the element at the front of queue1 (index 0).
 * - top() returns the element at the front of queue1 without removing it.
 *
 * Notes:
 * - This class uses a fixed MAX_SIZE because the original problem constraints
 *   said at most 100 calls; MAX_SIZE is 110 for a small safety margin.
 * - For empty-stack operations this implementation returns -1. In production
 *   code you might throw an exception instead.
 */
public class MyStackWithTwoQueuesWithArrays {
    // Underlying arrays acting as queues. We always keep the "stack" in queue1
    // such that the current top is at queue1[0]. queue2 is used temporarily
    // during push to reorder elements.
    private int[] queue1;
    private int[] queue2;

    // Current sizes (number of elements) in each queue array
    private int size1;
    private int size2;

    // Fixed capacity for the arrays (slightly larger than constraints)
    private static final int MAX_SIZE = 110; // Per constraints; at most 100 calls

    public MyStackWithTwoQueuesWithArrays() {
        queue1 = new int[MAX_SIZE];
        queue2 = new int[MAX_SIZE];
        size1 = 0;
        size2 = 0;
    }

    /**
     * Pushes element x onto the stack.
     *
     * Steps:
     * 1. Enqueue x into queue2.
     * 2. Append all current elements of queue1 into queue2 (so x becomes the
     *    front when we swap).
     * 3. Swap queue1 and queue2 references and reset size2. Update size1.
     */
    public void push(int x) {
        // enqueue x into queue2
        queue2[size2++] = x;
        // move all elements from queue1 to queue2 to maintain stack order
        for (int i = 0; i < size1; i++) {
            queue2[size2++] = queue1[i];
        }
        // Swap queue1 and queue2 so queue1 now starts with the newly pushed element
        int[] temp = queue1;
        queue1 = queue2;
        queue2 = temp;
        // queue2 is now the temporary buffer and becomes empty
        size2 = 0;
        // size1 increases by exactly one element (we moved all previous elements)
        size1 = size1 + 1; // Because we just added an element
    }

    /**
     * Removes the element on top of the stack and returns it.
     * If the stack is empty, returns -1 (alternatively could throw exception).
     */
    public int pop() {
        if (size1 == 0) return -1; // empty
        int topVal = queue1[0];
        // Remove the front element by shifting all remaining elements left by one.
        // This keeps the front of queue1 at index 0 for the next call.
        for (int i = 1; i < size1; i++) {
            queue1[i - 1] = queue1[i];
        }
        size1--;
        return topVal;
    }

    /**
     * Returns the element on top of the stack without removing it.
     * Returns -1 if the stack is empty.
     */
    public int top() {
        if (size1 == 0) return -1; // empty
        return queue1[0];
    }

    /**
     * Returns true if the stack is empty.
     */
    public boolean empty() {
        return size1 == 0;
    }

    // Small demonstration and smoke test. You can run this class directly to
    // observe expected behavior of push/pop/top/empty.
    public static void main(String[] args) {
        MyStackWithTwoQueuesWithArrays stack = new MyStackWithTwoQueuesWithArrays();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Top: " + stack.top()); // 30
        System.out.println("Popped: " + stack.pop()); // 30
        System.out.println("Top: " + stack.top()); // 20
        System.out.println("Is Empty: " + stack.empty()); // false
    }
}
