package ru.student.lab2.collections;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MyIteratorTest {
    @Test
    void iteratorTraversesAllElements() {
        MyArrayList<String> list = new MyArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");

        MyIterator<String> iterator = list.iterator();

        assertTrue(iterator.hasNext());
        assertEquals("A", iterator.next());
        assertEquals("B", iterator.next());
        assertEquals("C", iterator.next());
        assertFalse(iterator.hasNext());
    }

    @Test
    void iteratorOnEmptyListHasNoNextElement() {
        MyArrayList<Integer> list = new MyArrayList<>();

        MyIterator<Integer> iterator = list.iterator();

        assertFalse(iterator.hasNext());
    }

    @Test
    void nextAfterLastElementThrowsException() {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(5);
        MyIterator<Integer> iterator = list.iterator();

        assertEquals(5, iterator.next());
        assertThrows(NoSuchElementException.class, iterator::next);
    }
}
