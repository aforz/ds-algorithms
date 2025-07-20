package com.queue.code_file;

import java.util.*;
import java.util.NoSuchElementException;

public class QueueImplementation {
    static ArrayList<Integer> queue = new ArrayList<>();
    static int front = 0;

    static void Enqueue(int value) {
        queue.add(value);
    }

    static int Dequeue() {
        if (is_Empty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        int val = queue.get(front);
        queue.remove(front);
        return val;
    }

    static boolean is_Empty() {
        return queue.isEmpty();
    }

    // Utility to display the current queue contents
    static List<Integer> display() {
        return new ArrayList<>(queue);
    }
}
