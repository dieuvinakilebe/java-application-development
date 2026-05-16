package ru.student.lab2.algorithms;

public final class BinarySearch {
    private BinarySearch() {
    }

    public static int search(int[] array, int target) {
        if (array == null) {
            throw new IllegalArgumentException("Array must not be null");
        }

        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int middle = left + (right - left) / 2;

            if (array[middle] == target) {
                return middle;
            }
            if (array[middle] < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        return -1;
    }
}
