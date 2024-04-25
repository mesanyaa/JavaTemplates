package ru.sejapoe.pr5;


import lombok.Getter;

import java.time.Instant;

@Getter
public class StaticBlockSingleton {
    @Getter
    private static final StaticBlockSingleton instance;

    private final Instant createdAt = Instant.now();

    static {
        instance = new StaticBlockSingleton();
    }
}
