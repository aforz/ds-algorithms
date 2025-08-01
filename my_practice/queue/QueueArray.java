package my_practice.queue;

import java.util.ArrayList;
import java.util.List;

public class QueueArray {
    private int[] arr;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    public QueueArray(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    public void enqueue(int x) {
        if (size == capacity) {
            throw new RuntimeException("Queue is full");
        }
        rear = (rear + 1) % capacity;
        arr[rear] = x;
        size++;
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        int res = arr[front];
        front = (front + 1) % capacity;
        size--;
        return res;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public List<Integer> display() {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            result.add(arr[(front + i) % capacity]);
        }
        return result;
    }

    public static void main(String[] args) {
        QueueArray q = new QueueArray(10);
        q.enqueue(1);
        System.out.println(q.display()); // [1]
        q.enqueue(2);
        System.out.println(q.display()); // [1, 2]
        q.enqueue(3);
        System.out.println(q.display()); // [1, 2, 3]
        q.enqueue(4);
        System.out.println(q.display()); // [1, 2, 3, 4]
        q.dequeue();
        System.out.println(q.display()); // [2, 3, 4]
    }
}
