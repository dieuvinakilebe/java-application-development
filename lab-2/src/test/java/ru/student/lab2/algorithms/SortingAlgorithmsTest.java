package ru.student.lab2.algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SortingAlgorithmsTest {
    @Test
    void quickSortSortsMixedNumbers() {
        int[] array = {5, -1, 3, 0, 2};

        SortingAlgorithms.quickSort(array);

        assertArrayEquals(new int[]{-1, 0, 2, 3, 5}, array);
    }

    @Test
    void quickSortHandlesEmptyArray() {
        int[] array = {};

        SortingAlgorithms.quickSort(array);

        assertArrayEquals(new int[]{}, array);
    }

    @Test
    void mergeSortSortsArrayWithDuplicates() {
        int[] array = {4, 2, 4, 1, 2};

        SortingAlgorithms.mergeSort(array);

        assertArrayEquals(new int[]{1, 2, 2, 4, 4}, array);
    }

    @Test
    void mergeSortHandlesSingleElementArray() {
        int[] array = {7};

        SortingAlgorithms.mergeSort(array);

        assertArrayEquals(new int[]{7}, array);
    }

    @Test
    void sortingNullArrayThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> SortingAlgorithms.quickSort(null));
        assertThrows(IllegalArgumentException.class, () -> SortingAlgorithms.mergeSort(null));
    }
}
