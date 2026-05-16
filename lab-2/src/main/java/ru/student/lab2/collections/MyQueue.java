package ru.student.lab2.collections;

import java.util.NoSuchElementException;

public class MyQueue<T> {
    private static final int DEFAULT_CAPACITY = 8;

    private Object[] data;
    private int head;
    private int tail;
    private int size;

    public MyQueue() {
        this.data = new Object[DEFAULT_CAPACITY];
        this.head = 0;
        this.tail = 0;
        this.size = 0;
    }

    public void enqueue(T value) {
        ensureCapacity(size + 1);
        data[tail] = value;
        tail = (tail + 1) % data.length;
        size++;
    }

    @SuppressWarnings("unchecked")
    public T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        T value = (T) data[head];
        data[head] = null;
        head = (head + 1) % data.length;
        size--;
        return value;
    }

    @SuppressWarnings("unchecked")
    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return (T) data[head];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void ensureCapacity(int requiredCapacity) {
        if (requiredCapacity <= data.length) {
            return;
        }

        Object[] newData = new Object[data.length * 2];
        for (int i = 0; i < size; i++) {
            newData[i] = data[(head + i) % data.length];
        }

        data = newData;
        head = 0;
        tail = size;
    }
}
