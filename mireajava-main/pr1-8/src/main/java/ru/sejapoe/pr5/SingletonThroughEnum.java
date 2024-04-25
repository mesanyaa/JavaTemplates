package ru.sejapoe.pr5;

import lombok.Getter;

import java.time.Instant;


@Getter
public enum SingletonThroughEnum {
    INSTANCE;

    private final Instant createdAt = Instant.now();

    public static SingletonThroughEnum getInstance() {
        return INSTANCE;
    }
}
