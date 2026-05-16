package ru.student.lab2.collections;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MyStackTest {
    @Test
    void popReturnsLastAddedElement() {
        MyStack<String> stack = new MyStack<>();
        stack.push("first");
        stack.push("second");

        assertEquals("second", stack.pop());
        assertEquals("first", stack.pop());
        assertTrue(stack.isEmpty());
    }

    @Test
    void peekReturnsElementWithoutRemovingIt() {
        MyStack<Integer> stack = new MyStack<>();
        stack.push(10);
        stack.push(20);

        assertEquals(20, stack.peek());
        assertEquals(2, stack.size());
    }

    @Test
    void popFromEmptyStackThrowsException() {
        MyStack<Integer> stack = new MyStack<>();

        assertThrows(NoSuchElementException.class, stack::pop);
    }

    @Test
    void peekFromEmptyStackThrowsException() {
        MyStack<Integer> stack = new MyStack<>();

        assertThrows(NoSuchElementException.class, stack::peek);
    }

    @Test
    void stackGrowsWhenManyElementsAreAdded() {
        MyStack<Integer> stack = new MyStack<>();

        for (int i = 0; i < 20; i++) {
            stack.push(i);
        }

        assertEquals(20, stack.size());
        assertEquals(19, stack.pop());
    }
}
