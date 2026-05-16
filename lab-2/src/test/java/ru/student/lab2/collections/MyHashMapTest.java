package ru.student.lab2.collections;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MyHashMapTest {
    @Test
    void putAndGetValueByKey() {
        MyHashMap<String, Integer> map = new MyHashMap<>();

        map.put("one", 1);
        map.put("two", 2);

        assertEquals(1, map.get("one"));
        assertEquals(2, map.get("two"));
        assertEquals(2, map.size());
    }

    @Test
    void putExistingKeyUpdatesValue() {
        MyHashMap<String, String> map = new MyHashMap<>();

        assertNull(map.put("name", "old"));
        String previous = map.put("name", "new");

        assertEquals("old", previous);
        assertEquals("new", map.get("name"));
        assertEquals(1, map.size());
    }

    @Test
    void removeDeletesPair() {
        MyHashMap<String, Integer> map = new MyHashMap<>();
        map.put("x", 10);
        map.put("y", 20);

        Integer removed = map.remove("x");

        assertEquals(10, removed);
        assertNull(map.get("x"));
        assertEquals(1, map.size());
    }

    @Test
    void collisionIsHandledByChain() {
        MyHashMap<BadHashKey, String> map = new MyHashMap<>();
        BadHashKey first = new BadHashKey("first");
        BadHashKey second = new BadHashKey("second");

        map.put(first, "A");
        map.put(second, "B");

        assertEquals("A", map.get(first));
        assertEquals("B", map.get(second));
        assertTrue(map.containsKey(first));
        assertTrue(map.containsKey(second));
    }

    @Test
    void nullKeyIsSupported() {
        MyHashMap<String, Integer> map = new MyHashMap<>();

        map.put(null, 100);

        assertEquals(100, map.get(null));
        assertTrue(map.containsKey(null));
        assertFalse(map.isEmpty());
    }

    private static class BadHashKey {
        private final String value;

        private BadHashKey(String value) {
            this.value = value;
        }

        @Override
        public int hashCode() {
            return 1;
        }

        @Override
        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof BadHashKey key)) {
                return false;
            }
            return value.equals(key.value);
        }
    }
}
