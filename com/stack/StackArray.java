package com.stack;

public class StackArray {
    int[] arr;
    int top;
    int capacity;

    public void StackArray(int capacity){
        this.capacity = capacity;
        top = -1;
        arr = new int[capacity];
    }

    public void push(int item){
        if (top == capacity - 1){
            throw new RuntimeException("Stock is full");
        }
        arr[++top] = item;
    }

    public int pop(){
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return arr[top--];
    }

    boolean isEmpty() {
        return top == -1;
    }

    public static void main(String[] args) {
        StackArray stack = new StackArray();
        stack.StackArray(5);

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Popped: " + stack.pop()); // 30
        System.out.println("Popped: " + stack.pop()); // 20
        System.out.println("Popped: " + stack.pop()); // 10

        // Uncommenting the next line will throw an exception
        // System.out.println("Popped: " + stack.pop()); // Stack is empty
    }
}
