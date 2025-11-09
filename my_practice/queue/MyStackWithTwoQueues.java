package my_practice.queue;

import java.util.LinkedList;
import java.util.Queue;

//Problem: https://leetcode.com/problems/implement-stack-using-queues/description/?ref=bosscoder-academy-2.ghost.io
class MyStackWithTwoQueues {

    private Queue<Integer> q1;
    private Queue<Integer> q2;

    public MyStackWithTwoQueues() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    public void push(int x) {
        q2.offer(x); // push to q2
        // move all elements from q1 to q2
        while (!q1.isEmpty()) {
            q2.offer(q1.poll());
        }
        // swap q1 and q2
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }

    public int pop() {
        return q1.poll();
    }

    public int top() {
        return q1.peek();
    }

    public boolean empty() {
        return q1.isEmpty();
    }

    public static void main(String[] args) {
        MyStackWithTwoQueues stack = new MyStackWithTwoQueues();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Top: " + stack.top()); // 30
        System.out.println("Popped: " + stack.pop()); // 30
        System.out.println("Top: " + stack.top()); // 20
        System.out.println("Is Empty: " + stack.empty()); // false
    }
}
