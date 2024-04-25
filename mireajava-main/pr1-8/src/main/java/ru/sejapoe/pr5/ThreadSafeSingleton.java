package ru.sejapoe.pr5;

import lombok.Getter;

import java.time.Instant;

@Getter
public class ThreadSafeSingleton {
    private static ThreadSafeSingleton instance;

    private final Instant createdAt = Instant.now();

    public static synchronized ThreadSafeSingleton getInstance() {
        if (instance == null) {
            instance = new ThreadSafeSingleton();
        }
        return instance;
    }
}
