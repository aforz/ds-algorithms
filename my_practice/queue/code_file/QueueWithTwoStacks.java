package my_practice.queue.code_file;

public class QueueWithTwoStacks {
    static final int MAX_SIZE = 1000;
    static int[] stack1 = new int[MAX_SIZE];
    static int[] stack2 = new int[MAX_SIZE];
    static int top1 = -1;
    static int top2 = -1;

    // Enqueue operation
    static void Enqueue(int value) {
        if (top1 >= MAX_SIZE - 1) {
            throw new RuntimeException("Queue Overflow");
        }
        stack1[++top1] = value;
    }

    // Dequeue operation
    static int Dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue Underflow");
        }
        if (top2 == -1) {
            // Transfer elements from stack1 to stack2
            while (top1 != -1) {
                stack2[++top2] = stack1[top1--];
            }
        }
        return stack2[top2--];
    }

    // Peek operation
    static int Peek() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is Empty");
        }
        if (top2 == -1) {
            // Transfer elements from stack1 to stack2
            while (top1 != -1) {
                stack2[++top2] = stack1[top1--];
            }
        }
        return stack2[top2];
    }

    // Check if queue is empty
    static boolean isEmpty() {
        return (top1 == -1 && top2 == -1);
    }

    public static void main(String[] args) {
        QueueWithTwoStacks queue = new QueueWithTwoStacks();

        // Enqueue elements
        queue.Enqueue(10);
        queue.Enqueue(20);
        queue.Enqueue(30);

        // Dequeue elements
        System.out.println("Dequeued: " + queue.Dequeue()); // 10
        System.out.println("Dequeued: " + queue.Dequeue()); // 20

        // Peek at the front element
        System.out.println("Front element: " + queue.Peek()); // 30

        // Dequeue remaining element
        System.out.println("Dequeued: " + queue.Dequeue()); // 30

        // Check if the queue is empty
        System.out.println("Is queue empty? " + queue.isEmpty()); // true
    }
}
