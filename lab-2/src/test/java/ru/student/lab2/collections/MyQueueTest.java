package ru.student.lab2.collections;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MyQueueTest {
    @Test
    void dequeueReturnsFirstAddedElement() {
        MyQueue<String> queue = new MyQueue<>();
        queue.enqueue("first");
        queue.enqueue("second");

        assertEquals("first", queue.dequeue());
        assertEquals("second", queue.dequeue());
        assertTrue(queue.isEmpty());
    }

    @Test
    void peekReturnsFirstElementWithoutRemovingIt() {
        MyQueue<Integer> queue = new MyQueue<>();
        queue.enqueue(10);
        queue.enqueue(20);

        assertEquals(10, queue.peek());
        assertEquals(2, queue.size());
    }

    @Test
    void dequeueFromEmptyQueueThrowsException() {
        MyQueue<Integer> queue = new MyQueue<>();

        assertThrows(NoSuchElementException.class, queue::dequeue);
    }

    @Test
    void peekFromEmptyQueueThrowsException() {
        MyQueue<Integer> queue = new MyQueue<>();

        assertThrows(NoSuchElementException.class, queue::peek);
    }

    @Test
    void queueGrowsAndKeepsFifoOrder() {
        MyQueue<Integer> queue = new MyQueue<>();

        for (int i = 0; i < 20; i++) {
            queue.enqueue(i);
        }

        for (int i = 0; i < 20; i++) {
            assertEquals(i, queue.dequeue());
        }
    }
}
