package ru.student.lab2.algorithms;

public final class SortingAlgorithms {
    private SortingAlgorithms() {
    }

    public static void quickSort(int[] array) {
        checkArray(array);
        quickSort(array, 0, array.length - 1);
    }

    public static void mergeSort(int[] array) {
        checkArray(array);
        if (array.length <= 1) {
            return;
        }
        int[] buffer = new int[array.length];
        mergeSort(array, buffer, 0, array.length - 1);
    }

    private static void quickSort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }

        int pivot = array[(left + right) / 2];
        int i = left;
        int j = right;

        while (i <= j) {
            while (array[i] < pivot) {
                i++;
            }
            while (array[j] > pivot) {
                j--;
            }
            if (i <= j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }

        if (left < j) {
            quickSort(array, left, j);
        }
        if (i < right) {
            quickSort(array, i, right);
        }
    }

    private static void mergeSort(int[] array, int[] buffer, int left, int right) {
        if (left >= right) {
            return;
        }

        int middle = (left + right) / 2;
        mergeSort(array, buffer, left, middle);
        mergeSort(array, buffer, middle + 1, right);
        merge(array, buffer, left, middle, right);
    }

    private static void merge(int[] array, int[] buffer, int left, int middle, int right) {
        int i = left;
        int j = middle + 1;
        int k = left;

        while (i <= middle && j <= right) {
            if (array[i] <= array[j]) {
                buffer[k] = array[i];
                i++;
            } else {
                buffer[k] = array[j];
                j++;
            }
            k++;
        }

        while (i <= middle) {
            buffer[k] = array[i];
            i++;
            k++;
        }

        while (j <= right) {
            buffer[k] = array[j];
            j++;
            k++;
        }

        for (int index = left; index <= right; index++) {
            array[index] = buffer[index];
        }
    }

    private static void checkArray(int[] array) {
        if (array == null) {
            throw new IllegalArgumentException("Array must not be null");
        }
    }
}
