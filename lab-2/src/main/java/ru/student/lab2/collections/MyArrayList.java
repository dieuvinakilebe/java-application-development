package ru.student.lab2.collections;

import java.util.NoSuchElementException;

public class MyArrayList<T> {
    private static final int DEFAULT_CAPACITY = 10;

    private Object[] data;
    private int size;

    public MyArrayList() {
        this.data = new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    public void add(T value) {
        ensureCapacity(size + 1);
        data[size] = value;
        size++;
    }

    public void add(int index, T value) {
        checkPositionIndex(index);
        ensureCapacity(size + 1);

        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = value;
        size++;
    }

    @SuppressWarnings("unchecked")
    public T get(int index) {
        checkElementIndex(index);
        return (T) data[index];
    }

    @SuppressWarnings("unchecked")
    public T set(int index, T value) {
        checkElementIndex(index);
        T oldValue = (T) data[index];
        data[index] = value;
        return oldValue;
    }

    @SuppressWarnings("unchecked")
    public T remove(int index) {
        checkElementIndex(index);
        T removed = (T) data[index];

        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        data[size - 1] = null;
        size--;

        return removed;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            data[i] = null;
        }
        size = 0;
    }

    public MyIterator<T> iterator() {
        return new ArrayListIterator();
    }

    private void ensureCapacity(int requiredCapacity) {
        if (requiredCapacity <= data.length) {
            return;
        }

        int newCapacity = data.length * 2;
        if (newCapacity < requiredCapacity) {
            newCapacity = requiredCapacity;
        }

        Object[] newData = new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    private void checkElementIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", size: " + size);
        }
    }

    private void checkPositionIndex(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", size: " + size);
        }
    }

    private class ArrayListIterator implements MyIterator<T> {
        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < size;
        }

        @Override
        @SuppressWarnings("unchecked")
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No next element");
            }
            T value = (T) data[currentIndex];
            currentIndex++;
            return value;
        }
    }
}
