package ru.student.lab2.patterns.singleton;

public final class LazySingleton {
    private static volatile LazySingleton instance;

    private final long createdAt;

    private LazySingleton() {
        this.createdAt = System.nanoTime();
    }

    public static LazySingleton getInstance() {
        if (instance == null) {
            synchronized (LazySingleton.class) {
                if (instance == null) {
                    instance = new LazySingleton();
                }
            }
        }
        return instance;
    }

    public long getCreatedAt() {
        return createdAt;
    }
}
