package ru.student.lab2.algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BinarySearchTest {
    @Test
    void searchFindsExistingElement() {
        int[] array = {1, 3, 5, 7, 9};

        int index = BinarySearch.search(array, 7);

        assertEquals(3, index);
    }

    @Test
    void searchReturnsMinusOneWhenElementIsAbsent() {
        int[] array = {1, 3, 5, 7, 9};

        int index = BinarySearch.search(array, 4);

        assertEquals(-1, index);
    }

    @Test
    void searchInEmptyArrayReturnsMinusOne() {
        int[] array = {};

        int index = BinarySearch.search(array, 10);

        assertEquals(-1, index);
    }

    @Test
    void searchFindsFirstAndLastElements() {
        int[] array = {2, 4, 6, 8};

        assertEquals(0, BinarySearch.search(array, 2));
        assertEquals(3, BinarySearch.search(array, 8));
    }

    @Test
    void nullArrayThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> BinarySearch.search(null, 1));
    }
}
