package ru.student.lab2.collections;

public class MyHashMap<K, V> {
    private static final int DEFAULT_CAPACITY = 16;
    private static final double LOAD_FACTOR = 0.75;

    private Node<K, V>[] table;
    private int size;

    @SuppressWarnings("unchecked")
    public MyHashMap() {
        this.table = (Node<K, V>[]) new Node[DEFAULT_CAPACITY];
        this.size = 0;
    }

    public V put(K key, V value) {
        if ((size + 1.0) / table.length > LOAD_FACTOR) {
            resize();
        }

        int index = indexFor(key, table.length);
        Node<K, V> current = table[index];

        while (current != null) {
            if (keysEqual(current.key, key)) {
                V oldValue = current.value;
                current.value = value;
                return oldValue;
            }
            current = current.next;
        }

        Node<K, V> newNode = new Node<>(key, value, table[index]);
        table[index] = newNode;
        size++;
        return null;
    }

    public V get(K key) {
        Node<K, V> node = findNode(key);
        return node == null ? null : node.value;
    }

    public V remove(K key) {
        int index = indexFor(key, table.length);
        Node<K, V> current = table[index];
        Node<K, V> previous = null;

        while (current != null) {
            if (keysEqual(current.key, key)) {
                if (previous == null) {
                    table[index] = current.next;
                } else {
                    previous.next = current.next;
                }
                size--;
                return current.value;
            }
            previous = current;
            current = current.next;
        }

        return null;
    }

    public boolean containsKey(K key) {
        return findNode(key) != null;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private Node<K, V> findNode(K key) {
        int index = indexFor(key, table.length);
        Node<K, V> current = table[index];

        while (current != null) {
            if (keysEqual(current.key, key)) {
                return current;
            }
            current = current.next;
        }

        return null;
    }

    @SuppressWarnings("unchecked")
    private void resize() {
        Node<K, V>[] oldTable = table;
        table = (Node<K, V>[]) new Node[oldTable.length * 2];
        size = 0;

        for (Node<K, V> head : oldTable) {
            Node<K, V> current = head;
            while (current != null) {
                put(current.key, current.value);
                current = current.next;
            }
        }
    }

    private int indexFor(K key, int capacity) {
        int hash = key == null ? 0 : key.hashCode();
        return (hash & 0x7fffffff) % capacity;
    }

    private boolean keysEqual(K first, K second) {
        if (first == second) {
            return true;
        }
        if (first == null || second == null) {
            return false;
        }
        return first.equals(second);
    }

    private static class Node<K, V> {
        private final K key;
        private V value;
        private Node<K, V> next;

        private Node(K key, V value, Node<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
}
