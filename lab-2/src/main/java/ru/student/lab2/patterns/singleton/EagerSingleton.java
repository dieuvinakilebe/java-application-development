package ru.student.lab2.patterns.singleton;

public final class EagerSingleton {
    private static final EagerSingleton INSTANCE = new EagerSingleton();

    private final long createdAt;

    private EagerSingleton() {
        this.createdAt = System.nanoTime();
    }

    public static EagerSingleton getInstance() {
        return INSTANCE;
    }

    public long getCreatedAt() {
        return createdAt;
    }
}
