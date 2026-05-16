package ru.student.lab2.patterns.singleton;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LazySingletonTest {
    @Test
    void getInstanceReturnsObject() {
        LazySingleton instance = LazySingleton.getInstance();

        assertNotNull(instance);
    }

    @Test
    void getInstanceAlwaysReturnsSameObject() {
        LazySingleton first = LazySingleton.getInstance();
        LazySingleton second = LazySingleton.getInstance();

        assertSame(first, second);
    }

    @Test
    void createdAtIsSameForAllCalls() {
        LazySingleton first = LazySingleton.getInstance();
        LazySingleton second = LazySingleton.getInstance();

        assertTrue(first.getCreatedAt() > 0);
        assertSame(first, second);
    }

    @Test
    void singletonIsThreadSafe() throws InterruptedException {
        LazySingleton[] instances = new LazySingleton[20];
        Thread[] threads = new Thread[20];

        for (int i = 0; i < threads.length; i++) {
            final int index = i;
            threads[i] = new Thread(() -> instances[index] = LazySingleton.getInstance());
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        LazySingleton expected = instances[0];
        for (LazySingleton instance : instances) {
            assertSame(expected, instance);
        }
    }
}
