package ru.student.lab2.collections;

import java.util.NoSuchElementException;

public class MyStack<T> {
    private static final int DEFAULT_CAPACITY = 8;

    private Object[] data;
    private int size;

    public MyStack() {
        this.data = new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    public void push(T value) {
        ensureCapacity(size + 1);
        data[size] = value;
        size++;
    }

    @SuppressWarnings("unchecked")
    public T pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        T value = (T) data[size - 1];
        data[size - 1] = null;
        size--;
        return value;
    }

    @SuppressWarnings("unchecked")
    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        return (T) data[size - 1];
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
            newData[i] = data[i];
        }
        data = newData;
    }
}
