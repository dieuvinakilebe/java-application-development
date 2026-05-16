package ru.student.lab2.patterns.singleton;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

class EagerSingletonTest {
    @Test
    void getInstanceReturnsObject() {
        EagerSingleton instance = EagerSingleton.getInstance();

        assertNotNull(instance);
    }

    @Test
    void getInstanceAlwaysReturnsSameObject() {
        EagerSingleton first = EagerSingleton.getInstance();
        EagerSingleton second = EagerSingleton.getInstance();

        assertSame(first, second);
    }

    @Test
    void createdAtIsSameForAllCalls() {
        EagerSingleton first = EagerSingleton.getInstance();
        EagerSingleton second = EagerSingleton.getInstance();

        assertEquals(first.getCreatedAt(), second.getCreatedAt());
    }

    @Test
    void constructorIsPrivate() {
        Constructor<?>[] constructors = EagerSingleton.class.getDeclaredConstructors();

        assertEquals(1, constructors.length);
        assertTrue(Modifier.isPrivate(constructors[0].getModifiers()));
    }
}
