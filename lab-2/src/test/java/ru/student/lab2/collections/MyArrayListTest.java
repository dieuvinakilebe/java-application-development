package ru.student.lab2.collections;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MyArrayListTest {
    @Test
    void addAndGetElements() {
        MyArrayList<String> list = new MyArrayList<>();

        list.add("first");
        list.add("second");

        assertEquals(2, list.size());
        assertEquals("first", list.get(0));
        assertEquals("second", list.get(1));
    }

    @Test
    void setChangesElementAndReturnsOldValue() {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(10);
        list.add(20);

        Integer oldValue = list.set(1, 99);

        assertEquals(20, oldValue);
        assertEquals(99, list.get(1));
    }

    @Test
    void removeShiftsElementsToLeft() {
        MyArrayList<String> list = new MyArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");

        String removed = list.remove(1);

        assertEquals("B", removed);
        assertEquals(2, list.size());
        assertEquals("C", list.get(1));
    }

    @Test
    void invalidIndexThrowsException() {
        MyArrayList<Integer> list = new MyArrayList<>();

        assertThrows(IndexOutOfBoundsException.class, () -> list.get(0));
        assertThrows(IndexOutOfBoundsException.class, () -> list.add(1, 10));
    }

    @Test
    void clearMakesListEmpty() {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(1);
        list.add(2);

        list.clear();

        assertTrue(list.isEmpty());
        assertEquals(0, list.size());
        assertFalse(list.iterator().hasNext());
    }
}
